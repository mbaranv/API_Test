package allRequest;

import datasPojo.OrganizationStatusServicePostPojo;
import datasPojo.OrganizationStatusServicePutPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestConfiguration;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class OrganizationStatusService extends TestConfiguration {
    public static JsonPath jsonPath;

    public static int  postReqId;

    @Test
    public void TC_001(){
        extentTest=extentReports.createTest("Get All Status Service","GET Request");

        extentTest.info("URL'e gidilip token alınıyor");
        extentTest.info("Token alma işlemi başarılı");

        extentTest.info("TC01 için URL set edildi");
        specification.pathParam("org.path","organization-status");

        extentTest.info("GET metodu ile request atıldı");
        Response response=given().spec(specification).when().
                header("Authorization","Bearer "+access_token).get("/{org.path}");

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

        extentTest.info("Requestin başarılı olduğu doğrulandı.");
        response.then().assertThat().statusCode(200);

        extentTest.pass("Test sonlandı");
    }

    @Test
    public void TC_002(){
        extentTest=extentReports.createTest("Create Status Service","POST Request");
        OrganizationStatusServicePostPojo pojo=new OrganizationStatusServicePostPojo("Team06 active","new status activeted",true);

        System.out.println("pojo = " + pojo);
        extentTest.info("TC02 için URL set edildi");


        String url = "https://a3m-qa-gm3.quaspareparts.com/auth/api/";

        String userStatusUrl = url + "organization-status";
        extentTest.info("POST metodu ile request atıldı");
        Response  response = given().headers("Authorization",
                        "Bearer " + TestConfiguration.access_token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body(pojo) // this comes from JsonModels class for Country and Status
                .post(userStatusUrl)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        extentTest.info("Yeni Status Service oluşturuldu");

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

        extentTest.info("Requestin başarılı olduğu doğrulandı.");
        response.then().assertThat().statusCode(201);

        Map<String,String> actualDataAndResponseBody = response.as(Map.class);
        System.out.println("actualDataAndResponseBody: " + actualDataAndResponseBody);

        JsonPath jsonPath1 = response.jsonPath();
        postReqId=jsonPath1.get("id");
        System.out.println("postReqId = " + postReqId);

        Assert.assertEquals(jsonPath1.getString("name"),actualDataAndResponseBody.get("name"));
        Assert.assertEquals(jsonPath1.getString("description"),actualDataAndResponseBody.get("description"));
        extentTest.info("Expected Data ile Actual Data karşılaştırıldı...");

        extentTest.pass("Test sonlandı");
    }

    @Test
    public void TC_003(){
        extentTest=extentReports.createTest("Update Status Service","PUT Request");

        OrganizationStatusServicePutPojo pojo=new OrganizationStatusServicePutPojo("Team06 active update","new status updated",true,postReqId);

        extentTest.info("TC03 için URL set edildi");
        specification.pathParam("org.path","organization-status");

        extentTest.info("PUT metodu ile request atıldı");
        Response response=given().spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+access_token).body(pojo).
        put("/{org.path}");

        extentTest.info("Status Service udpate edildi");

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

        extentTest.info("Requestin başarılı olduğu doğrulandı.");
        response.then().assertThat().statusCode(200);

        Map<String,String> actualDataAndResponseBody = response.as(Map.class);
        System.out.println("actualDataAndResponseBody: " + actualDataAndResponseBody);

        JsonPath jsonPath1 = response.jsonPath();

        Assert.assertEquals(jsonPath1.getString("name"),actualDataAndResponseBody.get("name"));
        Assert.assertEquals(jsonPath1.getInt("id"),actualDataAndResponseBody.get("id"));

        extentTest.info("Expected Data ile Actual Data karşılaştırıldı...");

        extentTest.pass("Test sonlandı");
    }

    @Test
    public void TC_004(){
        extentTest=extentReports.createTest("Delete Status Service","DELETE Request");



        extentTest.info("TC04 için URL set edildi");
        specification.pathParams("org.path","organization-status","id",postReqId);

        extentTest.info("DELETE metodu ile request atıldı");
        Response response=given().spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+access_token).
                delete("/{org.path}/{id}");



        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

        extentTest.info("Requestin başarılı olduğu doğrulandı.");
        response.then().assertThat().statusCode(200);


        extentTest.pass("Test sonlandı");
    }














}
