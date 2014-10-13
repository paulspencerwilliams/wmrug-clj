Feature: To enable me to manage my tasks, as a user, I want to be able to add tasks, and view them in chronological order

  Scenario: View tasks in chronological order 
    Given the following tasks
      | Title              | Due        |
      | Organise BCS night | 2014-11-04 |
      | Learn pedestal     | 2014-12-31 | 
      | Learn Om           | 2014-11-03 |
    When I visit the homepage
    Then will see the following tasks
      | Title              | Due        |
      | Learn Om           | 2014-11-03 |
      | Organise BCS night | 2014-11-04 |
      | Learn pedestal     | 2014-12-31 | 

  Scenario: Add a task results in task being shown in list view
    Given the following tasks
      | Title              | Due        |
      | Organise BCS night | 2014-11-04 |
      | Learn pedestal     | 2014-12-31 | 
      | Learn Om           | 2014-11-03 |
    When I add a task to "Be Dynamic" due "2014-12-03"
    Then will see the following tasks
      | Title              | Due        |
      | Learn Om           | 2014-11-03 |
      | Organise BCS night | 2014-11-04 |
      | Be Dynamic         | 2014-12-03 | 
      | Learn pedestal     | 2014-12-31 | 
