/*
 * @ (#) ProcessingState.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.state;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// Concrete State: Processing
public class ProcessingState implements PaymentState {
    @Override
    public void handlePayment(PaymentContext context) {
        System.out.println("Payment is being processed.");
        context.setState(new CompletedState());
    }
}
