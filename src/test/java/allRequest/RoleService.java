package allRequest;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestConfiguration;

import static io.restassured.RestAssured.given;

public class RoleService extends TestConfiguration {


    @Test
    public void GET_TC001_GetAllRoleAppId() {
       extentTest = extentReports.createTest("Get All Role App Id","Description");
       extentTest.info("URL set edildi ");

       extentTest.info("GET methodu ile request gönderildi");

        specification.pathParams("rolePath","role","appIdPath",2);
        String URL="https://a3m-qa-gm3.quaspareparts.com/auth/api/application/2/role";

        Response response = given().
                spec(specification).
                when().
                header("Authorization", "Bearer " + access_token).
                get("/{rolePath}/{appIdPath}");

        extentTest.info("Response yazdırıldı");
        System.out.println("response = " + response);
        response.prettyPrint();

        extentTest.info("Assertion işlemi yapıldı");
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        extentTest.pass("Testimiz gecerli");
    }



  @Test
  public void GET_TC002_GetAllRole(){
   extentTest = extentReports.createTest("Get All Roles","Description2");
   extentTest.info("URL set edildi ");
   specification.pathParam("rolePath","role");
   extentTest.info("GET methodu ile request gönderildi");
      Response response = given().
              spec(specification).
              when().
              header("Authorization", "Bearer " + access_token).
              get("/{rolePath}");

      extentTest.info("Response yazdırıldı");
      response.prettyPrint();

      extentTest.info("Assertion işlemi yapıldı");
      response.then().assertThat().statusCode(200);
      System.out.println("response.getStatusCode() = " + response.getStatusCode());

      extentTest.pass("Testimiz gecerli");

  }

@Test
public void GET_TC003_GetRoleId(){

    extentTest = extentReports.createTest("Get Role by Id","Description3");
    extentTest.info("URL set edildi ");
    // specification.pathParams("rolePath","role","appIdPath",2);
    extentTest.info("GET methodu ile request gönderildi");
   // String URL="https://a3m-qa-gm3.quaspareparts.com/auth/api/role/30";

    specification.pathParams("rolePath","role","idPath",30);


    Response response = given().
            spec(specification).
            when().
            header("Authorization", "Bearer " + access_token).
            get("/{rolePath}/{idPath}");

    extentTest.info("Response yazdırıldı");
    System.out.println("response = " + response);
    response.prettyPrint();

    extentTest.info("Assertion işlemi yapıldı");
    response.then().assertThat().statusCode(200);
    System.out.println("response.getStatusCode() = " + response.getStatusCode());
    extentTest.pass("Testimiz gecerli");
}

    @Test
    public void GET_TC004_AddNewRole(){

        extentTest = extentReports.createTest("Add New Role","Description4");
        extentTest.info("URL set edildi ");

        extentTest.info("POST methodu ile request gönderildi");

        specification.pathParams("rolePath","role");

        Response response = given().
                spec(specification).
                when().
                header("Authorization", "Bearer " + access_token).
                post("{rolePath}");

        extentTest.info("Response yazdırıldı");
        System.out.println("response = " + response);
        response.prettyPrint();

        extentTest.info("Assertion işlemi yapıldı");
        response.then().assertThat().statusCode(415);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        extentTest.pass("Testimiz gecerli");
    }



}
