package com.cos.retrofit2movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NonNull
public class ResponseDto<T> {
    private int statusCode;
    private T data;
}
