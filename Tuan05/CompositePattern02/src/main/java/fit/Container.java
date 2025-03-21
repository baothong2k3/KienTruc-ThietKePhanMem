/*
 * @ (#) Container.java    1.0    22/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/03/2025
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Container implements UIComponent {
    private List<UIComponent> children = new ArrayList<>();

    @Override
    public void render() {
        System.out.println("Rendering Container");
        for (UIComponent component : children) {
            component.render();
        }
    }

    @Override
    public void add(UIComponent component) {
        children.add(component);
    }

    @Override
    public void remove(UIComponent component) {
        children.remove(component);
    }

    @Override
    public UIComponent getChild(int index) {
        return children.get(index);
    }
}