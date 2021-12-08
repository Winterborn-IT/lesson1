package lesson6.animals;

public class Cat extends Animal {
    protected final static int CAT_RUN_DISTANCE = 200; // ограничения на действия для всех котов
    public static int countCats; // подсчет созданных котов

    public Cat(String name) {
        super(name);
        countCats++;
    }

    @Override
    public void run(int barrierLength) {
        if (barrierLength < CAT_RUN_DISTANCE) {
            System.out.printf("%s пробежал %d м.\n", name, barrierLength);
        } else {
            System.out.printf("%s не смог пробежать %d м.\n", name, barrierLength);
        }
    }

    @Override
    public void swim(int barrierLength) {
        System.out.println("Коты не умеют плавать\n");
    }
}
