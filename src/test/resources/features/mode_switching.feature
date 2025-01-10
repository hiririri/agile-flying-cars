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
