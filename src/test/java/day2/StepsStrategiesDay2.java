package day2;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;



public class StepsStrategiesDay2 {

    Game game;
    Hand o ;
    Hand e ;
    int punts;
    @Before
    public void before() {
        game = new Game();
        punts = 0;
    }
    //Exemple 1
    @Given("A és Rock i Y és Paper")
    public void a_és_rock_i_y_és_paper() {
        o = Hand.ROCK;
        e = Hand.PAPER;
       Assertions.assertEquals(o,Hand.valueOf("ROCK"));
       Assertions.assertEquals(e,Hand.valueOf("PAPER"));
    }
    @When("la tirada és A vs Y")
    public void la_tirada_és_a_vs_y() {

        punts = game.round(o,e);
        Assertions.assertEquals(8,punts);
    }

    //Exemple 2
    @Given("B és Paper i X és Rock")
    public void b_és_paper_i_x_és_rock() {
        o = Hand.PAPER;
        e = Hand.ROCK;
        Assertions.assertEquals(o,Hand.valueOf("PAPER"));
        Assertions.assertEquals(e,Hand.valueOf("ROCK"));
    }
    @When("la tirada és B vs X")
    public void la_tirada_és_b_vs_x() {
        punts = game.round(o,e);
        Assertions.assertEquals(1,punts);
    }

    //Exemple 3
    @Given("C és Scissors i Z és Scissors")
    public void c_és_scissors_i_z_és_scissors() {
        o = Hand.SCISSORS;
        e = Hand.SCISSORS;
        Assertions.assertEquals(o,Hand.valueOf("SCISSORS"));
        Assertions.assertEquals(e,Hand.valueOf("SCISSORS"));
    }
    @When("la tirada és C vs Z")
    public void la_tirada_és_c_vs_z() {
        punts = game.round(o,e);
        Assertions.assertEquals(6,punts);
    }

    //Resultats
    @Then("els punts obtinguts són {int}")
    public void els_punts_obtinguts_són(Integer punts) {
        //System.out.println(punts);
        Assertions.assertEquals(punts, this.punts);
    }


}
