/*
 * @ (#) DiscountCodeDecorator.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.decorator;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

//Decorator: Discount Code

public class DiscountCodeDecorator implements PaymentFeature {
    private PaymentFeature feature;

    public DiscountCodeDecorator(PaymentFeature feature) {
        this.feature = feature;
    }

    @Override
    public double applyFeature(double amount) {
        return feature.applyFeature(amount) - 10.0; // Subtract $10 discount
    }
}
