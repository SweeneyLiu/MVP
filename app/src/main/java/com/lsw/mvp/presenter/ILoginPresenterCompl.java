package com.lsw.mvp.presenter;

import com.lsw.mvp.model.IUser;
import com.lsw.mvp.model.UserModel;
import com.lsw.mvp.view.ILoginView;

/**
 * Created by sweeneyliu on 2018/12/26.
 */
public class ILoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser iUser;

    /***
     *
     * @param iLoginView Activity需要实现iLoginView接口并将这个接口通过构造方法传给ILoginPresenterCompl
     */
    public ILoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }


    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {

        //执行判断逻辑
        iUser = new UserModel(name, passwd);
        boolean res = false;
        int code = iUser.checkUserValidity();
        if (code == 1) {
            res = true;
        }
        iLoginView.onLoginReuslt(res, code);
    }

}
