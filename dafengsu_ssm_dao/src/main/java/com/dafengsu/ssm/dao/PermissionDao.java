package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Permission;
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
}
