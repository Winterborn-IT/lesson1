package lesson6.animals;

public class Dog extends Animal {
    protected final static int DOG_RUN_DISTANCE = 500; // ограничения на действия для всех собак
    protected final static int DOG_SWIM_DISTANCE = 10;
    public static int countDogs; // подсчет созданных собак

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int barrierLength) {
        if (barrierLength < DOG_RUN_DISTANCE) {
            System.out.printf("%s пробежал %d м.\n", name, barrierLength);
        } else {
            System.out.printf("%s не смог пробежать %d м.\n", name, barrierLength);
        }
    }

    @Override
    public void swim(int barrierLength) {
        if (barrierLength < DOG_SWIM_DISTANCE) {
            System.out.printf("%s проплыл %d м.\n", name, barrierLength);
        } else {
            System.out.printf("%s не смог проплыть %d м.\n", name, barrierLength);
        }
    }
}
