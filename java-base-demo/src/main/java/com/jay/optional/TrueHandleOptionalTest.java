package com.jay.optional;

import java.util.Optional;

/**
 * @author xiang.wei
 * @date 2020/2/18 4:03 PM
 */
public class TrueHandleOptionalTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        getUserName(user);
        getUserName1(user);
        getUserName2(user);
    }

    /**
     //错误的示范1
     * @param user
     * @return
     */
    public static String getUserName(User user) {
        if (user == null) {
            return "参数为空";
        }
        return user.getName();
    }

    /**
     * 错误的示范2
     * @param user
     * @return
     */
    public static String getUserName1(User user) {
        Optional<User> user1 = Optional.ofNullable(user);
        if (!user1.isPresent()) {
            return "参数为空";
        }
        return user1.get().getName();
    }

    /**
     * 正确的示范
     * @param user
     * @return
     */
    public static String getUserName2(User user) {
        return Optional.ofNullable(user)
                .map(user1 -> user1.getName())
                .orElse("参数为空");
    }
}
