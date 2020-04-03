package com.dafengsu.ssm.service;

import com.dafengsu.ssm.domain.Permission;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/3
 */
public interface PermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
