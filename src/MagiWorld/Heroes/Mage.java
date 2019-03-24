package MagiWorld.Heroes;

public class Mage extends Player {

    private final int startingLife;
    /**
     * Constructor
     * @param level Level of the character
     * @param strenght his strenght
     * @param dext his dexterity (aka agility)
     * @param intel his intelligence
     * @param pNumber the player number
     */
    public Mage(int level, int strenght, int dext, int intel, int pNumber) {
        super(level, strenght, dext, intel, pNumber);
        this.startingLife = level * 5;
    }

    /**
     * The Mage uses his basic attack
     * @param p the player number
     */
    @Override
    public void basicAttack(Player p) {
        System.out.println("Joueur " + getpNumber() + " utilise Boule de feu et inflige " + getIntel() + " dommages !");
        p.removeLife(getIntel());
    }

    /**
     * The warrior uses his special attack
     * @param p the player number
     */
    @Override
    public void specialAttack(Player p) {
        int heal = getIntel() * 2;
        if (getLife() + heal >= startingLife) {
            heal = startingLife - getLife();
            gainLife(heal);
        } else {
            gainLife(heal);
        }

        System.out.println("Joueur " + getpNumber() + " utilise un sort de soins et récupère " + heal + " de points de vie !");
    }
}
