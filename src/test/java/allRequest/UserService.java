package allRequest;

import datasPojo.UserServicePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.ConfigReader;
import utilities.JsonToJava;
import utilities.TestConfiguration;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class UserService extends TestConfiguration {
    HashMap<String, Object> responseBody;
    public static String newUserID = "406";

    @Test //Get All Users
    public void TC001() {
        extentTest = extentReports.createTest("User Service TC001", "TC001_GET_GetAllUsers");

        extentTest.info("URL set edildi");
        specification.pathParam("userPath", "user");

        extentTest.info("GET metodu ile request atıldı");
        Response response = given().
                spec(specification).
                when().
                header("Authorization", "Bearer " + access_token).
                get("/{userPath}");

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

        int statusCode = response.getStatusCode();
        extentTest.info("Assertion işlemleri yapıldı." + " StatusCode=" + statusCode);
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        extentTest.pass("Testimiz gecerli");
    }

    @Test//Get All Users of Organization
    public void TC002() {
        extentTest = extentReports.createTest("User Service TC002", "TC002_GET_GetAllUsersofOrganization");
        extentTest.info("URL set edildi");

        //String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user?organizationId=1";
        specification.pathParam("userPath", "user").
                queryParam("organizationId", 186);

        extentTest.info("GET metodu ile request atıldı");
        Response response = given().
                spec(specification).
                when().
                header("Authorization", "Bearer " + access_token).
                get("/{userPath}");

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();
        int statusCode = response.getStatusCode();

        extentTest.info("Assertion işlemleri yapıldı." + " StatusCode=" + statusCode);

        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        extentTest.pass("Testimiz gecerli");
    }

  

   
}
