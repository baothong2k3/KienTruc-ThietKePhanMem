/*
 * @ (#) Task.java    1.0    22/03/2025
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

public class Task implements Subject {
    private String taskInfo;
    private String status;
    private List<Observer> observers = new ArrayList<>();

    public Task(String taskInfo, String status) {
        this.taskInfo = taskInfo;
        this.status = status;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(taskInfo, status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers(); // Notify when status changes
    }

    public String getStatus() {
        return status;
    }
}