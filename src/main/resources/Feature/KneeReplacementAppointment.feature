Feature: Knee replacement appointment booking

  Scenario: To get the Consultants availability for Knee replacement

    Given I am a patient wanting a "Knee replacement surgery"
    When I put in my location "London, UK" and date of leave "2023-09-28"
    Then I can get a consultants availability and location provided to make my decision




