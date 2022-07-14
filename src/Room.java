import java.util.Random;

public class Room {

    private static boolean existing = false;
    //TODO: to begin, few static rooms
    //TODO: when working: Array of Room[200][200] with random generation and saving rooms

    /**
     * creates a new room, random chance for enemy encounters, loot, traps etc.
     */
    public void create() {

        int min = 0;
        int max = 5;
        Random rand = new Random();
        int random = rand.nextInt((max - min) + 1) + min;
        switch (random) {
            case 0 -> {
                System.out.println("0 in Room.create()");

            }
            case 1 -> {
                System.out.println("1 in Room.create()");

            }
            case 2 -> {
                System.out.println("2 in Room.create()");

            }
            case 3 -> {
                System.out.println("3 in Room.create()");

            }
            case 4 -> {
                System.out.println("4 in Room.create()");

            }
            case 5 -> {
                System.out.println("5 in Room.create()");

            }
            default -> {
                System.out.println("invalid random number in Room.create()");
            }
        }
        existing = true;
    }

    public void encounter() {

        Enemy enemy = new Enemy(Game.player.getX(), Game.player.getY(), Game.player.getLevel());

    }

    public void trap() {

    }

    public void chest() {

    }

    public void oasis() {

    }

    public void library() {

    }

    public void enter() {
        if (existing) {
            Console.write("The rooms seems oddly familiar, and is completely emtpy.");
            Console.write("It seems you were here before");
            Game.player.idle();
        }
        else {
            create();
        }
    }
}
