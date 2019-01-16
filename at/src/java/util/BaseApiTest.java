package util;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Java6Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;

import static io.restassured.specification.ProxySpecification.host;

public abstract class BaseApiTest
{
    private Gson gson = new Gson();
    private Response response;
    private ObjectMapper Mapper = new ObjectMapper();

    RequestSpecification request = RestAssured.given();

    static
    {
//        RestAssured.proxy = host("10.9.1.80").withPort(8080);
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    }

    public Response get(String endpoint)
    {
        response = request.get(endpoint);
        return response;
    }

    public Response post(String endpoint, Object object)
    {
        String json = gson.toJson(object);
        request.header("Content-Type", "application/json");
        request.body(json);
        return response = request.post(endpoint);
    }

    public void checkHttpStatusCode(int expectedStatusCode)
    {
        assertThat(response.statusCode()).isEqualTo(expectedStatusCode);
    }
}
