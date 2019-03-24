package MagiWorld.Heroes;

public class Prowler extends Player {

    /**
     * Constructor
     * @param level Level of the character
     * @param strenght his strenght
     * @param dext his dexterity (aka agility)
     * @param intel his intelligence
     * @param pNumber the player number
     */
    public Prowler(int level, int strenght, int dext, int intel, int pNumber) {
        super(level, strenght, dext, intel, pNumber);
    }

    /**
     * The Prowler uses his basic attack
     * @param p the player number
     */
    @Override
    public void basicAttack(Player p) {
        System.out.println("Joueur " + getpNumber() + " utilise Tir à l'arc et inflige " + getDext() + " dommages !");
        p.removeLife(getDext());
    }

    /**
     * The Prowler uses his special attack
     * @param p the player number
     */
    @Override
    public void specialAttack(Player p) {
        int concentrate = getLevel() / 2;

        System.out.println("Joueur " + getpNumber() + " utilise Concentration et gagne " + concentrate + " en agilité !");
        setDext(getDext() + concentrate);
    }
}
