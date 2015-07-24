package com.ekiras.util.response;

/**
 * Created by ekansh on 24/7/15.
 */
public class ResponseDTO {

    private Integer status = 1;
    private String message;
    private Object data = new Object();
    private Integer code = 200;

    public ResponseDTO(){}
    public ResponseDTO(Object data, String message){
        this.data = data;
        this.message = message;
    }
    public ResponseDTO(Object data, String message, Integer code){
        this.data = data;
        this.message = message;
        this.code = code;
    }
    public ResponseDTO(Object data, String message, Integer code, Integer status){
        this.data = data;
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
