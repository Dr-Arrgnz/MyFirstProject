public class Enemy {

    private int hp = 1;
    private int ad = 1;
    private String name = "testobject";


    public Enemy(int x, int y, int level) {

        hp = 20;
        ad = 10;


    }

    public void attack() {

        if (Player.getShield() > 0) {
            int playershield = Player.getShield();
            int playerhp = Player.getHp();
            double playerarmor = Player.getArmor();
            playershield = (int) (playershield - ad * (1 - playerarmor));
            if (playershield < 0) {
                playerhp = playerhp + playershield;
                playershield = 0;
                Player.setHp(playerhp);
            }
            Player.setShield(playershield);
        } else {
            int playerhp = Player.getHp();
            double playerarmor = Player.getArmor();
            playerhp = (int) (playerhp - ad * (1 - playerarmor));
            Player.setHp(playerhp);
        }
        int damage = (int) (ad * (1 - Player.getArmor()));
        Console.write("The enemy " + name + " attacked you and dealt " + damage + " damage!");
        Console.write("You now have: " + Player.getShield() + " shield and: " + Player.getHp() + " hp!");
    }
}
