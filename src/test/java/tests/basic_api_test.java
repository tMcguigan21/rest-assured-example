import io.restassured.response.Response;
import models.Registration;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import util.GenericRest;
import static org.assertj.core.api.Java6Assertions.*;

public class basic_api_test
{
    @Test
    public void getWeatherDetails()
    {
        GenericRest api = new GenericRest();
        String responseBody = api.get("/Hyderabad").getBody().asString();

        System.out.println("Response Body is =>  " + responseBody);
    }

    @Test
    public void createANewUser()
    {
        GenericRest api = new GenericRest();
        Registration registrationObject = new Registration();

        registrationObject.setFirstName("Virender");
        registrationObject.setLastName("Singh");
        registrationObject.setUserName("63userf2d3d2011");
        registrationObject.setPassword("password1");
        registrationObject.setEmail("ed26dff39@gmail.com");

        Response register = api.post("/register", registrationObject);

        System.out.println(register.getBody().asString());
        assertThat(register).isEqualTo(HttpStatus.SC_CREATED);
    }
}
