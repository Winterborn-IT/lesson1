package lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] catsArr = {
                new Cat("Барсик", 15),
                new Cat("Пушок", 25),
                new Cat("Рыжик", -20),
                new Cat("Васька", 25),
                new Cat("Дымок", 30)
        };
        Plate plate = new Plate(100);

        for (Cat cat : catsArr) {
            cat.eat(plate);
            System.out.printf("Кот %s поел? %s\n", cat.getName(), cat.isSatiety());
        }

        plate.addFoodToPlate(100);
        plate.addFoodToPlate(-20);
    }
}
