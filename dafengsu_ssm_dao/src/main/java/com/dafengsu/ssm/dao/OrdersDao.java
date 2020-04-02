package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Member;
import com.dafengsu.ssm.domain.Orders;
import com.dafengsu.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/1
 */
public interface OrdersDao {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM ORDERS")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.dafengsu.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    @Select("SELECT * FROM ORDERS WHERE ID = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "productId", property = "product", javaType = Product.class,
                    one = @One(select = "com.dafengsu.ssm.dao.ProductDao.findById")),
            @Result(column = "memberId", property = "member", javaType = Member.class,
                    one = @One(select = "com.dafengsu.ssm.dao.MemberDao.findByd")),
            @Result(column = "id", property = "travellers", javaType = List.class,
                    many = @Many(select = "com.dafengsu.ssm.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String id) throws Exception;
}
