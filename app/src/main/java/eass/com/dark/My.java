package eass.com.dark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Toast.makeText(My.this, "goMyApps!",Toast.LENGTH_LONG).show();//tips
    }
}




