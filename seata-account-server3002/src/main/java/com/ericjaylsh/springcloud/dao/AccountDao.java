package com.ericjaylsh.springcloud.dao;

import com.ericjaylsh.springcloud.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname AccountDao
 * @Description
 * @Date 2020/9/8 10:03
 * @Created by EricJayLsh
 */
@Mapper
public interface AccountDao {

    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

    List<Account> selectAll();
}
