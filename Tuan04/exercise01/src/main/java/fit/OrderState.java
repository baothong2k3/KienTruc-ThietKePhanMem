/*
 * @ (#) OrderState.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// OrderState.java (State Pattern)
interface OrderState {
    void handleOrder(OrderContext context);
}

class NewOrderState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Checking order information...");
        context.setState(new ProcessingState());
    }
}

class ProcessingState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Packing and shipping the order...");
        context.setState(new DeliveredState());
    }
}

class DeliveredState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Order delivered successfully.");
    }
}

class CanceledState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Order canceled, processing refund...");
    }
}
