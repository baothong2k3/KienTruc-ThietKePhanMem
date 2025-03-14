/*
 * @ (#) PaymentFeature.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.decorator;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// --- Decorator Pattern ---
// Component interface for additional payment features
public interface PaymentFeature {
    double applyFeature(double amount);
}

