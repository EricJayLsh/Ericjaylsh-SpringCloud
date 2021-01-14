package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.dao.StorageDao;
import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname StorageServiceImpl
 * @Description
 * @Date 2020/9/7 19:30
 * @Created by EricJayLsh
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public CommonResult decrease(Long productId, Integer count)throws NullPointerException {
        throw new NullPointerException("模拟服务调用异常！");
        // return new CommonResult(200, "库存扣减正常！", storageDao.decrease(productId, count));
    }

    @Override
    public CommonResult selectAll() {
        return new CommonResult(200, "success", storageDao.selectAll());
    }
}
