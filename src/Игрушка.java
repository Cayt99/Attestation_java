public class Игрушка {
    private int id;
    private String название;
    private int количество;
    private double вес;

    public Игрушка(int id, String название, int количество, double вес) {
        this.id = id;
        this.название = название;
        this.количество = количество;
        this.вес = вес;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getНазвание() {
        return название;
    }

    public int getКоличество() {
        return количество;
    }

    public void setКоличество(int количество) {
        this.количество = количество;
    }

    public double getВес() {
        return вес;
    }

    public void setВес(double вес) {
        this.вес = вес;
    }
}
