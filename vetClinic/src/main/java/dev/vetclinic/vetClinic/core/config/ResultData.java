package dev.vetclinic.vetClinic.core.config;

import lombok.Getter;

@Getter
public class ResultData<T> extends Result {

    private T data;
    public ResultData(String code, String message, boolean status, T data) {
        super(code, message, status);
        this.data = data;
    }
}