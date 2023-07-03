Feature: Login into Admin

  Scenario: Login as a Admin and Logout
    Given User launch Chrome browser
    When User open URL "http://www.maplogik.com/index.php/admin/login"
    Then User enter Email as "admin@gmail.com" and Password as "Admin@123"
    And Click on Login
    Then Page title should be "On Progresss.."
    Then Page title should be "Credentials Doesn't Match !"
    When User click Logout
    And close browser

  Scenario Outline: Login as a Admin and Logout
    Given User launch Chrome browser
    When User open URL "http://www.maplogik.com/index.php/admin/login"
    Then User enter Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page title should be "On Progresss.."
    Then Page title should be "Credentials Doesn't Match !"
    When User click Logout
    And close browser

    Examples: 
      | email            |  | password  |
      | admin@gmail.com  |  | Admin@123 |
      | admin1@gmail.com |  | admin@123 |
