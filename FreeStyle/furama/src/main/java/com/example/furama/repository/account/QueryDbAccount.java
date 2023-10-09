package com.example.furama.repository.account;

public class QueryDbAccount {
    public static final String SELECT_USER_ROLE = "SELECT user_role.user_role_id,user.user_id,user.username,role.role_id,role.name FROM  user_role \n" +
            "JOIN role ON user_role.role_id = role.role_id\n" +
            "JOIN user ON user_role.user_id = user.user_id ";
    public static final String FIND_BY_NAME_USER = "SELECT user_role.user_role_id,user.user_id,user.username,role.role_id,role.name FROM  user_role \n" +
            "JOIN role ON user_role.role_id = role.role_id\n" +
            "JOIN user ON user_role.user_id = user.user_id WHERE user.username LIKE :name  ";
    public static final String GET_ROLE_BY_USER = "SELECT  app_role.name FROM user_role JOIN app_role ON user_role.role_id = app_role.role_id\n" +
            "JOIN app_user ON user_role.user_id = app_user.user_id WHERE app_user.user_id = :id";
    public static final String SELECT_ACCOUNT_BY_USERNAME = "SELECT * FROM app_user WHERE app_user.username = :name";
}