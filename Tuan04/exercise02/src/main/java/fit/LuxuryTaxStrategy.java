/*
 * @ (#) LuxuryTaxStrategy.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// Strategy Pattern: Implements Luxury tax calculation
public class LuxuryTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.2; // Luxury tax is 20%
    }
}
