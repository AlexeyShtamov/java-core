package school.sorokin.javacore.testing.testing_exam;

public class Order {
    private int id;
    private String productName;
    private int quantity;
    private double initPrice;

    public Order(int id, String productName, int quantity, double initPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.initPrice = initPrice;
    }

    public double getTotalPrice(){
        return quantity*initPrice;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getInitPrice() {
        return initPrice;
    }
}
