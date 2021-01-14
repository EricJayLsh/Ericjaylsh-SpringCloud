package com.ericjaylsh.springcloud.dao;

import com.ericjaylsh.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname StorageDao
 * @Description
 * @Date 2020/9/8 10:19
 * @Created by EricJayLsh
 */
@Mapper
public interface StorageDao {

    int decrease(@Param("productId") Long productId, @Param("count") Integer count);

    List<Storage> selectAll();
}
