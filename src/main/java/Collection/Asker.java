package Collection;

import data.Coordinates;
import data.DragonCharacter;
import data.DragonHead;
import exception.IncorrectInputInScriptException;
import exception.MustNotBeEmptyException;
import exception.NotInDeclaredLimitsException;

import java.util.NoSuchElementException;

public class Asker {

    public Asker() {
    }

    public String askName() {
        String name;
        while (true) {
            try {
                Console.print("enter name: ");
                name = Console.readString().trim();
                if (name.isEmpty()) throw new MustNotBeEmptyException();
                break;
            } catch (MustNotBeEmptyException exception) {
                Console.println("name cannot be empty, please re-enter");
            }
        }
        return name;
    }

    public double askX() {
        double x;

        while (true) {
            try {
                Console.print("enter x coordinate: ");
                x = Double.parseDouble(Console.readString());
                break;
            } catch (NumberFormatException ex) {
                Console.println("x coordinate must be float type");
            } catch (NoSuchElementException exception) {
                Console.println("enter x value");
            }
        }
        return x;
    }

    public int askY() {
        int y;

        while (true) {
            try {
                Console.print("enter y coordinate: ");
                y = Integer.parseInt(Console.readString());
                if (y > 91) throw new NotInDeclaredLimitsException();
                break;
            } catch (NumberFormatException ex) {
                Console.println("y coordinate must be int type");
            } catch (NoSuchElementException exception) {
                Console.println("enter x value");
            } catch (NotInDeclaredLimitsException excep) {
                Console.println("enter y < 91");
            }
        }
        return y;
    }

    public Coordinates setCoordinates() {
        double x = askX();
        int y = askY();
        return new Coordinates(x, y);
    }

    public int askAge() {
        int age;

        while (true) {
            try {
                Console.print("enter age: ");
                age = Integer.parseInt(Console.readString());
                if (age < 0) throw new NotInDeclaredLimitsException();
                break;
            } catch (NumberFormatException ex) {
                Console.println("age coordinate must be int type");
            } catch (NotInDeclaredLimitsException e) {
                Console.println("the age cannot be less than 0");
            }
        }
        return age;
    }

    public long askWeight() {
        long weight;

        while (true) {
            try {
                Console.print("enter weight: ");
                weight = Long.parseLong(Console.readString());
                if (weight < 0) throw new IncorrectInputInScriptException();
                break;
            } catch (NumberFormatException ex) {
                Console.println("weight have long format");
            } catch (IncorrectInputInScriptException exception) {
                Console.println("weight cannot < 0");
            }
        }
        return weight;
    }

    public int askWingspan() {
        int wingspan;
        while (true) {
            try {
                Console.print("enter wingspan: ");
                wingspan = Integer.parseInt(Console.readString());
                if (wingspan < 0) throw new IncorrectInputInScriptException();
                break;
            } catch (IncorrectInputInScriptException exception) {
                Console.println("the wingspan value must be greater than 0");
            } catch (NumberFormatException ex) {
                Console.println("number must be int");
            }
        }
        return wingspan;
    }

    public DragonCharacter askCharacter() {
        Console.println(" 1.GOOD  \n  2.WISE  \n  3.CHAOTIC_EVIL");
        int orgNumber;
        while (true) {
            try {
                Console.print("enter the number of the type of organization you need: ");
                orgNumber = Integer.parseInt(Console.readString());
                if (orgNumber < 0 || orgNumber > 3) throw new NotInDeclaredLimitsException();
                if (orgNumber == 1) {
                    return DragonCharacter.GOOD;
                }
                if (orgNumber == 2) {
                    return DragonCharacter.WISE;
                }
                if (orgNumber == 3) {
                    return DragonCharacter.CHAOTIC_EVIL;
                }

            } catch (NumberFormatException ex) {
                Console.println("number must be int");
            } catch (NotInDeclaredLimitsException ex) {
                Console.println("enter again, input incorrect (choose int num from 1 to 3)");
            }
        }
    }

    public long askSize() {
        long size;

        while (true) {
            try {
                Console.print("enter size: ");
                size = Long.parseLong(Console.readString());
                break;
            } catch (NumberFormatException ex) {
                Console.println("size must be long type");
            }
        }
        return size;
    }

    public double askEyesCount() {
        double x;

        while (true) {
            try {
                Console.print("enter eyesCount value: ");
                x = Double.parseDouble(Console.readString());
                break;
            } catch (NumberFormatException ex) {
                Console.println("eyesCount must be double type");
            }
        }
        return x;
    }

    public float askToothCount() {
        float x;

        while (true) {
            try {
                Console.print("enter toothCount value: ");
                x = Float.parseFloat(Console.readString());
                break;
            } catch (NumberFormatException ex) {
                Console.println("toothCount must be float type");
            }
        }
        return x;
    }

    public DragonHead setHead() {
        Long size = askSize();
        double eyesCount = askEyesCount();
        Float toothCount = askToothCount();
        return new DragonHead(size, eyesCount, toothCount);
    }

}
