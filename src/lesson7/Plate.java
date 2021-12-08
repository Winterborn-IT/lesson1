package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (amount < food) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFoodToPlate(int dish) {
        if (dish > 0) {
            food += dish;
        } else {
            System.out.println("Введено отрицательное число еды.");
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
