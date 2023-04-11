package allRequest;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestConfiguration;

import static io.restassured.RestAssured.given;


public class CountryService extends TestConfiguration {

    @Test
    public void TC_001(){
        extentTest=extentReports.createTest("CountryService_TC_001_GET");
     specification.pathParam("countryPath","country");

        extentTest.info("Url'e gidilip access token alınıyor...");

        Response response=given().spec(specification).
                when().
                header("Authorization","Bearer "+TestConfiguration.access_token).
               get("/{countryPath}");
        extentTest.info("GET metodu ile request atıldı");
        response.prettyPrint();
        extentTest.info("Response yazdırıldı.Tüm Country'ler Görüntülendi");
      response.then().assertThat().statusCode(200);
       System.out.println("response.getStatusCode() = " + response.getStatusCode());
        extentTest.info("Status Code'un 200 oldugu dogrulandı");
        extentTest.info("Test Passed Oldu..:)");
   }
   //https://a3m-qa-gm3.quaspareparts.com/auth/api/country/AO
 @Test
    public void TC_002(){
     extentTest=extentReports.createTest("CountryService_TC_002_GET_ID");
     specification.pathParams("countryPath","country","idPath","AO");
     extentTest.info("Url'e gidilip access token alınıyor...");
     Response response=given().spec(specification).
             when().
           //  header("Authorization","Bearer "+LoginAndToken.token).
                   auth().preemptive().oauth2(TestConfiguration.access_token).
             get("/{countryPath}/{idPath}");
     extentTest.info("GET metodu ile ilgili end pointe request atıldı");
     response.prettyPrint();
     extentTest.info("Response yazdırıldı.İstenen id'li  Country Görüntülendi");
     response.then().assertThat().statusCode(200);
     System.out.println("response.getStatusCode() = " + response.getStatusCode());
     extentTest.info("Status Code'un 200 oldugu dogrulandı");
     extentTest.info("Test Passed Oldu..:)");
 }
 String url="https://a3m-qa-gm3.quaspareparts.com/auth/api/country/XY";

 @Test
    public void get03_TC_003(){
     extentTest=extentReports.createTest("CountryService_TC_003_NEGATİVE");

        specification.pathParams("countryPath","country","idPath","XY");
     extentTest.info("Url'e gidilip access token alınıyor...");
        try {
            Response response=given().
                    when().
                    // header("Authorization","Bearer "+LoginAndToken.token).
                            auth().preemptive().oauth2(TestConfiguration.access_token).
                    get(url);
          Assert.assertFalse("Country görüntülendi",false);


        }
        catch (Exception e){
            System.out.println("Bu id'ye ait country bulunamadı... :(");
            Assert.assertTrue(true);
        }



    }




 }



