package com.satori.meow.security.service.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanFuYou
 * @date 17/01/24 下午 09:04
 */

@Component
public class MockUserInfoDB {
    private static final List<UserInfo> USER_INFO = new ArrayList<>(4);

    static {

        USER_INFO.add(new UserInfo("admin", "123456"));
        USER_INFO.add(new UserInfo("root", "root1"));
        USER_INFO.add(new UserInfo("origin", "12138"));
    }


    public UserInfo findUserByName(String userName) {
        return USER_INFO.stream().filter(user ->user.getUserName().equals(userName)).findFirst().orElse(null);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UserInfo {
        private String userName;
        private String password;
    }

}
