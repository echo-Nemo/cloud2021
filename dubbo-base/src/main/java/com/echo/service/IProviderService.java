package com.echo.service;

import com.echo.dao.ProviderTestDTO;

import java.util.List;

/**
 * 提供远程调用的接口
 */
public interface IProviderService {
    List<ProviderTestDTO> queryList();
}
