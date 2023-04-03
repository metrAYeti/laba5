package data;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 91, Поле не может быть null

    public Coordinates(Double x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {

    }

    public Double getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }

    @Override
    public int hashCode() {
        return y.hashCode() + x.intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinatesObj = (Coordinates) obj;
            return (x.equals(coordinatesObj.getX())) && y.equals(coordinatesObj.getY());
        }
        return false;
    }
}