package Collection;

import exception.IncorrectInputInScriptException;
import exception.MustNotBeEmptyException;

import java.util.Scanner;

public class Asker {
    private final int MAX_Y = 262;
    private final double MIN_HEALTH = 0;
    private final long MIN_MARINES = 1;
    private final long MAX_MARINES = 1000;

    private Scanner userScanner;
    private boolean fileMode;

    public Asker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    public String askName() {
        String name;
        while (true) {
            try {
                Console.print("enter name: ");
                name = userScanner.nextLine();
                if (name.isEmpty()) throw new MustNotBeEmptyException();
                break;
            } catch (MustNotBeEmptyException exception) {
                Console.println("name cannot be empty, please re-enter");
            }
        }
        return name;
    }
}
