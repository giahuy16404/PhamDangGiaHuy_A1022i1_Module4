package com.example.shop.repository.account;

public class QueryDbAccount {
    public static final String SELECT_USER_ROLE = "SELECT user_role.user_role_id,user.user_id,user.username,role.role_id,role.name FROM  user_role \n" +
            "JOIN role ON user_role.role_id = role.role_id\n" +
            "JOIN user ON user_role.user_id = user.user_id ";
    public static final String FIND_BY_NAME_USER = "SELECT user_role.user_role_id,user.user_id,user.username,role.role_id,role.name FROM  user_role \n" +
            "JOIN role ON user_role.role_id = role.role_id\n" +
            "JOIN user ON user_role.user_id = user.user_id WHERE user.username LIKE :name  ";
}