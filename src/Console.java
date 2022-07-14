import java.util.Scanner;

public class Console {

    public static Scanner input = new Scanner(System.in);

    static public void clear() {

        write("");
        write("");
        write("***Console cleared***");
        write("");
        write("");

    }

    /**
     *
     * @param output
     */
    static public void write(String output) {

        System.out.println(output);

    }

    /**
     *
     * @return The next line of input
     */
    static public String read() {

        return input.nextLine();

    }

    public void encounter() {

    //TODO: enemies

    }

    public static void help() {

    }
}
