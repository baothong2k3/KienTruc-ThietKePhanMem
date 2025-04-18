/*
 * @ (#) NewOrderState.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.state;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

public class NewOrderState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Checking order information...");
        context.setState(new ProcessingState());
    }
}
