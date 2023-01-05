package day2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class StepsDay2p1 {
    Hand elf, oponent;
    Game game = new Game();
    int resultat, estrategia;

    @Given("he tret pedra")
    public void he_tret_pedra() {
        elf = Hand.ROCK;
        Assertions.assertEquals(Hand.ROCK,elf);
    }
    @Given("he tret paper")
    public void he_tret_paper() {
        elf = Hand.PAPER;
        Assertions.assertEquals(Hand.PAPER,elf);
    }

    @Given("he tret tissores")
    public void he_tret_tissores() {
        elf = Hand.SCISSORS;
        Assertions.assertEquals(Hand.SCISSORS,elf);
    }
    @When("juguem i l'oponent treu la seva mà")
    public void juguem() {
        //valor de l'oponent aleatori
        oponent = Hand.values()[(int)(Math.random()*3)];

    }


    @And("l'estratègia és {int}")
    public void l_estratègia_és(Integer estrategia) {
        this.estrategia = estrategia;
        if(game.getEstrategia() == 2) {
            Hand z = game.triarJugada(oponent, elf);
            game.jugada(oponent, z);
        }
        resultat = game.round(1,oponent,elf);

    }

    @Then("el resultat de la partida és:")
    public void el_resultat_de_la_partida_és(io.cucumber.datatable.DataTable dataTable) {
        Map<String,Integer> d = dataTable.asMap(String.class,Integer.class);
        Assertions.assertEquals(d.get(oponent.name()),resultat);
    }

}
