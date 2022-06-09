package com.neusoft.common.base;

public class BaseModelJsonPaging<T> extends BaseModel{
    public T data;
    public Integer total;

    @Override
    public String toString() {
        return "BaseModelJson{" +
                "data=" + data +
                ", total=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
