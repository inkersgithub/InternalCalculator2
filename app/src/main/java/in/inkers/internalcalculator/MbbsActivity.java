package in.inkers.internalcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zade on 21/2/17.
 */

public class MbbsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mbbs_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
