/*
 * @ (#) EnvironmentalTaxDecorator.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.decorator;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

import fit.strategy.TaxStrategy;

// Decorator Pattern: Adds an additional environmental tax
public class EnvironmentalTaxDecorator extends TaxDecorator {
    public EnvironmentalTaxDecorator(TaxStrategy wrappedTaxStrategy) {
        super(wrappedTaxStrategy);
    }

    @Override
    public double calculateTax(double price) {
        double baseTax = wrappedTaxStrategy.calculateTax(price);
        return baseTax + (price * 0.02); // Additional 2% environmental tax
    }
}
