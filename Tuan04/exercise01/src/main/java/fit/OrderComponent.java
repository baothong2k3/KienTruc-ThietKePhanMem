/*
 * @ (#) OrderComponent.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

interface OrderComponent {
    void process();
}

class BasicOrder implements OrderComponent {
    public void process() {
        System.out.println("Processing basic order.");
    }
}

class OrderWithTracking implements OrderComponent {
    private OrderComponent decoratedOrder;
    public OrderWithTracking(OrderComponent order) { this.decoratedOrder = order; }
    public void process() {
        decoratedOrder.process();
        System.out.println("Tracking order status...");
    }
}