@smoke
Feature: follow us | Social select

  Scenario: FB
  When click on FB
  Then validate FB link

    Scenario:
      When click on X
      Then validate X link

  Scenario:
    When click on rss
    Then validate rss link

  Scenario:
    When click on YT
    Then validate YT link
