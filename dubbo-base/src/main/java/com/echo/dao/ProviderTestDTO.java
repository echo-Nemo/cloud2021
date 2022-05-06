package com.echo.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
public class ProviderTestDTO implements Serializable {
    // ID
    private int id;
    // 名字
    private String name;
    // 序号
    private Integer number;
}
