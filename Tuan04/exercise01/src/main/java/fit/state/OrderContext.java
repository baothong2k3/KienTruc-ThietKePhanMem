/*
 * @ (#) OrderContext.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.state;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

public class OrderContext {
    private OrderState state;
    public OrderContext() { this.state = new NewOrderState(); }
    public void setState(OrderState state) { this.state = state; }
    public void processOrder() { state.handleOrder(this); }
}