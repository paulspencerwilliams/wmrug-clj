Feature: To enable me to manage my tasks, as a user, I want to be able to add tasks, and view them in chronological order

  Scenario: View tasks in chronological order 
    Given the following tasks
      | title              | due        |
      | Organise BCS night | 2014-11-04 |
      | Learn pedestal     | 2014-12-31 | 
      | Learn Om           | 2014-10-15 |
    When I visit the homepage
    Then will see the following tasks
      | title              | due        |
      | Learn Om           | 2014-10-15 |
      | Organise BCS night | 2014-11-04 |
      | Learn pedestal     | 2014-12-31 | 

