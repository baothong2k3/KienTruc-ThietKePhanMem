/*
 * @ (#) Product.java    1.0    25/04/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package iuh.fit.se.orderservice.dtos;/*
 * @description:
 * @author: Bao Thong
 * @date: 25/04/2025
 * @version: 1.0
 */

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer stock;
    private Double price;
}
