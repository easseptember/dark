package eass.com.dark;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * Created by Eass_September on 2016/11/1.
 */
public class HttpUrl extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_url);
    }
    public void showHttpUrlInfo(View v){
        try{
            EditText uri = (EditText) findViewById(R.id.http_url_uri);
            String uriVal = uri.getText().toString().trim();
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
            URL url = new URL(uriVal);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                InputStream inputStream = conn.getInputStream();
                String s = Utils.readStream(inputStream);
                TextView view = (TextView) findViewById(R.id.http_url_view);
                view.setText(s);
            }else{

            }




        }catch (Exception e){

            e.printStackTrace();
        }


    }

}
