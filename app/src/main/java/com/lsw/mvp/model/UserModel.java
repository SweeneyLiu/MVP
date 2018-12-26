package com.lsw.mvp.model;

/**
 * Created by sweeneyliu on 2018/12/26.
 */
public class UserModel implements IUser{

    private String name;
    private String passwd;

    public UserModel(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return passwd;
    }

    @Override
    public int checkUserValidity() {

        //这里其实就是对登陆进行判断。其实就是对数据进行处理判断，一般我们写在Activity里面。写在这里不久又给Activity减负了嘛。
        if (!name.equals("admin")) {
            //用户名错误
            return -1;
        }
        if (!passwd.equals("123456")) {
            //密码错误
            return -2;
        }
        if (name.equals("admin") && passwd.equals("123456")) {
            //登陆正确
            return 1;
        }
        return 0;
    }
}
