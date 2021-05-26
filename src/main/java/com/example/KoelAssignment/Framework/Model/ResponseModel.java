package com.example.KoelAssignment.Framework.Model;

import lombok.Data;

@Data
public class ResponseModel<T> {

    public String message;
    public T data;

    public ResponseModel(T data, String message)
    {
        this.data=data;
        this.message=message;

    }
    public ResponseModel(String message)
    {
        this.message=message;
    }

}
