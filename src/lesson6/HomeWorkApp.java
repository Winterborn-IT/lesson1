package lesson6;

import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

public class HomeWorkApp {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        Cat cat = new Cat("Барсик");
        Cat cat1 = new Cat("Фуфик");

        dog.run(250);
        cat.run(100);
        dog.swim(50);
        cat.swim(30);

        System.out.println("Подсчет созданных котов: " + Cat.countCats);
        System.out.println("Подсчет созданных собак: " + Dog.countDogs);
        System.out.println("Подсчет созданных животных: " + Animal.countAnimals);

    }
}
