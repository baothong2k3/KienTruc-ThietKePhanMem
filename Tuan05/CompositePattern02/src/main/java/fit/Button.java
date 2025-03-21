/*
 * @ (#) Button.java    1.0    22/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/03/2025
 * @version: 1.0
 */

public class Button implements UIComponent {
    @Override
    public void render() {
        System.out.println("Rendering Button");
    }

    @Override
    public void add(UIComponent component) {
        throw new UnsupportedOperationException("Cannot add to a Button");
    }

    @Override
    public void remove(UIComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a Button");
    }

    @Override
    public UIComponent getChild(int index) {
        throw new UnsupportedOperationException("Button has no children");
    }
}