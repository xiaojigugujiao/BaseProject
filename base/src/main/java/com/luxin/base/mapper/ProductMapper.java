package com.luxin.base.mapper;

import com.luxin.base.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> findList();
}
