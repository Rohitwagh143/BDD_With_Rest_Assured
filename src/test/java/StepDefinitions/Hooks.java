package StepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void before_Delete_Scenario() throws IOException {

        StepDefinitions m = new StepDefinitions();
        if (StepDefinitions.place_id == null) {

            m.add_place_payload("Shetty", "French", "Asia");
            m.user_calls_with_http_request("AddPlaceAPI", "POST");
            m.and_verify_place_id_created_maps_to_using("Shetty", "GetPlaceAPI");
        }
    }

    @Before("@UpdatePlace")
    public void before_Update_Scenario() throws IOException {

        StepDefinitions m = new StepDefinitions();
        if (StepDefinitions.place_id == null) {

            m.add_place_payload("Shetty", "French", "Asia");
            m.user_calls_with_http_request("AddPlaceAPI", "POST");
            m.and_verify_place_id_created_maps_to_using("Shetty", "GetPlaceAPI");
        }
    }
}
