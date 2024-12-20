Feature: Monitor Aircraft Fuel Levels

  # User Story:
  # As a fleet operations manager,
  # I want to monitor the fuel levels of all aircraft,
  # So that I can ensure readiness for flights and operational efficiency.

  # Scenario: Check fuel levels of multiple aircraft
  # Description: Verifies that the fuel levels of all tracked aircraft can be monitored correctly.
  Scenario Outline: Refuel an aircraft with different amounts
    Given an aircraft with registration "<registration>" and remaining fuel of <initialFuel>
    When I add <fuelToAdd> units of fuel
    Then the remaining fuel should be <expectedFuel>

    Examples:
      | registration | initialFuel | fuelToAdd | expectedFuel |
      | F-GZDK       | 150         | 50        | 200          |
      | F-GJKL       | 100         | 25        | 125          |
      | F-GBCD       | 200         | 0         | 200          |