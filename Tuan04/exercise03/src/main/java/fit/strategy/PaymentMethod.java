/*
 * @ (#) PaymentMethod.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.strategy;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// --- Strategy Pattern ---
// Strategy interface for payment methods
public interface PaymentMethod {
    void pay(double amount);
}

