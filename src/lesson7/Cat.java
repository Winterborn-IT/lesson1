package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety; // Поле инициализировано по умолчанию false

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (appetite < 0) {
            System.out.println("Введено отрицательное значения аппетита для кота: " + name);
            return;
        }
        if (plate.decreaseFood(appetite)) {
            satiety = true; // Кот поел
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
