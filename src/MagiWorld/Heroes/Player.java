package MagiWorld.Heroes;

public abstract class Player {

    private int level, life, strenght, dext, intel;
    private int pNumber;

    /** Player info
     * @param level The level of the player
     * @param strenght His strengh
     * @param dext His agility
     * @param intel His intelligence
     * @param pNumber The player Number
     */
    Player(int level, int strenght, int dext, int intel, int pNumber) {
        this.level = level;
        this.life = level * 5;
        this.strenght = strenght;
        this.dext = dext;
        this.intel = intel;
        this.pNumber = pNumber;
    }

    // Getters and Setters

    int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    void setLife(int life) {
        this.life = life;
    }

    int getStrenght() {
        return strenght;
    }

    void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    int getDext() {
        return dext;
    }

    void setDext(int dext) {
        this.dext = dext;
    }

    int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getpNumber() {
        return pNumber;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }

    // Methods

    /**
     * Payer looses life
     * @param dmg the damages taken
     */
    void removeLife(int dmg) {
        int currentLife = getLife();
        System.out.println("Joueur " + getpNumber() + " perd " + dmg + " points de vie.");
        setLife(currentLife - dmg);
        if (getLife() <= 0) {
            System.out.println("Joueur " + getpNumber() + " est mort ...");
        }
    }

    /**
     * Player gains life (healing)
     * @param health the heal received
     */
    void gainLife(int health) {
        System.out.println("Joueur " + getpNumber() + " utilise un soins et gagne " + health + " point de vie.");
        setLife(getLife() + health);
    }

    /**
     * Player gains agaility
     * @param dext amount of agility gained
     */
    public void gainDext(int dext) {
        System.out.println("Joueur " + getpNumber() + " utilise une concentration et gagne " + dext + " d'agilité.");
        setDext(getDext() + dext);
    }

    /**
     * Basic attack (attack 1)
     * @param p the player number
     */
    public abstract void basicAttack(Player p);

    /**
     * Special attack (attack 2)
     * @param p the player number
     */
    public abstract void specialAttack(Player p);

}
