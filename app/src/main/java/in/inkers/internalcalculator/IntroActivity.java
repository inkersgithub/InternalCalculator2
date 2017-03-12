package in.inkers.internalcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

/**
 * Created by zade on 21/2/17.
 */

public class IntroActivity extends AppCompatActivity {

    Spinner spinneruse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
    }
    public void onOkClick(View view) {
        spinneruse = (Spinner) findViewById(R.id.spinner);
        String item = spinneruse.getSelectedItem().toString();
        if (item.equals("B.Tech(Calicut University 2014 scheme)")){
            Intent intent=new Intent(this,CalicutActivity.class);
            startActivity(intent);
        }
        else if(item.equals("B.Tech(KTU)")){
            Intent intent=new Intent(getApplicationContext(),KtuActivity.class);
            startActivity(intent);
        }
        else if(item.equals("MBBS(KUHS)")){
            Intent intent=new Intent(getApplicationContext(),MbbsActivity.class);
            startActivity(intent);
        }
    }
}

