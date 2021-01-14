package com.ericjaylsh.springcloud.dao;

import com.ericjaylsh.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname OrderDao
 * @Description
 * @Date 2020/9/7 18:53
 * @Created by EricJayLsh
 */
@Mapper
public interface OrderDao {

    void create(@Param("order") Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);

    List<Order> selectAll();
}
