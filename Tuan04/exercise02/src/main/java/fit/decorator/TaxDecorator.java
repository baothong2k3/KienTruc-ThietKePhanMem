/*
 * @ (#) TaxDecorator.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.decorator;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

import fit.strategy.TaxStrategy;

// Decorator Pattern: Base class for extending tax calculations
public abstract class TaxDecorator implements TaxStrategy {
    protected TaxStrategy wrappedTaxStrategy;

    public TaxDecorator(TaxStrategy wrappedTaxStrategy) {
        this.wrappedTaxStrategy = wrappedTaxStrategy;
    }
}
