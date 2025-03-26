package hello.week3practice.order;

public class Order {
    private long id;
    private String item_name;
    private int item_price;

    public void setId(long id) {
        this.id = id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public long getId() {
        return id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public Order(long id, String item_name, int item_price, int discount_price) {
        this.id = id;
        this.item_name = item_name;
        this.item_price = item_price;
    }
    @Override
    public String toString(){
        return "order: " + "id = " + id + "\n item_name = " + item_name + "\n item_price = " + item_price;
    }
}
