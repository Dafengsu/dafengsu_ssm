package com.dafengsu.ssm.service;

import com.dafengsu.ssm.domain.Orders;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/1
 */
public interface OrdersService {
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String id) throws Exception;
}
