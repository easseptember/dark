package eass.com.dark;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取
        final EditText myPhone      =  (EditText)   findViewById(R.id.phone);
        final EditText password     =  (EditText)   findViewById(R.id.password);
        Button   mySubmit     =  (Button)     findViewById(R.id.mysubmit);

        /**
         * ============================================================================
         * 日志级别
         * ============================================================================
         */
        Log.i("main", "info");
        Log.e("main", "error");
        Log.d("main", "debug");
        /**
         * ============================================================================
         * 读取文件信息
         * ============================================================================
         */
        Map<?, ?> map = Utils.getInfo(MainActivity.this);
        myPhone.setText(map.get("val0").toString());
        password.setText(map.get("val1").toString());



/**
 * ============================================================================
 * 监听器
 * ============================================================================
 */
        mySubmit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                String phoneNumber  = myPhone.getText().toString().trim();
                String myPassword     = password.getText().toString().trim();

                //if("".equals(phoneNumber) || "".equals(myPassword)){  //判断空  方法1
                if(TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(myPassword)){//判断空  方法2
                    Toast.makeText(MainActivity.this, "username or password can't be empty!",Toast.LENGTH_LONG).show();//tips
                }else if("admin".equals(phoneNumber) && "123456".equals(myPassword)){
                    //*拨打电话*//
                    /* 加入权限依然不好用
                    //加意图
                    Intent intent = new Intent();
                    //设置动作
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+phoneNumber));
                    //开启意图
                    startActivity(intent);
                    */
                    CheckBox checkSaveInfo = (CheckBox) findViewById(R.id.checkSaveInfo);
                    if(checkSaveInfo.isChecked()){
                        boolean result = Utils.saveInfos(MainActivity.this, phoneNumber, myPassword);
                        if(result){
                            Intent intent2 = new Intent();
                            intent2.setClass(MainActivity.this, My.class);//方法2  跳转
                            startActivity(intent2);
                            System.out.println("it's click" + phoneNumber + myPassword);
                        }else{
                            Toast.makeText(MainActivity.this, "save failed!",Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(MainActivity.this, "not checked!",Toast.LENGTH_SHORT).show();
                    }

                    /*

                    */

                }

                else {

                    Toast.makeText(MainActivity.this, "Error username or password!",Toast.LENGTH_LONG).show();//tips
                }
            }
        });


    }
}


