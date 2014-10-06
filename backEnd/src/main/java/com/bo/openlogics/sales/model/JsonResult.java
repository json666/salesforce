package com.bo.openlogics.sales.model;

/**
 * Created by json on 7/09/14.
 */

public class JsonResult {
    private Boolean success;
    private String message;
    private Object result;

    public JsonResult(Boolean success, String message, Object result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public JsonResult() {
    }

    public JsonResult(boolean b, Usuario usuario) {
    }

    public JsonResult(boolean b, String message) {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
