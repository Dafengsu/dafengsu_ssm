package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Permission;
import com.dafengsu.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
public interface RoleDao {
    @Select("SELECT * FROM ROLE WHERE ID IN " +
            "(SELECT ROLEID FROM USERS_ROLE WHERE USERID = #{userId})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id", property = "permissions",
                    many = @Many(select ="com.dafengsu.ssm.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRolesByUserId (String userId) throws Exception;

    @Select("SELECT * FROM ROLE")
    List<Role> findAll() throws Exception;

    @Insert("INSERT INTO  ROLE(ROLENAME, ROLEDESC) " +
            "VALUES (#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("SELECT * FROM ROLE WHERE ID = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id", property = "permissions",
                    many = @Many(select ="com.dafengsu.ssm.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id) throws Exception;

    @Delete("DELETE FROM ROLE WHERE ID = #{id}")
    void deleteById(String id) throws Exception;

    @Delete("DELETE FROM USERS_ROLE WHERE ROLEID = #{id}")
    void deleteFromUser_RoleByRoleId(String id) throws Exception;

    @Delete("DELETE FROM ROLE_PERMISSION WHERE ROLEID = #{id}")
    void deleteFromRole_PermissionByRoleId(String id) throws Exception;

    @Select("SELECT * FROM PERMISSION WHERE ID NOT IN " +
            "(SELECT PERMISSIONID FROM ROLE_PERMISSION WHERE ROLEID = #{id})")
    List<Permission> findOtherPermissions(String id) throws Exception;

    @Insert("INSERT INTO ROLE_PERMISSION VALUES (#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}
