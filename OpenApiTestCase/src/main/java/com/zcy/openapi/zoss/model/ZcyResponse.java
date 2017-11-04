package com.zcy.openapi.zoss.model;

import java.io.Serializable;

/**
 * Created by changle on 16/8/3.
 */
public class ZcyResponse<T> implements Serializable {
    private static final long serialVersionUID = -759890833749014618L;
    private boolean success;
    private T result;
    private String error;

    public ZcyResponse() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

    public String toString() {
        return new StringBuffer().append("success:{").append(this.success)
                .append("},result:{").append(this.result)
                .append("},error:{").append(this.error).toString();
    }

    public static <T> ZcyResponse<T> ok(T data) {
        ZcyResponse resp = new ZcyResponse();
        resp.setResult(data);
        return resp;
    }

    public static <T> ZcyResponse<T> ok() {
        return ok((T)null);
    }

    public static <T> ZcyResponse<T> fail(String error) {
        ZcyResponse resp = new ZcyResponse();
        resp.setError(error);
        return resp;
    }
}
