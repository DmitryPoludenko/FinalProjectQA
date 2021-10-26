Feature: Smoke
  As a user
  I want to test some site functionality related with main news titles and question page
  So that I can be sure that site works correctly

  Scenario Outline: Check the name of the head article
    Given User opens '<homePage>' page
    And User clicks on the news button
    And User checks pop-up-window visibility
    And User clicks on pop-up-window close button
    When User gets the name of the head article
    Then User checks that the name of head article equals '<titleName>'
    Examples:
      | homePage             | titleName                                        |
      | https://www.bbc.com/ | Climate laggard Australia vows to reach net zero |

  Scenario Outline: ChecksSecondaryArticleTitles
    Given User opens '<homePage>' page
    And User clicks on the news button
    And User checks pop-up-window visibility
    And User clicks on pop-up-window close button
    When User gets the names of the secondary head articles
    Then User checks that the names of the secondary head articles equals hardcoded are here
      | Can Lego help save Singapore's coral reefs?        |
      | Japan princess in muted wedding after controversy  |
      | Protests rock Sudan after military coup            |
      | Signs of first planet found outside our galaxy     |
      | Chappelle slams cancel culture amid Netflix furore |

    Examples:
      | homePage             |
      | https://www.bbc.com/ |

