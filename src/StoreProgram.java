import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StoreProgram {
    public static void main(String[] args) {
        new StoreProgram();


    }
    public StoreProgram(){
        List<Product> productList = fillingProducts();
        List<Salesman> salesmenList = fillingSalesman();
//        salesGenerator(salesmenList,productList);

        Store store = new Store("YakovShop",salesmenList,productList);
        System.out.println(store);

        System.out.println("Enter sales range --->");
        System.out.println("Min: ");
        int min = s.nextInt();
        System.out.println("Max: ");
        int max = s.nextInt();

        store.randomWeeklySalesGenerator(min,max);

        System.out.println();
        System.out.println(productList);

        store.theHighestWeeklySalary();



    }

    public static List<Product> fillingProducts(){
        List<Product> temp = new LinkedList<>();
        for (int i = 0; i < 10 ; i ++){
            Product  newProduct = new Product(Store.PRODUCTS_ITEM.get(r.nextInt(Store.PRODUCTS_ITEM.size())), r.nextInt(5000));
            temp.add(newProduct);
        }
        return temp;
    }

    public static List<Salesman> fillingSalesman(){
        final int BASE_WEEKLY_SALARY = 5000;
        List<String> firstName = List.of("Yakov","Daniel","Ido","Itay","Amir","Shalev","Noa","Idan");
        List<String> lastName = List.of("BH","GI","BB","CC","AA","EE","WW","PP");

        List<Salesman> temp = new LinkedList<>();
        for (int i = 0; i < firstName.size(); i++) {
            Salesman newSalesman = new Salesman(firstName.get(i),lastName.get(i),BASE_WEEKLY_SALARY);
            temp.add(newSalesman);
        }
        return temp;
    }

    public static void salesGenerator(List<Salesman> salesmenList,List<Product> productList){
        for (int i = 0; i < salesmenList.size(); i++) {
            for (int j = 1; j <= 7 ; j++) {
                salesmenList.get(r.nextInt(0,8)).updateSale(j,productList.get(r.nextInt(6)));
            }
        }
        System.out.println(salesmenList);
    }

    public static Random r = new Random();
    public static Scanner s = new Scanner(System.in);
}
