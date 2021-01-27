Feature: UK Visa EligibilityCheckCriteria for different purposes of visit
         * As a user when I select reason to visit UK as Tourism for Australia nationality then I should displayed with an outcome message
         * As a user when I select reason to visit UK as Work for Chile nationality then I should displayed with an outcome message
         * As a user when I select reason to visit UK as Join Partner for long stay then I should displayed with an outcome message

  Background: 
    Given the UK-Visa Home page

  @Reason=Tourism
  Scenario Outline: UK Visa Eligibility Check for Tourism
    When user checks eligibility for <nationality> nationality with reason to visit UK as <reasonToVisit>
    Then should see the message <outcome>

    Examples: 
      | nationality | reasonToVisit | outcome                                    |
      | Australia   | Tourism       | You will not need a visa to come to the UK |

  @Work
  Scenario Outline: UK Visa Eligibility Check To Work in UK
    When user checks eligibility for <nationality> nationality with reason to visit UK as <reasonToVisit>
    And  select planning to work in UK as <planningToWork>
    Then should see the message <outcome>

    Examples: 
      | nationality | reasonToVisit                    | planningToWork       | outcome                                                                  |
      | Chile       | Work, academic visit or business | longer than 6 months | You’ll need a visa to work or do business or academic research in the UK |

  @JoinUKPartner
  Scenario Outline: UK Visa Eligibility Check to join a partner for long stay in UK
    When user checks eligibility for <nationality> nationality with reason to visit UK as <reasonToVisit>
    And  select family member immigration status <immigrationsStatus>
    Then should see the message <outcome>

    Examples: 
      | nationality | reasonToVisit                          | immigrationsStatus | outcome                                                     |
      | Colombia    | Join partner or family for a long stay | Yes                | You’ll need a visa to join your family or partner in the UK |