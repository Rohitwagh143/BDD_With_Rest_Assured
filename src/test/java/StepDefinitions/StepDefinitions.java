package StepDefinitions;

import dataProver_class.apiResources;
import com_files.helper;
import dataProver_class.provider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import spec_builder.sp_rs;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    RequestSpecification request_specification;
    static String place_id;
    Response response;


    @Given("Add Place payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        request_specification = given().spec(sp_rs.req_builder()).body(provider.objReturn(name, language, address));
    }


    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        apiResources api = apiResources.valueOf(resource);
/*        System.out.println(resource + " " + method);
        System.out.println(api.getResource());*/

        if (method.equalsIgnoreCase("Post")) {
            response = request_specification.when().post(api.getResource());
        } else if (method.equalsIgnoreCase("get")) {
            response = request_specification.when().get(api.getResource());
        } else if (method.equalsIgnoreCase("put")) {
            response = request_specification.when().put(api.getResource());
        } else if (method.equalsIgnoreCase("delete")) {
            response = request_specification.when().delete(api.getResource());
        }
    }

    @Then("the api call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(int int1) {
        assertEquals(response.getStatusCode(), int1);
    }



    @Then("{string} in response is {string}")
    public void in_response_is(String string, String string2) {
        String key = helper.json_data_filter(response, string);
//        System.out.println(key + " key : str " + string2);
        assertEquals(key, string2);
    }

    @Then("And verify place_id Created maps to {string} using {string}")
    public void and_verify_place_id_created_maps_to_using(String exp_name, String resource) throws IOException {
//        System.out.println(exp_name + " " + resource);

        place_id = helper.json_data_filter(response, "place_id");
//        System.out.println(place_id);
//        System.out.println(place_id);
        request_specification = given().spec(sp_rs.req_builder()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource, "GET");
        String name = helper.json_data_filter(response, "name");
        assertEquals(exp_name, name);
//        System.out.println(name + " " + place_id);
    }

    @Given("Delete Place Payload")
    public void delete_place_payload() throws IOException {
//        System.out.println(place_id);
        request_specification = given().spec(sp_rs.req_builder()).body(provider.delete_(place_id));
//        user_calls_with_http_request();
    }

    @Given("Update Place Payload with {string}")
    public void update_place_payload_with(String Address) throws IOException {
        request_specification = given().spec(sp_rs.req_builder()).body(provider.Update_(place_id,Address));
    }


}