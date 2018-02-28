Feature: This is to test Home page for http://automationpractice.com
        It tests that correct page is been opened.

  Scenario: User should be able to see Home page for MyStore
    Given User on MyStore Home Page
    Then User should see 'your logo' image
