package com.dafengsu.ssm.service;

import com.dafengsu.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
public interface UserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;
}
