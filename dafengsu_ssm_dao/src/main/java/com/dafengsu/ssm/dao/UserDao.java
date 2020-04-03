package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Role;
import com.dafengsu.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

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

    @Select("SELECT * FROM USERS WHERE ID = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select = "com.dafengsu.ssm.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findById(String id) throws Exception;

    @Delete("DELETE FROM USERS_ROLE WHERE USERID = #{id}")
    void deleteFromUser_RoleByUserId(String id) throws Exception;

    @Delete("DELETE FROM USERS WHERE ID = #{id}")
    void deleteById(String id) throws Exception;

    @Select("SELECT * FROM ROLE WHERE ID NOT IN (SELECT ROLEID FROM USERS_ROLE WHERE USERID = #{id})")
    List<Role> findOtherRoles(String id) throws Exception;

    @Insert("INSERT INTO USERS_ROLE VALUES (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
