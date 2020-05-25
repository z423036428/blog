package com.blog.blog.common;

import java.util.ArrayList;

public class DataPackage<T> {

    public ArrayList<T> data;

    public boolean success;

    public String msg;

    public DataPackage() {
    }

    public DataPackage(ArrayList<T> data, boolean success, String msg) {
        this.data = data;
        this.success = success;
        this.msg = msg;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
