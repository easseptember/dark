package eass.com.dark;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
 * 监听器
 * ============================================================================
 */
        mySubmit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                String phoneNumber  = myPhone.getText().toString().trim();
                String myPassword     = password.getText().toString().trim();

                if("".equals(phoneNumber) || "".equals(myPassword)){
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

                    Intent intent2 = new Intent();
                    intent2.setClass(MainActivity.this, My.class);//方法2
                    startActivity(intent2);
                    System.out.println("it's click" + phoneNumber + myPassword);

                }

                else {

                    Toast.makeText(MainActivity.this, "Error username or password!",Toast.LENGTH_LONG).show();//tips
                }
            }
        });


    }
}


