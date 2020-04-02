package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
public interface RoleDao {
    @Select("SELECT * FROM ROLE WHERE ID IN (SELECT ROLEID FROM USERS_ROLE WHERE USERID = #{userId})")
    List<Role> findRolesByUserId (String userId) throws Exception;
}
