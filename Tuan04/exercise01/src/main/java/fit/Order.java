/*
 * @ (#) Order.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

class Order {
    private ShippingStrategy shippingStrategy;

    public void setShippingStrategy(ShippingStrategy strategy) {
        this.shippingStrategy = strategy;
    }

    public void shipOrder() {
        shippingStrategy.ship();
    }
}