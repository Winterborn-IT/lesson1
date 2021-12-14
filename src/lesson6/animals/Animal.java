package lesson6.animals;

public class Animal {
    protected String name;
    public static int countAnimals;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public void run(int barrierLength) {
        System.out.println("run...");
    }

    public void swim(int barrierLength) {
        System.out.println("swim...");
    }
}
