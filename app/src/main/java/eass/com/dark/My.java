package eass.com.dark;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

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


        Intent intent2 = new Intent();
        intent2.setClass(My.this, Apps.class);//方法2  跳转
        startActivity(intent2);


        /**
         * ============================================================================
         * XmlSerializer 生成xml文件
         * ============================================================================
         */
        /*
        //初始化数据
        List<Sms> smsList = new ArrayList<Sms>();

        for(int l=0; l<10; l++){
            Sms sms = new Sms();
            sms.setAdress("1827777000"+l);
            sms.setContent("hello go to"+l);
            sms.setDate("2015-09-0"+l);
            smsList.add(sms);
        }

        try {
            //实例化
            XmlSerializer serializer = Xml.newSerializer();
            File file = new File(Environment.getExternalStorageDirectory().getPath(),"serializer.xml");
            FileOutputStream fos = new FileOutputStream(file);
            serializer.setOutput(fos, "utf-8");
            //xml开头
            serializer.startDocument("utf-8", true);
            //xml 根节点 命名空间
            serializer.startTag(null, "smss");
            for (Sms sms: smsList){
                serializer.startTag(null, "sms");
                    serializer.startTag(null, "adress");
                    serializer.text(sms.getAdress());
                    serializer.endTag(null, "adress");

                    serializer.startTag(null, "content");
                    serializer.text(sms.getContent());
                    serializer.endTag(null, "content");

                    serializer.startTag(null, "date");
                    serializer.text(sms.getDate());
                    serializer.endTag(null, "date");


                serializer.endTag(null, "sms");
            }

            serializer.endTag(null, "smss");
            serializer.endDocument();
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        */





        Toast.makeText(My.this, "xml!",Toast.LENGTH_SHORT).show();//tips
        /**
         * ============================================================================
         * //判断SD 是否可用及大小
         * ============================================================================
         */
        /*
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
        */
        //Toast.makeText(My.this, "goMyApps!",Toast.LENGTH_LONG).show();//tips
    }
}




