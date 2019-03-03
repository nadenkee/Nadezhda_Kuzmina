Feature: Homework Six Different Elements Cucumber Test

  Scenario: Different Elements Page Test
    Given I am on Home Page
    And I login as user 'PITER CHAILOVSKII'
    Then User's name should be 'PITER CHAILOVSKII'
    And Interface should have all needed elements
    When I click on Service subcategory in the header
    Then Service dropdown menu in header displays following options
      | SUPPORT       |
      | DATES         |
      | COMPLEX_TABLE |
      | SIMPLE_TABLE  |
      | USER_TABLE    |
      | TABLE_PAGES   |
      | DIFFERENT     |
      | PERFORMANCE   |
    When I click on Service subcategory in the left section
    Then Service dropdown in left section displays following options
      | SUPPORT       |
      | DATES         |
      | COMPLEX_TABLE |
      | SIMPLE_TABLE  |
      | USER_TABLE    |
      | TABLE_PAGES   |
      | DIFFERENT     |
      | PERFORMANCE   |
    And I click on Service subcategory in the header
    When I open menu 'DIFFERENT ELEMENTS' from header
    Then Different Elements page contains all elements needed
    And I see the Right section
    And I see the Left section
    When I click checkboxes 'WATER' and 'WIND'
    Then Checkboxes 'WATER' and 'WIND' is correct on log
    When I select radio button:'SELEN'
    Then Radio button 'SELEN' is correct on log
    When I select 'YELLOW' from the color selection dropdown
    Then Color 'YELLOW' is correct on log
    When I click checkboxes 'WATER' and 'WIND'
    Then Check checkboxes 'WATER' and 'WIND' is unchecked