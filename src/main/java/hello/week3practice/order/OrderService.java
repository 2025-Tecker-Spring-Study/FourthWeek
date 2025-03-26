package hello.week3practice.order;

public interface OrderService {
    Order createOrder(long member_id, String item_name, int item_price);
}
