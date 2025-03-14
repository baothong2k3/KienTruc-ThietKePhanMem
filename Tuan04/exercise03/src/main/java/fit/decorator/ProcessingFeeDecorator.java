/*
 * @ (#) ProcessingFeeDecorator.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.decorator;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// Decorator: Processing Fee
public class ProcessingFeeDecorator implements PaymentFeature {
    private PaymentFeature feature;

    public ProcessingFeeDecorator(PaymentFeature feature) {
        this.feature = feature;
    }

    @Override
    public double applyFeature(double amount) {
        return feature.applyFeature(amount) + 5.0; // Add $5 processing fee
    }
}
