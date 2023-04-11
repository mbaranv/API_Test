package allRequest;

import datasPojo.MembershipTypeServicePojo;
import datasPojo.MembershipTypeServicePutPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;
import utilities.TestConfiguration;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class MembershipTypeService extends TestConfiguration {

    HashMap<String, Object> MembershipTypeData;


    @Test
    public void TC001_MembershipTypeAppID(){
        specification.pathParams( "applicationPath","application","idPath", 2 ,"MembershiptypePath","membership-type");
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                get("/{applicationPath}/{idPath}/{MembershiptypePath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }




    @Test
    public void TC002_MembershipType(){
        specification.pathParam( "MembershiptypePath","membership-type");
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                get("/{MembershiptypePath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

    }



    @Test
    public void TC003_NewUser() {
        extentTest = extentReports.createTest("My Test3","Description3");
        extentTest.info("URL set edildi");

        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/membership-type";

        MembershipTypeServicePojo requestBody = new MembershipTypeServicePojo("Trabzonspor","true",2  );


        extentTest.info("POST metodu ile request atıldı");
        Response response = given().
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + access_token).
                body(requestBody).
                when().
                post(URL);

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

       HashMap<String,Object> responseBody = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        String newUserName = responseBody.get("name").toString();
        System.out.println("newUserName = " + newUserName);

        System.out.println("expectedDataMap = " + requestBody);
        System.out.println("actualDataMap = " + responseBody.toString());


        extentTest.info("Assertion işlemleri yapıldı");
        response.then().assertThat().statusCode(201);
        assertEquals(requestBody.getName(), responseBody.get("name"));
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        //Pass mesaji
        extentTest.pass("Testimiz gecerli");





    }
    @Test
    public void TC004_UpdateExistingUser() {
        extentTest = extentReports.createTest("My Test4","Description4");
       MembershipTypeServicePutPojo requestPutPojo = new MembershipTypeServicePutPojo(31,"Team 16","false",2);

        extentTest.info("URL set edildi");
        specification.pathParam("MembershiptypePath", "membership-type");

        extentTest.info("PUT metodu ile request atıldı");
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + access_token).
                body(requestPutPojo).
                when().
                put("/{MembershiptypePath}");

        extentTest.info("Response yazdırıldı");
        response.prettyPrint();

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        HashMap<String,Object> responseBody = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        extentTest.info("Assertion işlemleri yapıldı");
        response.then().assertThat().statusCode(200);
        assertEquals(requestPutPojo.getName(), responseBody.get("name"));
    }
    @Test
    public void TC005_MembershipTypeID(){
        specification.pathParams(  "MembershiptypePath","membership-type","idPath",70);
//        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/membership-type/30";
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                get("/{MembershiptypePath}/{idPath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

    }

    @Test
    public void TC006_MembershipTypeDelete(){
        specification.pathParams(  "MembershiptypePath","membership-type","idPath",63);
//        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/membership-type/30";
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                delete("/{MembershiptypePath}/{idPath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

    }





















}
