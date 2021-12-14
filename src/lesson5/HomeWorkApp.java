package lesson5;

public class HomeWorkApp {
    public static void main(String[] args) {
        Employee[] personalArray = new Employee[5];

        personalArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        personalArray[1] = new Employee("Zaitsev Vladimir", "Locksmith", "zaitsev@gmail.com", "92734834814", 45000, 56);
        personalArray[2] = new Employee("Aleksandrov Pavel", "Master", "pavel95@yandex.ru", "8905638434214", 60000, 27);
        personalArray[3] = new Employee("Voloshenko Evgeniy", "Electrician", "evgeniygg@mail.ru", "89375829225", 22000, 48);
        personalArray[4] = new Employee("Lisitskiy Maxim", "Chemist", "lisit@gmail.ru", "8999343422", 35000, 33);

        for (Employee employee : personalArray) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }
}
