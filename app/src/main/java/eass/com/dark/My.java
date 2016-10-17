package eass.com.dark;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Administrator on 2016/10/7.
 */

public class My extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);




        Button myApps  = (Button) findViewById(R.id.appsButton);
        String[] loginTeplates = {"mobilePhone", "PC"};
        for(int i=0; i<loginTeplates.length;i++){
            System.out.println(loginTeplates[i]);
        }
/*
        myApps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    Toast.makeText(My.this, "myApps!",Toast.LENGTH_LONG).show();//tips

            }

        });
        */
    }
    public void doApps(View v){


        
    //判断SD 是否可用及大小
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(My.this, "sdcard run success!",Toast.LENGTH_SHORT).show();//tips
            File file = Environment.getExternalStorageDirectory();
            long totalSpace = file.getTotalSpace(); //获取SD卡总大小
            long us         = file.getUsableSpace();//获取SD卡可用大小

            //格式化大小  5M
            String fmTotalSize  = Formatter.formatFileSize(My.this,totalSpace);
            String fmUsSize     = Formatter.formatFileSize(My.this,us);
            Toast.makeText(My.this, "总大小"+fmTotalSize,Toast.LENGTH_LONG).show();//tips
            Toast.makeText(My.this, "可用大小"+fmUsSize,Toast.LENGTH_LONG).show();//tips

        }else {
            Toast.makeText(My.this, "sdcard run failed!",Toast.LENGTH_SHORT).show();//tips
        }

        //Toast.makeText(My.this, "goMyApps!",Toast.LENGTH_LONG).show();//tips
    }
}




