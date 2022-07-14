import java.util.Locale;

public class Player {

    private static String difficulty = "intermediate";
    private static String username = "username";
    private static int x = (int) (Game.getMaxcoords() * 0.5);
    private static int y = (int) (Game.getMaxcoords() * 0.5);
    private static int hp = 100;
    private static int ad = 5;
    private static double armor = 0;
    private static int shield = 0;
    private static int kills = 0;
    private static int level = 0;
    private static double xp_rate = 1;
    private static int xp = 0;
    private static int level_rate = 2;
    private static int levelxp = (int) Math.pow(level_rate, level);

    public static String getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(String difficulty) {
        Player.difficulty = difficulty;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Player.username = username;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Player.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) { Player.y = y; }

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        Player.hp = hp;
    }

    public static int getAd() {
        return ad;
    }

    public static void setAd(int ad) {
        Player.ad = ad;
    }

    public static double getArmor() {
        return armor;
    }

    public static void setArmor(double armor) {
        Player.armor = armor;
    }

    public static int getShield() { return shield; }

    public static void setShield(int shield) {
        Player.shield = shield;
    }

    public static int getKills() {
        return kills;
    }

    public static void setKills(int kills) { Player.kills = kills; }

    public static int getLevel() { return level; }

    public static void setLevel(int level) { Player.level = level; }

    public static double getXp_rate() { return xp_rate; }

    public static void setXp_rate(double xp_rate) { Player.xp_rate = xp_rate; }

    public static int getXp() { return xp; }

    public static void setXp(int xp) {
        Player.xp = xp;
    }

    /**
     * Gives the basic stats according to difficulty
     * Adds one level
     */
    public static void setup() {
        // TODO: if (game.tutorial) Inventory.additem("potion_health", 3);
        switch(difficulty) {
            case "easy" -> {
                hp = 100;
                ad = 15;
                armor = 0.1;
                shield = 0;
                kills = 0;
                level = 0;
                xp_rate = 1.5;
                xp = 0;
            }
            case "intermediate" -> {
                hp = 100;
                ad = 10;
                armor = 0;
                shield = 0;
                kills = 0;
                level = 0;
                xp_rate = 1.0;
                xp = 0;
            }
            case "hard" -> {
                hp = 75;
                ad = 10;
                armor = 0;
                shield = 0;
                kills = 0;
                level = 0;
                xp_rate = 0.5;
                xp = 0;
            }
            default -> System.out.println("Invalid value for player.difficulty in Player.setup");
        }
        forcelevel();
    }

    /**
     * adds given amount to Player.xp
     * @param amount
     */
    public static void addxp(int amount) {
        xp += amount * xp_rate;
        levelcheck();
    }

    /**
     * level sequence, multiple level ups possible
     */
    public static void levelcheck() {
        if (xp >= Math.pow(level_rate, level)) {
            xp -= Math.pow(level_rate, level);
            level++;
            Console.write("Level up!");
            Console.write("You are now level " + level);
            Console.write("Choose one stat to increase:");
            Console.write("HP: " + hp);
            Console.write("AD: " + ad);
            switch (Console.read().toLowerCase()) {
                case "hp" -> {
                    hp += 10;
                    Console.write("Your hp were increased by 10!");
                }
                case "ad" -> {
                    ad += 2;
                    Console.write("Your ad was increased by 2!");
                }
                default -> Console.write("Please choose one of the stats above.");
            }
            Console.write("");
            statcheck();
            Console.write("");
        }
        if (xp >= Math.pow(level_rate, level)) {
            levelcheck();
        }
    }

    /**
     * Prints all stats to console
     */
    public static void statcheck() {
        Console.write("Your stats are now:");
        Console.write("HP: " + hp);
        Console.write("AD: " + ad);
        Console.write("Armor: " + armor);
        Console.write("Shield: " + shield);
        Console.write("XP: " + xp);
        Console.write("XP for the next level: " + levelxp);
        Console.write("Level: " + level);
        Console.write("Kills: " + kills);
    }

    /**
     * sets Player.xp to the amount needed to level up and activates Player.levelcheck()
     */
    public static void forcelevel() {
        xp = levelxp;
        levelcheck();
    }

    /**
     * Waiting for input after action
     */
    public static void idle() {
        Console.write("Waiting for input...");
        switch (Console.read().toLowerCase()) {
            case "move" -> { move();}
            case "help" -> { Console.help();}
            case "stats" -> { statcheck();}
            default -> { Console.write("Invalid input, try writing 'help' for a list of actions"); idle();}
        }
    }

    /**
     * Player movement
     */
    public static void move() {
        Console.write("You are currently in Room: ");
        Console.write("X = " + (x + 1));
        Console.write("Y = " + (y + 1));
        Console.write("Choose a direction to move to: ");
        switch (Console.read().toLowerCase()) {
            case "up", "u"      ->  {y += 1;}
            case "down", "d"    ->  {y -= 1;}
            case "left", "l"    ->  {x -= 1;}
            case "right", "r"   ->  {x += 1;}
            default             ->  {Console.write("Invalid input, try up, down, left or right"); move();}
        }
        roomcheck();
        Game.rooms[x][y].enter();
    }

    /**
     * checks if Player.x and Player.y have working values
     */
    public static void roomcheck() {
        if (y < 0) {
            y = 0;
            Console.write("You can go no further down!");
            move();
        }
        if (y > (Game.getMaxcoords() - 1)) {
            y = (Game.getMaxcoords() - 1);
            Console.write("You can go no further up!");
            move();
        }
        if (x < 0) {
            x = 0;
            Console.write("You can go no further to the left!");
            move();
        }
        if (x > (Game.getMaxcoords() - 1)) {
            x = (Game.getMaxcoords() - 1);
            Console.write("You can go no further to the right!");
            move();
        }
    }
}

