public class Game {

    protected static Player player = new Player();
    // public boolean tutorial = false;
    private static int maxcoords = 11; //uneven numbers are best
    protected static Room[][] rooms = new Room[maxcoords - 1][maxcoords - 1];

    public static int getMaxcoords() {
        return maxcoords;
    }

    /**
     * Start sequence
     * Asks difficulty
     * player.Setup();
     *
     */
    public static void start() {

        System.out.println("Hello world!");
        Console.write("Hello player, and welcome to this Game!");
        Console.write("Enter your username to continue");
        Console.write("...");
        player.setUsername(Console.read());     //read user input
        Console.clear();
        Console.write("Okay, " + player.getUsername());
        Console.write("Before you can start playing, you need to go through a couple of options, so please answer these questions...");
        Console.write("");
        Console.write("Choose a difficulty level...");
        Console.write("");
        Console.write("Easy - start with armor, more attack damage and get more xp");
        Console.write("Intermediate - unmodified stats for the average gameplay experience");
        Console.write("Hard - start with less HP and level up slower than normal");
        Console.write("...");
        boolean accepted = false;
        while (!accepted) {
            String input = Console.read();
            switch (input) {
                case "Easy", "easy", "e" -> {
                    player.setDifficulty("easy");
                    accepted = true;
                }
                case "Intermediate", "intermediate", "i" -> {
                    player.setDifficulty("intermediate");
                    accepted = true;
                }
                case "Hard", "hard", "h" -> {
                    player.setDifficulty("hard");
                    accepted = true;
                }
                default -> {
                    Console.write("invalid input, please try again...");
                    accepted = false;
                }
            }
        }
        Console.clear();
        Console.write(player.getDifficulty() + " , okay then!");
        Console.write("");


        //        TODO: offer a tutorial


        Console.write("The startup sequence will now finish and ready the game, please have a moment of patience!");
        player.setup();
        player.idle();
    }

}
