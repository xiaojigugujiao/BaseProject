package com.luxin.base.service.impl;

import com.luxin.base.config.multids.DataSource;
import com.luxin.base.domain.Account;
import com.luxin.base.domain.Product;
import com.luxin.base.mapper.AccountMapper;
import com.luxin.base.mapper.ProductMapper;
import com.luxin.base.service.IMultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiServiceImpl implements IMultiService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ProductMapper productMapper;


    @Override
    @DataSource(name = "ds1")
    public List<Account> findAccountList() {
        return accountMapper.findList();
    }

    @Override
    @DataSource(name = "ds2")
    public List<Product> findProductList() {
        return productMapper.findList();
    }

}
