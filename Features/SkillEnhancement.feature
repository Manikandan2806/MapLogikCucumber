Feature: SkillEnhancement

  Background: Login Details
    Given User launch Chrome browser
    When User open URL "http://www.maplogik.com/index.php/admin/login"
    Then User enter Email as "admin@gmail.com" and Password as "Admin@123"
    And Click on Login
    When User click Skill Enhancment
    And Click All Trainings

  @testing
  Scenario: Add The New Training
    When Click Add New
    And User enter Training Details
    And Click Save button
    When User enter Training Video Details
    And Click Save and Continue button
    And Close browser

  @regression
  Scenario: Add The Assessment
    When User click the Add Assessment
    And Click Add New and User enter Question, Answers and Save
    When User click Skill Enhancment
    And Click All Trainings
    And Click Add Assessment
    Then Check the Total Number of Assessment
    And Close The browser
