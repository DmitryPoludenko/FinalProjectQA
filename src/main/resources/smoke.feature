Feature: Smoke
  As a user
  I want to test some site functionality related with main news titles and question page
  So that I can be sure that site works correctly

  Scenario Outline: Check the name of the head article
    Given User opens '<homePage>' page
    And User clicks on the news button
    When User gets the name of the head article
    Then User checks that the name of head article equals '<titleName>'
    Examples:
      | homePage             | titleName                                    |
      | https://www.bbc.com/ | US missionaries kidnapped in Haiti - reports |

  Scenario Outline: ChecksSecondaryArticleTitles
    Given User opens '<homePage>' page
    And User clicks on the news button
    When User gets the names of the secondary head articles
    Then User checks that the names of the secondary head articles equals hardcoded '<titleName>'
    Examples:
      | homePage             | titleName                                            |
      | https://www.bbc.com/ | US missionaries kidnapped in Haiti - reports         |
      | https://www.bbc.com/ | We must learn from this hideous killing - British MP |
      | https://www.bbc.com/ | Crew back on Earth after first film shoot in space   |
      | https://www.bbc.com/ | Pomp and colour at Africa's biggest film festival    |
      | https://www.bbc.com/ | Russia sets condition for return of BBC's Rainsford  |


