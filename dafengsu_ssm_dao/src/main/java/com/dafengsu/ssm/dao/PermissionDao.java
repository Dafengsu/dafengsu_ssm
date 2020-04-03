package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
public interface PermissionDao {
    @Select("SELECT * FROM PERMISSION WHERE ID IN " +
            "(SELECT PERMISSIONID FROM ROLE_PERMISSION WHERE ROLEID = #{roleId})")
    List<Permission> findByRoleId(String roleId);

    @Select("SELECT * FROM PERMISSION")
    List<Permission> findAll() throws Exception;

    @Insert("INSERT INTO PERMISSION(PERMISSIONNAME, URL)" +
            " VALUES (#{permissionName},#{url}) ")
    void save(Permission permission) throws Exception;

    @Select("SELECT * FROM PERMISSION WHERE ID = #{id}")
    Permission findById(String id) throws Exception;

    @Delete("DELETE FROM ROLE_PERMISSION WHERE PERMISSIONID = #{id}")
    void deleteFromRole_PermissionByPermissionId(String id) throws Exception;

    @Delete("DELETE FROM PERMISSION WHERE ID = #{id}")
    void deleteById(String id) throws Exception;
}
