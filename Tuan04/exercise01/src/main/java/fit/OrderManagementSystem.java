package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// OrderState.java (State Pattern)
// ShippingStrategy.java (Strategy Pattern)
// OrderComponent.java (Decorator Pattern)

public class OrderManagementSystem {
    public static void main(String[] args) {

        // State Pattern Usage
        System.out.println("---State Pattern Usage---");
        OrderContext orderContext = new OrderContext();
        orderContext.processOrder();
        orderContext.processOrder();
        orderContext.processOrder();

        // Strategy Pattern Usage
        System.out.println("---Strategy Pattern Usage---");
        Order order = new Order();
        order.setShippingStrategy(new StandardShipping());
        order.shipOrder();

        order.setShippingStrategy(new ExpressShipping());
        order.shipOrder();

        // Decorator Pattern Usage
        System.out.println("---Decorator Pattern Usage---");
        OrderComponent basicOrder = new BasicOrder();
        OrderComponent trackedOrder = new OrderWithTracking(basicOrder);
        trackedOrder.process();
    }
}
/*
Kết luận:
    - State Pattern giúp quản lý trạng thái của đơn hàng một cách rõ ràng và có thể dễ dàng mở rộng.
    - Strategy Pattern giúp thay đổi chiến lược vận chuyển linh hoạt mà không cần thay đổi mã nguồn chính.
    - Decorator Pattern giúp mở rộng tính năng (ví dụ: thêm tracking) mà không làm thay đổi lớp gốc.
*/
