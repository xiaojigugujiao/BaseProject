package com.luxin.base.service;

import com.luxin.base.domain.Account;
import com.luxin.base.domain.Product;

import java.util.List;

public interface IMultiService {

    List<Account> findAccountList();

    List<Product> findProductList();
}
