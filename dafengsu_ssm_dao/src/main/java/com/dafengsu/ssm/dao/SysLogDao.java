package com.dafengsu.ssm.dao;

import com.dafengsu.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/3
 */
public interface SysLogDao {
    @Select("SELECT * FROM SYSLOG")
    List<SysLog> findAll() throws Exception;

    @Insert("INSERT INTO SYSLOG(VISITTIME, USERNAME, IP, URL, EXECUTIONTIME, METHOD)" +
            " VALUES (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;
}
