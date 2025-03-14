/*
 * @ (#) PaymentContext.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.state;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// Context class for managing payment states
public class PaymentContext {
    private PaymentState state;

    public PaymentContext() {
        this.state = new InitializedState();
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void processPayment() {
        state.handlePayment(this);
    }
}
