package com.dafengsu.ssm.service;

import com.dafengsu.ssm.domain.Permission;
import com.dafengsu.ssm.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */

public interface RoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    void deleteById(String id) throws Exception;

    List<Permission> findOtherPermissions(String id) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
