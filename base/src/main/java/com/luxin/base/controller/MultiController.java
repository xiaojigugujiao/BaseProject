package com.luxin.base.controller;

import com.luxin.base.domain.Account;
import com.luxin.base.domain.Product;
import com.luxin.base.service.IMultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/multi")
public class MultiController {

    @Autowired
    private IMultiService multiService;

    @RequestMapping("/accountList")
    public List<Account> findAccountList(){
        return multiService.findAccountList();
    }

    @RequestMapping("/productList")
    public List<Product> findProductList(){
        return multiService.findProductList();
    }
}
