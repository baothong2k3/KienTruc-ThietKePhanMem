/*
 * @ (#) Product.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.product;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

import fit.strategy.TaxStrategy;

// State Pattern: Allows dynamic assignment of TaxStrategy to Product
public class Product {
    private String name;
    private double basePrice;
    private TaxStrategy taxStrategy;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double calculateFinalPrice() {
        double tax = taxStrategy != null ? taxStrategy.calculateTax(basePrice) : 0;
        return basePrice + tax;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Base Price: " + basePrice;
    }
}
