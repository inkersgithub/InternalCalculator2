package in.inkers.internalcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zade on 21/2/17.
 */

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
    }
    public void onGoClick(View view) {
            Intent intent=new Intent(this,CalicutActivity.class);
            startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        AlertDialog.Builder dialog = new AlertDialog.Builder(IntroActivity.this);
        View dView = getLayoutInflater().inflate(R.layout.activity_dialog, null);
        TextView inkers = (TextView) dView.findViewById(R.id.textView);
        TextView dtv = (TextView) dView.findViewById(R.id.dtv);
        TextView smtv = (TextView) dView.findViewById(R.id.smtv);
        TextView sa1bal = (TextView) dView.findViewById(R.id.se1baltv);
        TextView sa2bal = (TextView) dView.findViewById(R.id.se2baltv);
        TextView as1bal = (TextView) dView.findViewById(R.id.as1baltv);
        TextView as2bal = (TextView) dView.findViewById(R.id.as2baltv);
        dtv.setText("Developed by:");
        smtv.setText("inkers Inc.");
        sa1bal.setText("www.inkers.in");
        sa2bal.setVisibility(View.GONE);
        as1bal.setVisibility(View.GONE);
        as2bal.setVisibility(View.GONE);
        inkers.setVisibility(View.GONE);
        Button btok = (Button) dView.findViewById(R.id.bt2);
        dialog.setView(dView);
        final AlertDialog adialog = dialog.create();
        adialog.show();
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adialog.dismiss();
            }
        });
        return true;
    }
}

