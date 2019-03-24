package MagiWorld.Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private final Warrior p1 = new Warrior(10,10,0,0,1);
    private final Warrior p2 = new Warrior(10,10,0,0,2);

    @Test
    void Given_BasicAttack_WhenPlayerTurn_ThenTakeGoodAmountOfDamage() {
        p1.basicAttack(p2);
        assertEquals(40, p2.getLife());
    }

    @Test
    void Given_SpecialAttack_WhenPlayerTurn_ThenTakeGoodAmoundOfDamageAndP1looseLife() {
        p1.specialAttack(p2);
        assertEquals(30, p2.getLife());
        assertEquals(45, p1.getLife());
    }
}