/*
 * @ (#) BasicOrder.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit.decorator;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

public class BasicOrder implements OrderComponent {
    public void process() {
        System.out.println("Processing basic order.");
    }
}
