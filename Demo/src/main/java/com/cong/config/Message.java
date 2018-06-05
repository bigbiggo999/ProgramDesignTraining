package com.cong.config;

/**
 * @author cong
 * @date 2018/6/5
 */
public class Message {

    private boolean success;//为true说明成功

    private String error;//错误名称

    private String hint;//提示信息

    public static Message createErr(String error,String hint){
        return new Message(false,error,hint);
    }

    public static Message createSuc(String hint){
        return new Message(true,null,hint);
    }

    public Message(boolean success, String error, String hint) {
        this.success = success;
        this.error = error;
        this.hint = hint;
    }

    public String getError() {
        return error;
    }

    public String getHint() {
        return hint;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {

        return success;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
