/*
 * @ (#) TaxCalculationDemo.java    1.0    14/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/03/2025
 * @version: 1.0
 */

import fit.decorator.EnvironmentalTaxDecorator;
import fit.product.Product;
import fit.strategy.LuxuryTaxStrategy;
import fit.strategy.TaxStrategy;
import fit.strategy.VATTaxStrategy;

// Demo class: Tests the usage of Strategy, State, and Decorator Patterns
public class TaxCalculationDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Luxury Car", 50000);
        Product product2 = new Product("Basic Item", 100);

        // Apply different tax strategies (Strategy Pattern)
        System.out.println("--- Applying different tax strategies ---");
        product1.setTaxStrategy(new LuxuryTaxStrategy());
        product2.setTaxStrategy(new VATTaxStrategy());

        System.out.println(product1 + ", Final Price: " + product1.calculateFinalPrice());
        System.out.println(product2 + ", Final Price: " + product2.calculateFinalPrice());

        // Add decorator to tax strategy (Decorator Pattern)
        System.out.println("--- Applying decorator to tax strategy ---");
        TaxStrategy ecoFriendlyLuxuryTax = new EnvironmentalTaxDecorator(new LuxuryTaxStrategy());
        product1.setTaxStrategy(ecoFriendlyLuxuryTax);

        System.out.println(product1 + " with Environmental Tax, Final Price: " + product1.calculateFinalPrice());
    }
}
// Kết luận: Triển khai này minh họa cách các mẫu thiết kế (Design Patterns) khác nhau được sử dụng cùng nhau để đạt được tính mô-đun và linh hoạt trong hệ thống tính thuế.
// - Strategy Pattern: Cho phép lựa chọn logic tính thuế một cách linh động.
// - State Pattern: Hỗ trợ thay đổi hành vi động bằng cách gán chiến lược tính thuế khác nhau cho sản phẩm.
// - Decorator Pattern: Bổ sung các chức năng mới (ví dụ: thuế môi trường) mà không cần thay đổi mã hiện có.
// Cấu trúc này làm cho hệ thống có tính mở rộng, dễ bảo trì, và dễ sửa đổi khi có các quy định hoặc yêu cầu thuế mới.
