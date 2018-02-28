Feature: Login feature for MyStore site
          This feature wil have valid and invalid data testing for login functionality

  # happy path - valid data scenario
  @validLogin
  Scenario: User can can login successfully with valid credentials.
    Given User on authentication Page
    When User enter email as "harshalapb@yahoo.com" and password as "tempPW1"
      And User click on SignIn button
    Then User should be logged in successfully
    And User Account Page is displayed.


  # unhappy Path
  @invalidLogin
  Scenario Outline: User can not login successfully with invalid credentials
    Given User on authentication Page
    When User enter email as "<email>" and password as "<password>"
    And User click on SignIn button
    Then User should not login successfully
    And User should see msg as "<message>"
    Examples:
      | email               | password  | message                |
      |                     |           | email address required |
      |                     | any       | email address required |
      |harshalapb@yahoo.com |           | Password is required   |
      |harshalapb@yahoo.com | jhsgda    | Authentication failed  |
      |invalid@email.com    |           | Password is required   |
      |invalid@email.com    | 98oifjny  | Authentication failed  |


