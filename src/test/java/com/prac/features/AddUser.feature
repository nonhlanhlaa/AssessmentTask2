Feature: Add Users
  As a user
  I want to add 2 unique users to the www.way2automation.com list table

  Scenario Outline: add unique customer
    Given user is on way2automation landing page
    When user confirms that they are on the User List Table
    And user enters firstname <firstname> & lastname <lastname> & username <username> & password <password> & customer <customer> & role <role> & email <email> & cellphone <cellphone>
    And user clicks save button
    Then user confirms that they have successfully added the user

    Examples:
      | firstname | lastname | username | password | customer | role     | email       | cellphone |
      | duck      | wing     | dw       | 12345    | AAA      | Admin    | dw@hero.com | 908211    |
      | king      | kong     | kk       | 54321    | BBB      | Customer | kk@hero.com | 089675    |


