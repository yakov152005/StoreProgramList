public class Product {
    private String product;
    private int price;
    private int amountProduct;

    public Product(String product,int price){
        this.product = product;
        this.price = price;
        this.amountProduct = StoreProgram.r.nextInt(5,25);
    }


    public String getProduct() {
        return product;
    }

    public boolean setAmountProduct(int amountProduct) {
        if (this.amountProduct >= 1){
            this.amountProduct -= amountProduct;
            return true;
        }
        return false;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Produce: ").append(this.product);
        sb.append("\n").append("Price: ").append(this.price).append("\n");
        sb.append("In The Stock: ").append(amountProduct).append("\n");
        return sb.toString();
    }
}
