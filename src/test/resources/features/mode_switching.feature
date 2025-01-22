Feature: Switch Between Drive and Fly Modes

  # User Story:
  # As a pilot,
  # I want to switch between driving and flying modes,
  # So that I can adapt the vehicle's mobility to different terrains and airspaces.

  # Scenario: Switching from Drive to Fly mode
  # Description: Verifies that the vehicle correctly switches from Drive to Fly mode.
  Scenario: Switch from Drive mode to Fly mode
    Given a flying vehicle is in "DRIVE" mode
    When the pilot switches the mode
    Then the flying vehicle should be in "FLY" mode

  # Scenario: Switching from Fly to Drive mode
  # Description: Verifies that the vehicle correctly switches from Fly to Drive mode.
  Scenario: Switch from Fly mode to Drive mode
    Given a flying vehicle is in "FLY" mode
    When the pilot switches the mode
    Then the flying vehicle should be in "DRIVE" mode

  # Scenario: Cannot switch from Fly to Drive mode while flying
  # Description: Verifies that the vehicle does not switch from Fly to Drive mode while flying.
  Scenario: Switch from Fly mode to Drive mode while flying
    Given a flying vehicle is in "FLY" mode
    And the vehicle is currently flying
    When the pilot switches the mode
    Then the flying vehicle should be in "FLY" mode
    And an exception should be thrown