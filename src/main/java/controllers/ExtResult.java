package controllers;

import model.Car;

/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 06.10.13
 * Time: 3:13
 * To change this template use File | Settings | File Templates.
 */

public class ExtResult {
    private boolean success;
    private Car data;


    public ExtResult(boolean success, Car data) {
        this.success = success;
        this.data = data;
    }

    public ExtResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Car getData() {
        return data;
    }

    public void setData(Car data) {
        this.data = data;
    }
}
