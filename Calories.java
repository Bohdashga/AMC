import java.text.DecimalFormat;
import java.util.*;
class Product {
    private int id;
    private int protein;
    private int fat;
    private int carbohydrate;
    private double kilocalories;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getKilocalories() {
        return kilocalories;
    }

    public void setKilocalories(double kilocalories) {
        this.kilocalories = kilocalories;
    }

    public Product(int id, int protein, int fat, int carbohydrate) {
        this.id = id;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void countKilocalories(List<Product> products) {
        for (Product str : products) {
            str.kilocalories = str.getProtein() * 4.1 + str.getFat() * 9.3 + str.getCarbohydrate() * 4.1;
        }
    }

    public static void getQuantity(List<Product> products, List<Integer> food) {
        int n = products.size();

        for (int j = n * 3 + n + 1; j < food.size(); j++) {
            for (Product str : products) {
                if (food.get(j) == str.id) {
                    if (str.quantity != 0) {
                        str.quantity += food.get(j + 1);
                    } else {
                        str.quantity = food.get(j + 1);
                    }
                }
            }
        }
    }


    public static String calculateNumOfKcal(List<Product> products) {
        double sum = 0;
        for (Product str : products) {
            sum += str.getKilocalories() * str.getQuantity();
        }
        DecimalFormat df1 = new DecimalFormat("#.00");
        return df1.format(sum);
    }
}

public class Calories {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> food = new ArrayList<>();

        while (scanner.hasNextInt()) {
            food.add(scanner.nextInt());
        }

        List<Product> products = new ArrayList<>();

        int i = 0;
        while (food.get(i) != -1) {
            products.add(new Product(food.get(i), food.get(i + 1), food.get(i + 2), food.get(i + 3)));
            i+=4;
        }

        Product.countKilocalories(products);
        Product.getQuantity( products, food);

        System.out.print((Product.calculateNumOfKcal(products)));

    }
}
