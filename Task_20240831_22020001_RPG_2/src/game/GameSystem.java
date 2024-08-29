package game;

import java.util.HashMap;

import game.entities.BaseEntity;
import game.entities.EntityCategory;
import game.entities.items.CommonBodyArmor;
import game.entities.items.CommonHelmet;
import game.entities.items.CommonLegCover;
import game.entities.items.CommonShield;
import game.entities.items.CommonSword;
import game.entities.monsters.Slime;
import game.entities.players.Player;

public class GameSystem {

    private GameDifficulty difficulty;

    public HashMap<String, BaseEntity> players;
    public HashMap<String, BaseEntity> enemies;

    public GameSystem(GameDifficulty difficulty) {
        // Set default difficulty
        this.difficulty = difficulty;

        // Initialize players and enemies
        players = new HashMap<String, BaseEntity>();
        enemies = new HashMap<String, BaseEntity>();

        // Create player
        Player player = new Player(1, EntityCategory.PLAYER, "Player", 100, 10);
        players.put(player.getName(), player);

        // Create enemies
        BaseEntity enemy1 = new Slime(2, EntityCategory.ENEMY, "Enemy 1", 10, 25);
        enemies.put(enemy1.getName(), enemy1);

        // Load player inventory
        Player player1 = (Player) players.get("Player");
        player1.BodySlot = new CommonBodyArmor(0, EntityCategory.ITEM, "Common Body Armor", 0, 0, 5);
        player1.HeadSlot = new CommonHelmet(0, EntityCategory.ITEM, "Common Helmet", 0, 0, 2);
        player1.RightHandSlot = new CommonSword(0, EntityCategory.ITEM, "Common Sword", 0, 40, 0);
        player1.LeftHandSlot = new CommonShield(0, EntityCategory.ITEM, "Common Shield", 0, 0, 20);
        player1.LegsSlot = new CommonLegCover(0, EntityCategory.ITEM, "Common Leg Armor", 0, 0, 3);
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void Run() {
        // Print welcome message
        System.out.println("Welcome to the game!");
        System.out.print("Input your name: ");
        // Get player name
        String playerName = System.console().readLine();

        // Join world
        System.out.println("Welcome to the world, " + playerName + "!");

        // Wark straight
        Player player = (Player) players.get("Player");
        player.Walk();

        // Encounter enemy
        Slime enemy = (Slime) enemies.get("Enemy 1");

        System.out.println("Your stats: ");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Attack Power: " + player.getAttackPower());
        System.out.println("Defend Power: " + player.getDefendPower());

        System.out.println("Enemy stats: ");
        System.out.println("Health: " + enemy.getHealth());
        System.out.println("Attack Power: " + enemy.getAttackPower());

        System.out.print("Do you want to fight the enemy? (Y/N): ");

        // Fight or not
        String fight = System.console().readLine().toUpperCase();

        if (!fight.equals("Y")) {
            System.out.println("You run away!");
            return;
        }

        // Fight
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("Player attacks enemy");
            enemy.Defend(player.Attack());
            System.out.println("Enemy attacks player");
            player.Defend(enemy.Attack());
        }

        // Check result
        if (player.getHealth() > 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }

        // Continue game dev?
        System.out.print("Do you want to continue game development? (Y/N): ");
        String continueGameDev = System.console().readLine().toUpperCase();

        if (continueGameDev.equals("Y")) {
            System.out.println("I do not want to continue game development");
        } else {
            System.out.println("Stop game development");
        }

        // Thank you message
        System.out.println("Thank you for playing the game!");
    }
}
