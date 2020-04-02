package com.dafengsu.ssm.service.impl;

import com.dafengsu.ssm.dao.UserDao;
import com.dafengsu.ssm.domain.Role;
import com.dafengsu.ssm.domain.UserInfo;
import com.dafengsu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {

            userInfo = userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象
        return new User(Objects.requireNonNull(userInfo).getUsername(), "{noop}" + userInfo.getPassword(),
                userInfo.getStatus() != 0, true, true, true, getAuthority(userInfo.getRoles()));
    }

    private List<? extends GrantedAuthority> getAuthority(List<Role> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

}
