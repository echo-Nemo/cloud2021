package com.echo.vo;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ResultVO<T> implements Serializable {
    private int code;
    private String message;
    private T data;
}
