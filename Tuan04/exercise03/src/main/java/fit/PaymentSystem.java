/*
 * @ (#) PaymentSystem.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

import fit.decorator.BasePayment;
import fit.decorator.DiscountCodeDecorator;
import fit.decorator.PaymentFeature;
import fit.decorator.ProcessingFeeDecorator;
import fit.state.PaymentContext;
import fit.strategy.CreditCardPayment;
import fit.strategy.PayPalPayment;
import fit.strategy.PaymentProcessor;

public class PaymentSystem {
    public static void main(String[] args) {
        // State Pattern demonstration
        System.out.println("---State Pattern demonstration---");
        PaymentContext context = new PaymentContext();
        context.processPayment();
        context.processPayment();
        context.processPayment();

        // Strategy Pattern demonstration
        System.out.println("\n---Strategy Pattern demonstration---");
        PaymentProcessor processor = new PaymentProcessor();
        processor.setPaymentMethod(new CreditCardPayment());
        processor.processPayment(100.0);
        processor.setPaymentMethod(new PayPalPayment());
        processor.processPayment(150.0);

        // Decorator Pattern demonstration
        System.out.println("\n---Decorator Pattern demonstration---");
        PaymentFeature payment = new BasePayment();
        payment = new ProcessingFeeDecorator(payment);
        payment = new DiscountCodeDecorator(payment);

        double finalAmount = payment.applyFeature(200.0);
        System.out.println("Final payment amount after features: " + finalAmount);
    }
}
/*
State Pattern:
    - Được sử dụng tốt để quản lý các trạng thái của hệ thống thanh toán (Initialized, Processing, Completed).
    - Dễ dàng mở rộng nếu cần thêm trạng thái mới, như Failed hoặc Refunded.
Strategy Pattern:
    - Phù hợp cho việc hỗ trợ nhiều phương thức thanh toán khác nhau (Credit Card, PayPal, v.v.).
    - Dễ dàng thêm các phương thức thanh toán khác mà không làm ảnh hưởng đến mã hiện có.
Decorator Pattern:
    - Được áp dụng linh hoạt để bổ sung các tính năng như phí xử lý hoặc mã giảm giá.
    - Các tính năng có thể kết hợp tự do và thứ tự áp dụng tính năng không ảnh hưởng đến cấu trúc.
*/
