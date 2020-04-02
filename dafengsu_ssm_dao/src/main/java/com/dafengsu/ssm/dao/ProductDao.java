package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/3/31
 */
public interface ProductDao {
    @Select("SELECT * FROM PRODUCT WHERE ID = #{id}")
    Product findById(String id) throws Exception;

    @Select("SELECT * FROM PRODUCT")
    List<Product> findAll() throws Exception;
    @Insert("INSERT INTO PRODUCT(PRODUCTNUM, PRODUCTNAME, CITYNAME, DEPARTURETIME," +
            " PRODUCTPRICE, PRODUCTDESC, PRODUCTSTATUS) VALUES(#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus}) ")
    void save(Product product) throws Exception;
}
