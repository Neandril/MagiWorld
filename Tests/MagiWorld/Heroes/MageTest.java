package MagiWorld.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    private final Mage p1 = new Mage(10,0,0,10,1);
    private final Mage p2 = new Mage(10,0,0,10,2);

    @Test
    void Given_BasicAttack_WhenPlayerTurn_ThenTakeGoodAmountOfDamage() {
        p1.basicAttack(p2);
        assertEquals(40, p2.getLife());
    }

    @Test
    void Given_SpecialAttack_WhenPlayerTurn_ThenGetLifeIfThisExceedStartingLife() {
        p1.specialAttack(p2);
        assertEquals(50, p1.getLife());
    }

    @Test
    void Given_SpecialAttack_WhenPlayerTurn_ThenGetLifeIfThisNotExceedStartingLife() {
        p1.setLife(22);
        p1.specialAttack(p2);
        assertEquals(42, p1.getLife());
    }
}