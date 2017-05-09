package com.bignerdranch.android.bmob_sample_fast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DeleteBatchListener;
import cn.bmob.*;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button btn_add, btn_delete, btn_update, btn_query;

    private String objectId = "";
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化view
        initView();
        initListener();
    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_query = (Button) findViewById(R.id.btn_query);
    }

    private void initListener() {
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_add) {
            createPerson();
        } else if (v == btn_delete) {
            deletePersonByObjectId();
        } else if (v == btn_update) {
            updatePersonByObjectId();
        } else if (v == btn_query) {
            queryPersonByObjectId();
        }
    }

    /**
     * 创建一条Person数据 CreatePersonData
     */
    private void createPerson() {
        final Person p2 = new Person();
        p2.setName("Jacob");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    ShowToast("添加数据成功，返回ObjectId为：" + objectId);
                } else {
                    ShowToast("创建数据失败：" +  e.getMessage());
                }
            }
        });
    }

    /**
     * 删除一条Person数据
     */
    private void deletePersonByObjectId() {
        final Person p2 = new Person();
        p2.setObjectId("27e927af2d");
        p2.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    ShowToast("删除成功:" + p2.getUpdatedAt());
                }else {
                    ShowToast("删除失败:" + e.getMessage());
                }
            }
        });
    }

    /**
     * 修改一行数据
     */
    private void updatePersonByObjectId() {
        //更新Person表里面的id为20162230的数据，address内容更新为"北京朝阳群众"
        final Person p2 = new Person();
        p2.setAddress("北京朝阳");
        p2.update("27e927af2d", new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    ShowToast("更新成功:"+p2.getUpdatedAt());
                } else {
                    ShowToast("更新失败: " + e.getMessage());
                }
            }
        });
    }

    /**
     * 获取一行数据
     */
    private void queryPersonByObjectId() {
        //查找Person表里面id为20162230的数据
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject("27e927af2d", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if (e==null){
                    ShowToast("查询成功");
                }else {
                    ShowToast("查询失败");
                }
            }
        });
    }


}
