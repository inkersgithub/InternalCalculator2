package in.inkers.internalcalculator;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalicutActivity extends AppCompatActivity {

    int se1 = 0, se2 = 0, as1 = 0, as2 = 0, att = 0, atm = 0, blankcount = 0,asreq,sereq;
    float internal = 0, dec = 0;
    boolean blanks1 = false, blanks2 = false, blanka1 = false, blanka2 = false, blankatt = false,overflow=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calicut_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    public void onClickCalculate(View view) {
        EditText set1 = (EditText) findViewById(R.id.s1);
        EditText set2 = (EditText) findViewById(R.id.s2);
        EditText aet1 = (EditText) findViewById(R.id.a1);
        EditText aet2 = (EditText) findViewById(R.id.a2);
        EditText atet = (EditText) findViewById(R.id.at);

        String val = set1.getText().toString();
        if (val.isEmpty()) {
            blanks1 = true;
            blankcount++;
        }
        if (!val.isEmpty() && Integer.parseInt(val) <= 50)
            se1 = Integer.parseInt(val);
        else{
            overflow = true;
            se1 = 0;
        }

        val = set2.getText().toString();
        if (val.isEmpty()) {
            blanks2 = true;
            blankcount++;
        }
        if (!val.isEmpty() && Integer.parseInt(val) <= 50)
            se2 = Integer.parseInt(val);
        else{
            overflow = true;
            se2 = 0;
        }

        val = aet1.getText().toString();
        if (val.isEmpty()) {
            blanka1 = true;
            blankcount++;
        }
        if (!val.isEmpty() && Integer.parseInt(val) <= 45)
            as1 = Integer.parseInt(val);
        else{
            overflow = true;
            as1 = 0;
        }


        val = aet2.getText().toString();
        if (val.isEmpty()) {
            blanka2 = true;
            blankcount++;
        }
        if (!val.isEmpty() && Integer.parseInt(val) <= 45)
            as2 = Integer.parseInt(val);
        else{
            overflow = true;
            as2 = 0;
        }


        val = atet.getText().toString();
        if (val.isEmpty()) {
            blankatt = true;
            blankcount++;
        }
        if (!val.isEmpty() && Integer.parseInt(val) <= 100) {
            att = Integer.parseInt(val);
            if (att >= 90)
                atm = 5;
            else if (att >= 85)
                atm = 4;
            else if (att >= 80)
                atm = 3;
            else if (att >= 75)
                atm = 2;
            else
                atm = 1;
        }
        else{
            overflow = true;
            atm = 0;
        }

        if(overflow)
            Toast.makeText(this,"Enter a valid mark,else it will be considered as zero",Toast.LENGTH_LONG).show();


        internal = (float) (((se1 + se2) / 2) * 0.6 + ((as1 + as2) / 2) * 0.333 + atm);
        dec = (int) ((internal % 1) * 10);
        if (dec >= 5)
            internal += 1;



        AlertDialog.Builder dialog = new AlertDialog.Builder(CalicutActivity.this);
        View dView = getLayoutInflater().inflate(R.layout.activity_dialog, null);
        TextView dtv = (TextView) dView.findViewById(R.id.dtv);
        TextView smtv = (TextView) dView.findViewById(R.id.smtv);
        TextView sa1bal = (TextView) dView.findViewById(R.id.se1baltv);
        TextView sa2bal = (TextView) dView.findViewById(R.id.se2baltv);
        TextView as1bal = (TextView) dView.findViewById(R.id.as1baltv);
        TextView as2bal = (TextView) dView.findViewById(R.id.as2baltv);
        if ((int)internal >= 35) {
            dtv.setText("Your internal mark is " + (int) internal);
            smtv.setText("Congrats :)");
            sa1bal.setText("You have passed!");
            sa2bal.setVisibility(View.GONE);
            as1bal.setVisibility(View.GONE);
            as2bal.setVisibility(View.GONE);
        }
        else if ((int)internal < 35 && blankcount != 0) {
            if (blanks1 && blanks2 && blanka1 && blanka2 && blankatt) {
                dtv.setText("The best distribution of mark is:");
                smtv.setText("►Series 1 - 37 Marks");
                sa1bal.setText("►Assignment 1 - 36 Marks");
                sa2bal.setText("►Series 2 - 37 Marks");
                as1bal.setText("►Assignment 2 - 36 Marks");
                as2bal.setText("With 75% attendance!");
            }
            else if(!blanks1 && blanks2 && blanka1 && blanka2 && blankatt){
                sereq=74-se1;
                if(sereq>50){
                    asreq=(int)((sereq-50)*1.8+72)/2;
                    sereq=50;
                }
                else
                    asreq=36;
                if(asreq<=45&&sereq<=50) {
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText("To be safe,score in:");
                    sa1bal.setText("►Assignment 1 - " + asreq+" Marks");
                    sa2bal.setText("►Series 2 - " + sereq+" Marks");
                    as1bal.setText("►Assignment 2 - " + asreq+" Marks");
                    as2bal.setText("With 75% attendance!");
                }
                else{
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText(":(");
                    sa1bal.setText("Score 100% in everything left");
                    sa2bal.setText("May attendance marks save you :)");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setVisibility(View.GONE);
                }
            }
            else if(blanks1 && blanks2 && !blanka1 && blanka2 && blankatt){
                asreq=72-as1;
                if(asreq>45){
                    sereq=(int)((asreq-45)*0.75+74)/2;
                    asreq=45;
                }
                else
                    sereq=37;
                if(asreq<=45&&sereq<=50) {
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText("To be safe,score in:");
                    sa1bal.setText("►Series 1 - " + sereq+" Marks");
                    sa2bal.setText("►Assignment 2 - " + asreq+" Marks");
                    as1bal.setText("►Series 2 - " + sereq+" Marks");
                    as2bal.setText("With 75% attendance!");
                }
                else{
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText(":(");
                    sa1bal.setText("Score 100% in everything left");
                    sa2bal.setText("May attendance marks save you :)");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setVisibility(View.GONE);
                }

            }
            else if(!blanks1&&blanks2&&!blanka1&&blanka2&&blankatt){
                asreq=72-as1;
                sereq=74-se1;
                if(asreq>45){
                    sereq+=(int)(asreq-45)*0.75;
                    asreq=45;
                }
                if(sereq>50){
                    asreq+=(int)(sereq-50)*1.8;
                    sereq=50;
                }
                if(asreq<=45&&sereq<=50) {
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText("To be safe,score in:");
                    sa1bal.setText("►Series 2 - " + sereq+" Marks");
                    sa2bal.setText("►Assignment 2 - " + asreq+" Marks");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("With 75% attendance!");
                }
                else {
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText(":(");
                    sa1bal.setText("Don't worry");
                    sa2bal.setText("Do your best in University exam!");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setVisibility(View.GONE);
                }

            }
            else if(!blanks1&&!blanka1&&blanks2&&!blanka2&&blankatt){
                Double req=(72-(as1+as2))*0.75;
                sereq=req.intValue()+(74-se1);
                if(sereq<=50){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText("To be safe,score in:");
                    sa1bal.setText("►Series 2 - " + sereq+" Marks");
                    sa2bal.setVisibility(View.GONE);
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("With 75% attendance!");
                }
                else {
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText(":(");
                    sa1bal.setText("Don't worry");
                    sa2bal.setText("Do your best in University exam!");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setVisibility(View.GONE);
                }
            }
            else if(!blanks1&&!blanka1&&!blanks2&&blanka2&&blankatt){
                Double req=(74-(se1+se2))*1.8;
                asreq=req.intValue()+(72-as1);
                if(asreq<=45){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText("To be safe,score in:");
                    sa1bal.setText("►Assignment 2 - " + asreq+" Marks");
                    sa2bal.setVisibility(View.GONE);
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("With 75% attendance!");
                }
                else {
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText(":(");
                    sa1bal.setText("Don't worry");
                    sa2bal.setText("Do your best in University exam!");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setVisibility(View.GONE);
                }
            }
            else if(!blanks1&&!blanka1&&!blanks2&&!blanka2&&blankatt){
                if((int)internal>=33&&(int)internal<35){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setVisibility(View.GONE);
                    sa1bal.setVisibility(View.GONE);
                    sa2bal.setVisibility(View.GONE);
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("75% attendance will be enough!");
                }
                else if((int)internal==32){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setVisibility(View.GONE);
                    sa1bal.setVisibility(View.GONE);
                    sa2bal.setVisibility(View.GONE);
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("Need at least 80% attendance!");
                }
                else if((int)internal==31){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setVisibility(View.GONE);
                    sa1bal.setVisibility(View.GONE);
                    sa2bal.setVisibility(View.GONE);
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("Need at least 85% attendance!");
                }
                else if((int)internal==30){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setVisibility(View.GONE);
                    sa1bal.setVisibility(View.GONE);
                    sa2bal.setVisibility(View.GONE);
                    as1bal.setVisibility(View.GONE);
                    as2bal.setText("Need at least 90% attendance!");
                }
                else if((int)internal<30){
                    dtv.setText("Your current mark is " + (int) internal);
                    smtv.setText(":(");
                    sa1bal.setText("Don't worry");
                    sa2bal.setText("Do your best in University exam!");
                    as1bal.setVisibility(View.GONE);
                    as2bal.setVisibility(View.GONE);
                }
            }
            else if(blanks1 && blanks2 && blanka1 && blanka2 && !blankatt){
                dtv.setText("Your current mark is " + (int) internal);
                smtv.setVisibility(View.GONE);
                sa1bal.setVisibility(View.GONE);
                sa2bal.setVisibility(View.GONE);
                as1bal.setVisibility(View.GONE);
                as2bal.setText("You can't psss with only attendance!");
            }
            else{
                dtv.setText("Enter the marks in order");
                smtv.setVisibility(View.GONE);
                sa1bal.setVisibility(View.GONE);
                sa2bal.setVisibility(View.GONE);
                as1bal.setVisibility(View.GONE);
                as2bal.setText("You can't write exam/assignment 1 before 2");
            }
        }
        else {
            dtv.setText("Your internal mark is " + (int) internal);
            smtv.setText(":(");
            sa1bal.setText("Don't worry");
            sa2bal.setText("Do your best in University exam!");
            as1bal.setVisibility(View.GONE);
            as2bal.setVisibility(View.GONE);
        }
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
        set1.setText("");
        set2.setText("");
        aet1.setText("");
        aet2.setText("");
        atet.setText("");
        internal = 0;
        se1 = 0;
        se2 = 0;
        as1 = 0;
        as2 = 0;
        att = 0;
        atm = 0;
        dec = 0;
        blankcount = 0;
        blanks1 = false;
        blanks2 = false;
        blanka1 = false;
        blanka2 = false;
        blankatt = false;
        overflow=false;

    }
}
