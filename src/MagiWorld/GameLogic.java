package MagiWorld;

import MagiWorld.Heroes.Mage;
import MagiWorld.Heroes.Player;
import MagiWorld.Heroes.Prowler;
import MagiWorld.Heroes.Warrior;

import java.util.Random;
import java.util.Scanner;

class GameLogic {

    private final Scanner sc = new Scanner(System.in);
    private final Player player1;
    private final Player player2;

    GameLogic() {
        player1 = createPlayer(1);
        player2 = createPlayer(2);

        whoBegin();
    }

    /**
     * Player character creation.
     * Scanner used for ask desired values
     * @param pNumber The number of the player (1: player one, 2: player two)
     */
    private Player createPlayer(int pNumber) {
        int hero, level, strenght, dext, intel;
        System.out.println("Création du personnage du Joueur " + pNumber);
        do {
            System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage)");
            hero = sc.nextInt();
            if (hero == 0 || hero > 3) {
                System.out.println("Cette classe n'existe pas");
            }
        } while (hero == 0 || hero > 3);

        do {
            System.out.println("Niveau du personnage ?");
            level = sc.nextInt();
            System.out.println("Force du personnage ?");
            strenght = sc.nextInt();
            System.out.println("Agilité du personnage ?");
            dext = sc.nextInt();
            System.out.println("Intelligence du personnage ?");
            intel = sc.nextInt();
            if ((strenght + dext + intel) > level)
                System.out.println("un Personnage niveau " + level + " ne peut pas avoir " + strenght + " de force" +
                        " + " + dext + " d'agilité + " + intel + " d’intelligence : le total doit faire " + level);
        }while ((strenght + dext + intel) > level);

        return playerCreated(hero, level, strenght, dext, intel, pNumber);
    }

    /**
     * The character finally created after the method "createPlayer"
     * @param hero hero number (1: warrior, 2: prowler, 3: mage)
     * @param level The level of the hero
     * @param strenght His strengh
     * @param dext His agility
     * @param intel His intel
     * @param pNumber The number of the player
     */
    private Player playerCreated (int hero, int level, int strenght, int dext, int intel, int pNumber) {
        Player p = null;
        switch (hero) {
            case 1:
                // Warrior
                System.out.println("Woarg ! Je suis un guerrier de niveau " + level
                        + ", avec une force de " + strenght
                        + ", une agilité de " + dext
                        + ", et une intelligence de " + intel);
                p = new Warrior(level, strenght, dext, intel, pNumber);
                break;
            case 2:
                // Prowler
                System.out.println("Shuuut ... Je suis un rôdeur de niveau " + level
                        + ", une agilité de " + dext
                        + ", une force de " + strenght
                        + ", et une intelligence de " + intel);
                p = new Prowler(level, strenght, dext, intel, pNumber);
                break;
            case 3:
                // Mage
                System.out.println("Abracadabra ... Je suis un mage de niveau " + level
                        + ", une intelligence de " + intel
                        + ", une force de " + strenght
                        + ", et une agilité de " + dext);
                p = new Mage(level, strenght, dext, intel, pNumber);
                break;
        }
        return p;
    }

    /**
     * WhoBegin the game ?
     * This is stored in the boolean value "isPlayer1Begin".
     * If it is true, p1 begin, else p2 begin
     */
    private void whoBegin() {
        // Create dices values
        Random rand = new Random();
        int min = 1;
        int max = 6;
        int diceP1 = rand.nextInt((max - min) + 1) + min;
        int diceP2 = rand.nextInt((max - min) + 1) + min;

        System.out.println("Jet d'un dé à six face ...");
        System.out.println("Joueur 1 a fait " + diceP1);
        System.out.println("Joueur 2 a fait " + diceP2);

        if (diceP1 > diceP2) {
            System.out.println("Joueur 1 commence !");
            gameLoop(player1);
        } else if (diceP2 > diceP1) {
            System.out.println("Joueur 2 commence !");
            gameLoop(player2);
        } else {
            System.out.println("Egalité ! Nouvel essai...");
            whoBegin();
        }
    }

    /**
     * Game Loop, depending on the starting player
     * turn variable is set to 0 if p1 begins, to 1 otherwise
     * if "turn" is odd, we enter a game turn with p1 playing,
     * if "tyrn" is even, we enter a game turn with p2 playing
     * until life of one of them reach 0
     */
    private void gameLoop(Player begin) {
        int turn;

        if (begin.getpNumber() == 1) {
            // If p1 begins, enter the game loop with this state
            turn = 0;
            while (player1.getLife() > 0 && player2.getLife() > 0) {
                if (isOddOrEven(turn)){
                    gameTurn(player1, player2);
                    turn++;
                } else {
                    gameTurn(player2, player1);
                    turn++;
                }
            }
        } else if (begin.getpNumber() == 2) {
            // If p2 begins, enter the game loop with this state
            turn = 1;
            while (player1.getLife() > 0 && player2.getLife() > 0) {
                if (!isOddOrEven(turn)) {
                    gameTurn(player2, player1);
                    turn++;
                } else {
                    gameTurn(player1, player2);
                    turn++;
                }
            }
        }

    }

    /**
     * Logic for a turn of the game
     * @param first first player
     * @param second second player
     */
    private void gameTurn(Player first, Player second) {
        System.out.println("Joueur " + first.getpNumber() + " (" + first.getLife() + " de vitalité)." +
                "Veuillez choisir votre action (1: attaque basique, 2: attaque spéciale, autre: quitter le jeu)");
        int action = sc.nextInt();
        switch (action) {
            case 1:
                first.basicAttack(second);
                break;
            case 2:
                first.specialAttack(second);
                break;
            default :
                System.out.println("Arrêt du jeu en cours...");
                System.out.println("A bientôt !");
                System.exit(0);
                break;
        }
    }

    /**
     * Check is the turn number is odd or even
     * @param turn the turn number
     */
    private static boolean isOddOrEven(int turn) {
        return turn % 2 == 0;
    }
}
