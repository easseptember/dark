package eass.com.dark;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Eass_September on 2016/10/24.
 */

public class Apps extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apps);

    }

    public void showSome(View v){
        Toast.makeText(this, "apps", Toast.LENGTH_SHORT).show();
    }
}
