package Collection;


import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString() {
        if (!ifScannerHasNext()) {
            exit();
        }
        return scanner.nextLine();
    }

    public static boolean ifScannerHasNext() {
        return scanner.hasNextLine();
    }

    /**
     * Prints toOut.toString() to Console
     *
     * @param toOut Object to print
     */
    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Prints toOut.toString() + \n to Console
     *
     * @param toOut Object to print
     */
    public static void println(Object toOut) {
        System.out.println(toOut);
    }

    /**
     * Prints error: toOut.toString() to Console
     *
     * @param toOut Error to print
     */
    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    public static void exit() {
        System.exit(0);
    }
}
