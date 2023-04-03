package data;

public class DragonHead implements Comparable<DragonHead> {

    private Long size; //Поле может быть null
    private double eyesCount;
    private Float toothCount; //Поле не может быть null

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public double getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(double eyesCount) {
        this.eyesCount = eyesCount;
    }

    public Float getToothCount() {
        return toothCount;
    }

    public void setToothCount(Float toothCount) {
        this.toothCount = toothCount;
    }

    public DragonHead(Long size, double eyesCount, Float toothCount) {
        this.size = size;
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }
    public DragonHead(){

    }

    @Override
    public String toString() {
        return "DragonHead{" +
                "size=" + size +
                ", eyesCount=" + eyesCount +
                ", toothCount=" + toothCount +
                '}';
    }

    @Override
    public int compareTo(DragonHead o) {
        return Double.compare((double) size * 17 + 3 * (eyesCount) + 11 * (double) toothCount, (double) o.size * 17 + 3 * (o.eyesCount) + 11 * (double) o.toothCount);
    }
}
