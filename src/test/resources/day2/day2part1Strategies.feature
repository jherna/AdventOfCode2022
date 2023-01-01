Feature: Day 2: Rock Paper Scissors
  Els Elfs volen guanyar la partida
  A, B, C són pedra, paper, tisora, respectivament (oponent)
  X, Y, Z són pedra, paper, tisora, respectivament (elf)

  Scenario: Strategy A vs Y
    Given A és Rock i Y és Paper
    When la tirada és A vs Y
    Then els punts obtinguts són 8

  Scenario: Strategy B vs X
    Given B és Paper i X és Rock
    When la tirada és B vs X
    Then els punts obtinguts són 1

  Scenario: Strategy C vs Z
    Given C és Scissors i Z és Scissors
    When la tirada és C vs Z
    Then els punts obtinguts són 6
