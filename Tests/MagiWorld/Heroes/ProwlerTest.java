package MagiWorld.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProwlerTest {

    private final Prowler p1 = new Prowler(10,0,10,0,1);
    private final Prowler p2 = new Prowler(10,0,10,0,2);

    @Test
    void Given_BasicAttack_WhenPlayerTurn_ThenTakeGoodAmountOfDamage() {
        p1.basicAttack(p2);
        assertEquals(40, p2.getLife());
    }

    @Test
    void Given_SpecialAttack_WhenPlayerTurn_ThenGetProwlerNewDextGoodValue() {
        p1.specialAttack(p2);
        assertEquals(15, p1.getDext());
    }
}