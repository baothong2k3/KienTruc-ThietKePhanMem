/*
 * @ (#) TeamMember.java    1.0    22/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/03/2025
 * @version: 1.0
 */

public class TeamMember implements Observer {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    @Override
    public void update(String taskInfo, String status) {
        System.out.println("Member " + name + " notified: Task '" + taskInfo + "' updated to status: " + status);
    }
}