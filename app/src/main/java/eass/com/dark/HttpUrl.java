package eass.com.dark;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.callumtaylor.asynchttp.AsyncHttpClient;

import java.io.EOFException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

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
                int id = v.getId();
                switch (id){
                    case R.id.http_url_urisub:
                        String s = Utils.readStream(inputStream);
                        TextView view = (TextView) findViewById(R.id.http_url_view);
                        view.setText(s);
                        break;
                    case R.id.http_url_imgsub:
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        ImageView viewById = (ImageView) findViewById(R.id.http_url_img);
                        viewById.setImageBitmap(bitmap);
                        break;


                    default:
                        break;
                }





            }else{

            }




        }catch (Exception e){

            e.printStackTrace();
        }


    }


    public  void submitHttpClient(View v){
        try{
            //AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
            EditText username = (EditText) findViewById(R.id.http_url_username);
            EditText password = (EditText) findViewById(R.id.http_url_password);
            String userName = username.getText().toString().trim();
            String passWord = password.getText().toString().trim();

            String uri = "http://192.168.1.118:8888/jspServletBbs/android?username="+URLEncoder.encode(userName, "utf-8")+"&password="+URLEncoder.encode(userName, "utf-8")+"";

            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) {
                InputStream inputStream = conn.getInputStream();
                String s = Utils.readStream(inputStream);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }




}
