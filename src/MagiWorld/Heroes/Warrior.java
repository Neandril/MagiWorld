package MagiWorld.Heroes;

public class Warrior extends Player {

    /**
     * Constructor
     * @param level Level of the character
     * @param strenght his strenght
     * @param dext his dexterity (aka agility)
     * @param intel his intelligence
     * @param pNumber the player number
     */
    public Warrior(int level, int strenght, int dext, int intel, int pNumber) {
        super(level, strenght, dext, intel, pNumber);
    }

    /**
     * The warrior uses his basic attack
     * @param p the player number
     */
    @Override
    public void basicAttack(Player p) {
        System.out.println("Joueur " + getpNumber() + " utilise Coup d'épée et inflige " + getStrenght() + " dommages !");
        p.removeLife(getStrenght());
    }

    /**
     * The warrior uses his special attack
     * @param p the player number
     */
    @Override
    public void specialAttack(Player p) {
        int damage = getStrenght() * 2;
        int selfDmg = getStrenght() / 2;

        System.out.println("Joueur " + getpNumber() + " utilise Coup de rage et inflige " + damage + " dommages !");
        p.removeLife(damage);
        removeLife(selfDmg);
    }
}
