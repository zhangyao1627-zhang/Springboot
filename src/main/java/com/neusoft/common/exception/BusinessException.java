package com.neusoft.common.exception;

public class BusinessException extends RuntimeException {

    public static final BusinessException USER_INVALID =
            new BusinessException(101, "The username or password is wrong", new Object[0]);
    public static final BusinessException USER_NOT_EXISTS =
            new BusinessException(101, "The username doesnot exist", new Object[0]);
    public static final BusinessException PAOOSWORD_ERROR =
            new BusinessException(101, "The passord is wrong", new Object[0]);

    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException() {
    }

    public BusinessException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
        this.msg = String.format(msg, args);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException newInstance(String msg, Object... args) {
        return new BusinessException(this.code, msg, args);
    }
}
