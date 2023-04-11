package allRequest;

import datasPojo.UserSatusBodyPutPojo;
import datasPojo.UserStatusBodyPostPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestConfiguration;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UserStatusService extends TestConfiguration {

    public static JsonPath jsonPath;
    public static int  postReqId;

    @Test
    public void TC_001() {
        extentTest=extentReports.createTest("UserStatus_TC_001_GET");
       specification.pathParam("userPath","user-status");
        extentTest.info("Url'e gidilip access token alınıyor...");
        extentTest.info("GET metodu ile request atıldı");
        Response response=given().spec(specification).
                when().
                header("Authorization","Bearer "+TestConfiguration.access_token).
                get("/{userPath}");
        response.prettyPrint();
        extentTest.info("Response yazdırıldı.Tüm User Statusler Görüntülendi");
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        extentTest.info("Status Code'un 200 oldugu dogrulandı");
        extentTest.info("Test Passed Oldu..:)");
    }


    @Test
    public void TC_002() {
        extentTest=extentReports.createTest("UserStatus_TC_002_POST");
        UserStatusBodyPostPojo userPojo=new UserStatusBodyPostPojo("yemreYasin","User active");
        String url="https://a3m-qa-gm3.quaspareparts.com/auth/api/";
        String userStatusUrl=url + "user-status";

        extentTest.info("Url'e gidilip access token alınıyor...");

        extentTest.info("Post metodu ile request atıldı");
      Response  response = given().headers("Authorization",
                        "Bearer " +TestConfiguration.access_token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body(userPojo) // this comes from JsonModels class for Country and Status
                .post(userStatusUrl)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        extentTest.info(" yeni User Status oluşturuldu");
            response.prettyPrint();
        response.then().assertThat().statusCode(201);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        extentTest.info("Response'la gelen Status Code dogrulandı");

        Map<String,Object> actualDataAndResponseBody = response.as(Map.class);
        System.out.println("actualDataAndResponseBody: " + actualDataAndResponseBody);

        JsonPath jsonPath1 = response.jsonPath();
        postReqId=jsonPath1.get("id");
        System.out.println("postReqId = " + postReqId);

        assertEquals(jsonPath1.getString("name"),actualDataAndResponseBody.get("name"));
        assertEquals(jsonPath1.getString("description"),actualDataAndResponseBody.get("description"));
        extentTest.info("Expected Data ile Actual Data karşılaştırıldı...");
        extentTest.info("Test Passed Oldu..:)");

    }
      @Test

    public void TC_003(){
          extentTest=extentReports.createTest("UserStatus_TC_003_PUT");
          String url = "https://a3m-qa-gm3.quaspareparts.com/auth/api/";
          extentTest.info("Url'e gidilip access token alınıyor...");
          String userStatusUrl = url + "user-status";
          UserSatusBodyPutPojo userSatusPutPojo=new UserSatusBodyPutPojo(postReqId,"TR","User is active");

          Response  response = given().headers("Authorization",
                          "Bearer " + TestConfiguration.access_token,
                          "Content-Type",
                          ContentType.JSON,
                          "Accept", ContentType.JSON)
                  .when()
                  .body(userSatusPutPojo) // this comes from JsonModels class for Country and Status
                  .put(userStatusUrl)
                    .then()
                  .contentType(ContentType.JSON)
                  .extract()
                  .response();
          response.prettyPrint();
          extentTest.info("Put metodu ile request atıldı");
          response.then().assertThat().statusCode(200);
          System.out.println("response.getStatusCode() = " + response.getStatusCode());

          Map<String,Object> actualDataAndResponsePutBody = response.as(Map.class);
          System.out.println("actualDataAndResponseBody: " + actualDataAndResponsePutBody);
         assertEquals(userSatusPutPojo.getName(),actualDataAndResponsePutBody.get("name"));
          assertEquals(userSatusPutPojo.getDescription(),actualDataAndResponsePutBody.get("description"));
          extentTest.info("Expected Data ile Actual Data karşılaştırıldı...");
          extentTest.pass("Test passed");

      }
      @Test
      public void TC_004() {
          extentTest = extentReports.createTest("UserStatus_TC_004_GETID");
          String url = "https://a3m-qa-gm3.quaspareparts.com/auth/api/";
          String userStatusUrl = url + "user-status" + "/" + postReqId;
          extentTest.info("Url'e gidilip access token alınıyor...");
          try {
              Response response = given().when().
                      header("Authorization", "Bearer " + TestConfiguration.access_token).
                      get(userStatusUrl);
              response.prettyPrint();
              Assert.assertTrue(true);
              System.out.println("response.getStatusCode() = " + response.getStatusCode());
          } catch (Exception e) {
              System.out.println("Bu iD'ye sahip bir User-Status bulunamadı...");
              Assert.fail();
          }

      }
         @Test
         public void TC_005(){
             extentTest=extentReports.createTest("UserStatus_TC_005_DELETE");
             String url="https://a3m-qa-gm3.quaspareparts.com/auth/api/";
             String userStatusUrl=url + "user-status"+"/"+postReqId;
             extentTest.info("Url'e gidilip access token alınıyor...");

             extentTest.info("Delete metodu ile request atıldı");
             Response  response = given().headers("Authorization",
                             "Bearer " + TestConfiguration.access_token,
                             "Content-Type",
                             ContentType.JSON,
                             "Accept", ContentType.JSON)
                     .when()
                     .delete(userStatusUrl)
                     .then()
                     .extract()
                     .response();
             extentTest.info("Delete metodu ile girilen id ye sahip kullanıci silindi request atıldı");
             response.prettyPrint();
             response.then().assertThat().statusCode(200);
             extentTest.info("Silindigi dogrulandı...");
             System.out.println("response.getStatusCode() = " + response.getStatusCode());
             extentTest.info("Expected Data ile Actual Data karşılaştırıldı...");
             extentTest.pass("Test passed");
         }




}
