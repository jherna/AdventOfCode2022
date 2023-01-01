package day2;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class StepsFinalScoreStrategiesPart1 {
    Game game;
    Hand o ;
    Hand e ;
    int punts;
    @Before
    public void before() {
        game = new Game();
        punts = 0;
    }

    @Given("totes les estrategies")
    public void totes_les_estrategies() {
    }

    @When("es juguen les rondes")
    public void es_juguen_les_rondes() {
        game.resultats.add(game.round(Hand.ROCK,Hand.PAPER));
        game.resultats.add(game.round(Hand.PAPER,Hand.ROCK));
        game.resultats.add(game.round(Hand.SCISSORS,Hand.SCISSORS));
        Assertions.assertEquals(3,game.resultats.size());
    }
    @Then("la suma de punts obtinguts és {int}")
    public void la_suma_de_punts_obtinguts_és(Integer total) {
        //int sum = game.resultats.stream().mapToInt(p->p).sum();
        Assertions.assertEquals(total, game.resultatRondes());

    }

}
