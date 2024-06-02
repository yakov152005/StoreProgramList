import java.util.*;

public class Store {
    private String storeName;
    private List<Salesman> salesmanList;
    private List<Product> productList;
    public static final List<String> PRODUCTS_ITEM = List.of("Shirt","Jeans","Boxer","T-Shirt","Shoes","Gloves","Belt");
    private Map<Integer, List<String>> bonusDayProduct;
    private static Random r = new Random();

    public Store(String shopName,List<Salesman> salesmanList,List<Product> productList){
        this.storeName = shopName;
        this.salesmanList = salesmanList;
        this.productList = productList;
        this.bonusDayProduct = fillBonusDayMap();
    }
    public Map<Integer, List<String>> fillBonusDayMap() {
        Map<Integer, List<String>> temp = new HashMap<>();
        for (int i = 1; i <= 7; i++) {
            int randomForProduct = r.nextInt(1, 4); // 1 to 3 products
            List<String> productsForDay = new ArrayList<>();
            for (int j = 0; j < randomForProduct; j++) {
                productsForDay.add(PRODUCTS_ITEM.get(r.nextInt(PRODUCTS_ITEM.size())));
            }
            temp.put(i, productsForDay);
        }
        return temp;
    }

    public void randomWeeklySalesGenerator(int min, int max) {
        for (int i = 1; i <= 7; i++) {
            int randomSalesCount = r.nextInt(min, max + 1);
            for (int j = 0; j < randomSalesCount; j++) {
                Product productForSold = productList.get(r.nextInt(productList.size()));
                int randomSalesmanIndex = r.nextInt(salesmanList.size());
                Salesman salesman = salesmanList.get(randomSalesmanIndex);

                salesman.updateSale(i, productForSold);
                if (bonusDayProduct.get(i).contains(productForSold.getProduct())) {
                    int bonusForSalesman = salesman.getWeeklySalary() + productForSold.getPrice() / 20;
                    salesman.setWeeklySalary(bonusForSalesman);
                }
            }
        }

        // Print weekly sales summary
        for (Salesman salesman : salesmanList) {
            System.out.println(salesman);
        }
    }

    public void theHighestWeeklySalary(){
        int highestSalary = 0;
        String nameHighestSalary = "";

        for (Salesman salesman: salesmanList){
            if (salesman.getWeeklySalary() > highestSalary){
                highestSalary = salesman.getWeeklySalary();
            }
        }
        for (Salesman salesman : salesmanList){
            if (salesman.getWeeklySalary() == highestSalary){
                nameHighestSalary = salesman.getFullName();
            }
        }
        System.out.println("The salesman with highest weekly sales is ---> " + nameHighestSalary
                + " The highst salary is: " + highestSalary);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Store: ").append(this.storeName).append("\n");
        sb.append("Products---> ");
        for (Product product: this.productList){
            sb.append(product).append("\n");
        }
        sb.append("Bonuses list---> ");
        sb.append("\n");
        for (Integer bonusDay : this.bonusDayProduct.keySet()){
            sb.append("Day: ").append(bonusDay).append(", Bonus: ").append(this.bonusDayProduct.get(bonusDay));
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }


}
