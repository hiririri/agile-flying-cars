Feature: Manage Pilot Assignments

   # User Story:
   # As a fleet operations manager,
   # I want to manage pilot assignments to aircraft,
   # So that I can prevent conflicts and maintain proper operational responsibility.

  Scenario Outline: Assign a pilot to an aircraft
    Given a pilot named "<pilotName>"
    And an aircraft with registration "<registration>"
    When I assign the pilot to the aircraft
    Then the aircraft should have the pilot "<pilotName>"
    And the pilot should have 1 aircraft

    Examples:
      | pilotName | registration |
      | Maverick  | F-GZDK       |
      | Goose     | F-GJKL       |
      | Iceman    | F-GBCD       |

  Scenario Outline: Remove a pilot from an aircraft
    Given an aircraft with registration "<registration>"
    And the aircraft has a pilot "<pilotName>"
    When I remove the pilot from the aircraft
    Then the aircraft should not have a pilot
    And the pilot should not have the aircraft

    Examples:
      | registration | pilotName |
      | F-GZDK       | Maverick  |
      | F-GJKL       | Goose     |
      | F-GBCD       | Iceman    |

  Scenario Outline: Pilot manages multiple aircrafts
    Given a pilot named "<pilotName>"
    And an aircraft with registration "F-GZDK"
    And another aircraft with registration "F-GJKL"
    When I assign the pilot to both aircrafts
    Then the pilot should have 2 aircrafts

    Examples:
      | pilotName |
      | Maverick  |
      | Goose     |
      | Iceman    |