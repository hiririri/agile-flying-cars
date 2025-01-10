Feature: Manage Vehicle Acceleration and Climbing

  # User Story:
  # As a pilot,
  # I want to accelerate and climb when in fly mode,
  # So that I can safely and efficiently control the vehicle's speed and altitude during flight.

  # Scenario: Accelerate in Drive mode
  # Description: Verifies that the vehicle can accelerate while in Drive mode.
  Scenario Outline: Accelerate the vehicle in Drive mode
    Given a flying vehicle is in "DRIVE" mode with a current speed of <initialSpeed>
    When the pilot accelerates by <accelerationAmount>
    Then the current speed should be <expectedSpeed>

    Examples:
      | initialSpeed | accelerationAmount | expectedSpeed |
      | 50           | 20                 | 70           |
      | 80           | 10                 | 90           |
      | 0            | 15                 | 15           |

  # Scenario: Climb in Fly mode
  # Description: Verifies that the vehicle can climb when in Fly mode.
  Scenario Outline: Climb while in Fly mode
    Given a flying vehicle is in "FLY" mode with a current altitude of <initialAltitude>
    When the pilot climbs by <climbAmount>
    Then the current altitude should be <expectedAltitude>

    Examples:
      | initialAltitude | climbAmount | expectedAltitude |
      | 1000            | 500        | 1500             |
      | 2000            | 1000       | 3000             |
      | 500             | 250        | 750              |
