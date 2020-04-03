package com.dafengsu.ssm.service.impl;

import com.dafengsu.ssm.dao.PermissionDao;
import com.dafengsu.ssm.domain.Permission;
import com.dafengsu.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/3
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }

    @Override
    public void deleteById(String id) throws Exception {
        permissionDao.deleteFromRole_PermissionByPermissionId(id);
        permissionDao.deleteById(id);
    }
}
