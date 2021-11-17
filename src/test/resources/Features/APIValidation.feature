Feature: Validating the place API

  @AddPlace @Regression
  Scenario Outline: Verify if place is being added successfully using addPlaceAPI
    Given Add Place payload "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the api call is success with status code 200
    And "status" in response is "OK"
    And "scope" in response is "APP"
    And And verify place_id Created maps to "<name>" using "GetPlaceAPI"

    Examples:
      | name         | language | address |
      | rohit shetty | german   | germany |

  @UpdatePlace @Regression
  Scenario Outline: To verify update place api is working
    Given Update Place Payload with "<Address>"
    When user calls "UpdatePlaceAPI" with "PUT" http request
    Then the api call is success with status code 200
    And "msg" in response is "Address successfully updated"

    Examples:
      | Address        |
      | New York , USA |

  @DeletePlace @Regression
  Scenario: To verify delete place api is working
    Given Delete Place Payload
    When user calls "DeletePlaceAPI" with "DELETE" http request
    Then the api call is success with status code 200
    And "status" in response is "OK"

