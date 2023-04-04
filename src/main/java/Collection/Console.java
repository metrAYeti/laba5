package Collection;


import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public Long readLong() {

        return scanner.nextLong();
    }
    public static String readString(){
        if(!ifScannerHasNext()) {
            exit();
        }
        return scanner.nextLine();
    }
    public Float readFloat(){
        if(!ifScannerHasNext()) {
            exit();
        }
        return scanner.nextFloat();
    }
    public int readInt(){
        if(!ifScannerHasNext()) {
            exit();
        }
        return scanner.nextInt();
    }
    public static boolean ifScannerHasNext(){
        return scanner.hasNextLine();
    }

    /**
     * Prints toOut.toString() to Console
     * @param toOut Object to print
     */
    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Prints toOut.toString() + \n to Console
     * @param toOut Object to print
     */
    public static void println(Object toOut) {
        System.out.println(toOut);
    }

    /**
     * Prints error: toOut.toString() to Console
     * @param toOut Error to print
     */
    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    /**
     * Prints formatted 2-element table to Console
     * @param element1 Left element of the row.
     * @param element2 Right element of the row.
     */
    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }
    public static void exit(){
        System.exit(0);
    }
}
