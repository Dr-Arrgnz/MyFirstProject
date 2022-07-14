public class Inventory {

    public static void additem(String item, int amount) {

        switch (item) {
            case "pot_health" -> {
                // Do shit
            }
            case "pot_mana" -> {
                // Do more shit
            }
            default -> {
                System.out.println("Game tried to add invalid item to inventory, please message the developer");
            }
        }


    }



}
