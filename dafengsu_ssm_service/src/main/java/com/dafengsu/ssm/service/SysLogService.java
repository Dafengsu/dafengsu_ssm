package com.dafengsu.ssm.service;

import com.dafengsu.ssm.domain.SysLog;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/3
 */
public interface SysLogService {
    List<SysLog> findAll() throws Exception;

    void save(SysLog sysLog) throws Exception;
}
