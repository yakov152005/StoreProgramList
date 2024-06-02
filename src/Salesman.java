import java.util.*;

public class Salesman {
    private String firstName;
    private String lastName;
    private int weeklySalary;
    private Map<Integer, List<Product>> productSales;
    public static Random r = new Random();


    public Salesman(String firstName, String lastName,int weeklySalary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.weeklySalary = weeklySalary;
        this.productSales = new HashMap<>();
        for (int i = 1; i <= 7; i++) {
            this.productSales.put(i, new ArrayList<>());
        }
    }

    public void updateSale(int day, Product sold){
        List<Product> soldProducts = this.productSales.get(day);
        if (soldProducts == null){
            soldProducts = new ArrayList<>();
        }
        if (sold.setAmountProduct(1)) {
            int bonusForSalesman = this.weeklySalary + (sold.getPrice() / 10);
            setWeeklySalary(bonusForSalesman);
            soldProducts.add(sold);
            this.productSales.put(day, soldProducts);
        }else {
            System.out.println("The product is out of the stock");
        }
    }

    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public Map<Integer, List<Product>> getProductSales() {
        return productSales;
    }

    public int getWeeklySalary() {
        return weeklySalary;
    }

    public String getFullName(){
        return this.firstName +" " + this.lastName;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Salesman: ").append(this.getFullName()).append("\n");
        sb.append("Weekly Salary: ").append(this.weeklySalary).append("\n");
        sb.append("Sold Product--->").append("\n");

        for (int day : productSales.keySet()){
            sb.append("Day: ").append(day).append(", Total Sales: ");
            List<Product> sales = productSales.get(day);
            if (sales == null){
                sb.append(0);
            }else {
                sb.append(sales.size());
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

}
