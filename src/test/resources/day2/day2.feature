Feature: Day 2, Jugar a pedra, paper, tisora

  Scenario Outline: jugar amb pedra
    Given he tret pedra
    When juguem i l'oponent treu la seva mà
    And l'estratègia és <estrategia>
    Then el resultat de la partida és:
      | PAPER   |  1 |
      | SCISSORS |  7 |
      | ROCK   |  4 |
    Examples:
      | estrategia |
      | 1          |
      | 2          |


  Scenario Outline: jugar amb paper
    Given he tret paper
    When juguem i l'oponent treu la seva mà
    And l'estratègia és <estrategia>
    Then el resultat de la partida és:
      | PAPER   |  5 |
      | SCISSORS |  2 |
      | ROCK   |  8 |
    Examples:
      | estrategia |
      | 1          |
      | 2          |

  Scenario Outline: jugar amb tissores
    Given he tret tissores
    When juguem i l'oponent treu la seva mà
    And l'estratègia és <estrategia>
    Then el resultat de la partida és:
      | PAPER   |  9 |
      | SCISSORS |  6 |
      | ROCK   |  3 |
    Examples:
      | estrategia |
      | 1          |
      | 2          |