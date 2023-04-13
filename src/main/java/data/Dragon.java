package data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Dragon implements Comparable<Dragon> {
    private static ArrayList<Long> arrayList = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public static void setArrayList(ArrayList<Long> arrayList) {
        Dragon.arrayList = arrayList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

   public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWingspan(Integer wingspan) {
        this.wingspan = wingspan;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    public java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private Integer wingspan; //Значение поля должно быть больше 0, Поле может быть null
    private long weight; //Значение поля должно быть больше 0
    private DragonCharacter character; //Поле не может быть null
    private DragonHead head;
//    LocalDate creationDate
    public Dragon(Long id, String name, Coordinates coordinates,LocalDate creationDate, int age, Integer wingspan,
                  long weight, DragonCharacter character, DragonHead head) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
//        this.creationDate = creationDate;
        this.age = age;
        this.wingspan = wingspan;
        this.weight = weight;
        this.character = character;
        this.head = head;
    }

    public Dragon() {

    }

    public DragonHead getHead() {
        return head;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

//    public LocalDate getCreationDate() {
//        return creationDate;
//    }

    public int getAge() {
        return age;
    }

    public Integer getWingspan() {
        return wingspan;
    }

    public long getWeight() {
        return weight;
    }

    public static Long generate_id() {
        Long id;
        while (true) {
            id = (long) (1L + (Math.random() * (10000L)));
            if (!arrayList.contains(id)) {
                arrayList.add(id);
                return id;
            }
        }
    }


    public DragonCharacter getCharacter() {
        return character;
    }

    @Override
    public int compareTo(Dragon dragon) {
        return (int) (weight - dragon.getWeight());
    }

    @Override
    public String toString() {
        return "------------Dragon------------" + '\n' +
                "id = " + id + '\n' +
                "name = '" + name + '\'' + '\n' +
                "creationDate=" + creationDate.toLocalDate() + " " + creationDate.toLocalTime()  + '\n' +
                "coordinates = " + coordinates + '\n' +
                "age = " + age + '\n' +
                "wingspan = " + wingspan +'\n' +
                "weight = " + weight +'\n' +
                "character = " + character +'\n' +
                "head = " + head + '\n' +
                "------------------------------" + '\n';
    }


}

