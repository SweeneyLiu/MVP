package com.lsw.mvp.model;

/**
 * Created by sweeneyliu on 2018/12/26.
 */
public interface IUser {
    //拿到账号
    String getName();
    //拿到用户名
    String getPassword();
    //验证登陆
    int checkUserValidity();
}
