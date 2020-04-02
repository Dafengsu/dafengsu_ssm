package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/1
 */
public interface TravellerDao {
    @Select("SELECT * FROM TRAVELLER WHERE ID IN " +
            "(SELECT TRAVELLERID FROM ORDER_TRAVELLER WHERE ORDERID = #{ordersId})")
    List<Traveller> findByOrdersId(String ordersId);
}
