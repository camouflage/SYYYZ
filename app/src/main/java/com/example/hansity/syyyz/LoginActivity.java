package com.example.hansity.syyyz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity
{
    MyDatabaseHelper dbHelper;
    SQLiteDatabase t;
    Button register_bn,signin_bn, change_bn;
    ListView listView;
    boolean bt_state = true;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("注册");
        dbHelper = new MyDatabaseHelper(this, "myDb.db3", 1);

        listView = (ListView) findViewById(R.id.show);
        register_bn  = (Button) findViewById(R.id.register);
        register_bn .setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View source)
            {
                EditText username = ((EditText) findViewById(
                        R.id.title));
                EditText password = ((EditText) findViewById(R.id.content));
                String title = username.getText().toString();
                String content = password.getText().toString();

                try
                {
                    if(title.equals("")) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "你的名字呢？", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }else if (content.equals("")) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "你的密码呢？", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    } else if (CheckUserNameExist(title)) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "有人注册了", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    } else {
                        insertData(dbHelper.getReadableDatabase(),title, content);
                        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from news_inf"
                                , null);
                        inflateList(cursor);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "注册成功", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                catch (SQLiteException se)
                {
                    dbHelper.getReadableDatabase().execSQL("create table news_inf(_id integer"
                            + " primary key autoincrement,"
                            + " news_title varchar(50),"
                            + " news_content varchar(255))");
                    insertData(dbHelper.getReadableDatabase(),title, content);
                    Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from news_inf"
                            , null);
                    inflateList(cursor);
                }
                username.setText("");
                password.setText("");
            }
        });
        signin_bn = (Button) findViewById(R.id.sign_in);
        signin_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ((EditText) findViewById(
                        R.id.title)).getText().toString();
                String content = ((EditText) findViewById(R.id.content))
                        .getText().toString();
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from news_inf where news_title = ? and news_content = ?", new String[] {title,content});
                if(cursor.getCount()>0) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "登录成功", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Bundle data = new Bundle();
                    data.putSerializable("data", converCursorToList(cursor));
                    // 创建一个Intent
                    Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                    intent.putExtras(data);
                    // 启动Activity
                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "用户未注册或密码错误", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
        change_bn = (Button) findViewById(R.id.change);
        change_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt_state == true) {
                    register_bn.setVisibility(View.INVISIBLE);
                    signin_bn.setVisibility(View.VISIBLE);
                    change_bn.setText("注册");
                    bt_state = false;
                } else {
                    register_bn.setVisibility(View.VISIBLE);
                    signin_bn.setVisibility(View.INVISIBLE);
                    change_bn.setText("登录");
                    bt_state = true;
                }
            }
        });
    }

    private void insertData(SQLiteDatabase db, String title
            , String content)
    {
        // 执行插入语句
        db.execSQL("insert into news_inf values(null , ? , ?)"
                , new String[] {title, content});
    }
    private void inflateList(Cursor cursor)
    {
        // 填充SimpleCursorAdapter
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                LoginActivity.this,
                R.layout.line, cursor,
                new String[] { "news_title", "news_content" }
                , new int[] {R.id.my_title, R.id.my_content },
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);  // ③
        // 显示数据
        listView.setAdapter(adapter);
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        // 退出程序时关闭SQLiteDatabase
        if (dbHelper.getReadableDatabase() != null && dbHelper.getReadableDatabase().isOpen())
        {
            dbHelper.getReadableDatabase().close();
        }
    }

    private boolean CheckUserNameExist(String username) {
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from news_inf where news_title = ?", new String[] {username});
        if(cursor.getCount()==0) {
            return false;
        } else {
            return true;
        }
    }

    protected ArrayList<Map<String, String>>
    converCursorToList(Cursor cursor)
    {
        ArrayList<Map<String, String>> result =
                new ArrayList<Map<String, String>>();
        // 遍历Cursor结果集
        while (cursor.moveToNext())
        {
            // 将结果集中的数据存入ArrayList中
            Map<String, String> map = new HashMap<>();
            // 取出查询记录中第2列、第3列的值
            map.put("news_title", cursor.getString(1));
            map.put("news_content", cursor.getString(2));
            result.add(map);
        }
        return result;
    }
}
