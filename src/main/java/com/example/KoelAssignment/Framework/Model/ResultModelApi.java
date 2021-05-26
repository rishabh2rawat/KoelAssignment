package com.example.KoelAssignment.Framework.Model;


import lombok.Data;

@Data
public class ResultModelApi<T> {

    public String message;
    public boolean error;
    public T response;
    public String responsecode;


    public ResultModelApi(boolean error, String message)
    {
        this.error=error;
        this.message=message;
    }

    public ResultModelApi(boolean error , String message, T response)
    {
        this.error=error;
        this.message=message;
        this.response=response;

    }
    public ResultModelApi(boolean error, String message, T response, String responsecode)
    {
        this.error=error;
        this.message=message;
        this.response=response;
        this.responsecode=responsecode;
    }

}
