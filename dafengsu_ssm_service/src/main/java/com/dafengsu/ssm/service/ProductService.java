package com.dafengsu.ssm.service;

import com.dafengsu.ssm.domain.Product;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/3/31
 */
public interface ProductService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
