package tests;

import io.restassured.response.Response;
import models.RegistrationDTO;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import util.BaseApiTest;
import static org.assertj.core.api.Java6Assertions.*;

public class Basic_Api_Test extends BaseApiTest
{
    @Test
    public void getWeatherDetails()
    {
        String responseBody = get("/Hyderabad").getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
    }

    @Test
    public void createANewUser()
    {
        RegistrationDTO registrationObject = new RegistrationDTO();
        registrationObject.newInstance();

        Response register = post("/register", registrationObject);

        System.out.println(register.getBody().asString());
        assertThat(register.getStatusCode()).isEqualTo(HttpStatus.SC_CREATED);
    }
}
