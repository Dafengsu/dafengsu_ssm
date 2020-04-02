package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
public interface UserDao {
    @Select("SELECT * FROM USERS WHERE USERNAME = #{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
            many = @Many(select = "com.dafengsu.ssm.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findByUserName(String username) throws Exception;

    @Select("SELECT * FROM USERS")
    List<UserInfo> findAll() throws Exception;

    @Insert("INSERT INTO USERS(EMAIL, USERNAME, PASSWORD, PHONENUM, STATUS)" +
            " VALUES(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;


}
