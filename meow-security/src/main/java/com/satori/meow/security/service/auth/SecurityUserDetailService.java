package com.satori.meow.security.service.auth;

import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 获取用户信息
 * @author YanFuYou
 * @date 17/01/24 下午 09:03
 */

@Component
public class SecurityUserDetailService implements UserDetailsService {

    @Resource
    private MockUserInfoDB mockUserInfoDB;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MockUserInfoDB.UserInfo user = mockUserInfoDB.findUserByName(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("USER DOES NOT EXIST!");
        }
        return new User(
                user.getUserName(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
