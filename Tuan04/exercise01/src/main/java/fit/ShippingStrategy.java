/*
 * @ (#) ShippingStrategy.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

interface ShippingStrategy {
    void ship();
}

class StandardShipping implements ShippingStrategy {
    public void ship() {
        System.out.println("Shipping with standard delivery.");
    }
}

class ExpressShipping implements ShippingStrategy {
    public void ship() {
        System.out.println("Shipping with express delivery.");
    }
}