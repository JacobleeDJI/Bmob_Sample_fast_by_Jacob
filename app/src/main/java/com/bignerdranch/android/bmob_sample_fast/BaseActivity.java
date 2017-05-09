package com.bignerdranch.android.bmob_sample_fast;

/**
 * Created by jacob on 2017/5/6.
 */

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import cn.bmob.v3.Bmob;

public class BaseActivity extends Activity{

    private String Bomb_AppId = "a209c3ad79860d7a95a3373363ed80eb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化 Bmob SDK
        //使用时第二个参数换成自己的ID
        Bmob.initialize(this, Bomb_AppId);
    }

    Toast mToast;

    public void ShowToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }

            mToast.show();
        }
    }
}
