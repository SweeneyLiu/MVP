package com.lsw.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lsw.mvp.presenter.ILoginPresenter;
import com.lsw.mvp.presenter.ILoginPresenterCompl;
import com.lsw.mvp.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{

    private EditText et_name;
    private EditText et_password;
    ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("登陆");
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.bt_clear).setOnClickListener(this);
        et_name = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        iLoginPresenter = new ILoginPresenterCompl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.bt_clear:
                iLoginPresenter.clear();
                break;
            case R.id.bt_login:
                iLoginPresenter.doLogin(et_name.getText().toString(),et_password.getText().toString());
                break;
            default:
        }
    }

    @Override
    public void onClearText() {
        et_name.setText("");
        et_password.setText("");
    }

    @Override
    public void onLoginReuslt(Boolean res, int code) {
        switch (code){
            case 0:
                break;
            case 1:
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                break;
            case -1:
                Toast.makeText(this,"用户名错误",Toast.LENGTH_SHORT).show();
                break;
            case -2:
                Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
