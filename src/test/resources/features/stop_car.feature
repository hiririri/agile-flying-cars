Feature: US_002 Stopper la voiture

  En tant que conducteur
  Je veux stopper la voiture
  Pour arrêter la voiture

  Scenario Outline: Stopper la voiture
    Given une voiture ayant comme vitesse courante <vitesse courante>
    When je stoppe la voiture
    Then la vitesse de la voiture est nulle
    Examples:
      | vitesse courante |
      | 0                |
      | 90               |