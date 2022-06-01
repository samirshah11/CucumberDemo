Feature: Search product functionality
  Scenario: Search product on both home and offers page
    Given User is on shopping landing page
    When User search with shortname "tom" and extract actual product
    Then Relevant product should be searched
    And It should be match with product search on offer page


