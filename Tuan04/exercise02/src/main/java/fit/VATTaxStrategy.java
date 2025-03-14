/*
 * @ (#) VATTaxStrategy.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

// Strategy Pattern: Implements VAT tax calculation
public class VATTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.1; // VAT is 10%
    }
}
