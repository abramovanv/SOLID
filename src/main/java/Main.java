import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        final int MAX_CAPACITY = 3; //Принцип Magic.
        Scanner scanner = new Scanner(System.in);


        ArrayList<Product> warehouse = new ArrayList<Product>();
        //Реализуем принцип Liskov. Класс EdibleProduct выполняет роль Product
        warehouse.add(new EdibleProduct("Хлеб", 50, true));
        warehouse.add(new EdibleProduct("Яблоки", 200, true));
        warehouse.add(new EdibleProduct("Молоко", 80, true));
        warehouse.add(new EdibleProduct("Кефир", 50, true));

        printContent(warehouse);
        ArrayList<Product> basket = new ArrayList<Product>();


        while (true) {
            System.out.println("Введите номер товара для добавления в корзину  или введите end");
            String input = scanner.nextLine(); // "11 31"
            if ("end".equals(input)) {
                break;
            }
            if (basket.size() == MAX_CAPACITY) {
                System.out.println("Достигнут максимальный объем корзины!");
                printContent(basket);
                break;
            }
            String[] parts = input.split(" "); // ["11", "31"]
            int productNumber = Integer.parseInt(parts[0]) - 1;
            basket.add(warehouse.get(productNumber));
            printContent(basket);

        }
    }

    //Принцип DRY. Релизуем метод вывода содержимого корзины и склада
    public static void printContent(ArrayList<Product> arl) {

        for (int i = 0; i < arl.size(); i++) {
            System.out.println((i + 1) + " - " + arl.get(i).nameProduct + " цена " + arl.get(i).priceProduct);
        }
    }

}
