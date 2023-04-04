package commands;

import Collection.Asker;
import Collection.Console;
import exception.*;
import Collection.CollectionDragons;
import data.Coordinates;
import data.Dragon;
import data.DragonCharacter;
import data.DragonHead;
import exception.WrongAmountOfElementsException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddElement implements Command {
    private Asker askerOrganizations;
    CollectionDragons collectionDragons;

    public AddElement() {
    }

    public AddElement(CollectionDragons collectionDragons) {
        this.askerOrganizations = new Asker();
        this.collectionDragons = collectionDragons;
    }

    boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }


    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "add new element to collection";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            Dragon organization = new Dragon();
            organization.setId(CollectionDragons.generate_id());
            organization.setName(askerOrganizations.askName());
            organization.setCoordinates(askerOrganizations.setCoordinates());
            organization.setWeight(askerOrganizations.askWeight());
            organization.setCharacter(askerOrganizations.askCharacter());
            organization.setAge(askerOrganizations.askAge());
            organization.setWingspan(askerOrganizations.askWingspan());
            organization.setHead(askerOrganizations.setHead());
            collectionDragons.addNewElement(organization);
            Console.println("organization has been successfully added to the collection!");
        } catch (WrongAmountCommandsException ex) {
            Console.println("incorrect command usage, usage example: " + getName());
        }
    }
}
//    public Dragon adder() {
//        Dragon dragon = new Dragon();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите значение name");
//        String name = scanner.nextLine();
//        if (isEmptyString(name)) {
//            while (isEmptyString(name)) {
//                System.out.println("Поле name не должно быть null или пустым");
//                name = scanner.nextLine();
//            }
//        }
//        dragon.setName(name);
//        System.out.println("Введите значение координаты Х");
//        Double x = null;
//        try{
//            Scanner scanner1 = new Scanner(System.in);
//            x = scanner1.nextDouble();
//        }
//        catch (NoSuchElementException exception){
//            System.out.println("Неправильно введенное значение x");
//        }
//        System.out.println("Введите значение координаты У");
//        Integer y = null;
//        try {
//            Scanner scanner2 = new Scanner(System.in);
//            y = scanner2.nextInt();
//            if (y > 91) {
//                while (y > 91) {
//                    System.out.println("Поле Y должно быть меньше 92!!!");
//                    y = scanner2.nextInt();
//                }
//            }
//        }
//        catch (NoSuchElementException exception){
//            System.out.println("Неправильно введенное значение y");
//
//        }
//
//        dragon.setCoordinates(new Coordinates(x, y));
//        System.out.println("Введите значение поля age");
//        Scanner scanner3 = new Scanner(System.in);
//        int age = scanner3.nextInt();
//        if (age<=0) {
//            while (age <=0) {
//                System.out.println("Поле age должно быть больше 0!!!");
//                age = scanner3.nextInt();
//            }
//        }
//        dragon.setAge(age);
//        System.out.println("Введите значение поля wingspan");
//        Integer wingSpan = scanner3.nextInt();
//        if (wingSpan<=0) {
//            while (wingSpan <=0) {
//                System.out.println("Поле wingSpan должно быть больше 0!!!");
//                wingSpan = scanner3.nextInt();
//            }
//        }
//        dragon.setWingspan(wingSpan);
//        System.out.println("Введите значение поля weight");
//        Scanner scanner4 = new Scanner(System.in);
//        long weight = scanner4.nextLong();
//        if (weight<=0) {
//            while (weight <=0) {
//                System.out.println("Поле weight должно быть больше 0!!!");
//                weight = scanner3.nextInt();
//            }
//        }
//        dragon.setWeight(weight);
//        Scanner scanner5 = new Scanner(System.in);
//        System.out.println("Выберите значение поля character: " + "\n" + "1.Wise" + "\n" + "2.Good" + "\n" + "3.Chaotic_Evil");
//        int k = scanner5.nextInt();
//        while ((k != 1) &&  (k != 2) &&(k != 3)) {
//
//            System.out.println("Выберите значение поля character: " + "\n" + "1.Wise" + "\n" + "2.Good" + "\n" + "3.Chaotic_Evil");
//            k = scanner5.nextInt();
//        }
//        if (k==1) dragon.setCharacter(DragonCharacter.WISE);
//        if (k==2) dragon.setCharacter(DragonCharacter.GOOD);
//        if (k==3) dragon.setCharacter(DragonCharacter.CHAOTIC_EVIL);
//
//        System.out.println("Введите значения поля size");
//        Scanner scanner6 = new Scanner(System.in);
//        Long size = scanner6.nextLong();
//        System.out.println("Введите значения поля eyesCount");
//        Scanner scanner7 = new Scanner(System.in);
//        Double eyesCount = scanner7.nextDouble();
//        System.out.println("Введите значения поля toothCount");
//        Scanner scanner8 = new Scanner(System.in);
//        Float toothCount = scanner8.nextFloat();
//        dragon.setHead(new DragonHead(size, eyesCount, toothCount));
//        dragon.setId(Dragon.generate_id());
//       // dragon.setCreationDate(LocalDateTime.now());
//
//        return dragon;
//
//    }