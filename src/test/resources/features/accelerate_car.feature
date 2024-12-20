Feature: US_001 Accelerer la voiture

  En tant que conducteur
  Je veux accélérer la voiture
  Pour augmenter la vitesse de la voiture

  Scenario Outline: Accélérer la voiture
    Given une voiture ayant comme vitesse courante <vitesse courante>
    When j'accélère la voiture d'une vitesse de <accélération>
    Then la vitesse de la voiture est <vitesse finale>
    Examples:
      | vitesse courante | accélération | vitesse finale |
      | 0                | 50           | 50             |
      | 90               | 10           | 100            |

  Scenario Outline: Refuser une vitesse négative
    Given une voiture ayant comme vitesse courante <vitesse courante>
    When j'accélère la voiture d'une vitesse de <accélération>
    Then une exception est levée
    Examples:
      | vitesse courante | accélération  |
      | 0                | -50          |
      | 90               | -10          |

