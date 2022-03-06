package com.echo.dao;

import com.echo.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    public void storageDecrease(@Param("productId")Long productId,@Param("count") Integer count);
}
