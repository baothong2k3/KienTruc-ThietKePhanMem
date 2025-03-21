/*
 * @ (#) UIComponent.java    1.0    22/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/03/2025
 * @version: 1.0
 */

public interface UIComponent {
    void render();
    void add(UIComponent component);
    void remove(UIComponent component);
    UIComponent getChild(int index);
}
