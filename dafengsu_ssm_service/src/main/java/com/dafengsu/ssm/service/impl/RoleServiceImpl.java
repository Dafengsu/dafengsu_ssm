package com.dafengsu.ssm.service.impl;

import com.dafengsu.ssm.dao.RoleDao;
import com.dafengsu.ssm.domain.Permission;
import com.dafengsu.ssm.domain.Role;
import com.dafengsu.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void deleteById(String id) throws Exception {
        roleDao.deleteFromUser_RoleByRoleId(id);
        roleDao.deleteFromRole_PermissionByRoleId(id);
        roleDao.deleteById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(String id) throws Exception {
        return roleDao.findOtherPermissions(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }

}
