package com.example.findrandomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonstart, buttonplus, buttonminus, buttoncheck, buttonrestart,buttonrestart1;
    private TextView TVcurrentnum, TVshowmessage, tvcounter,tvfoundnum;
    private String TAG = "gilog",currentnum,counter;
    private Controllerguessnum myC;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hi");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonstart =(Button) findViewById(R.id.buttonstart);
        buttonplus = (Button)findViewById(R.id.buttonplus);
        buttonminus =(Button) findViewById(R.id.buttonminus);
        buttoncheck = (Button)findViewById(R.id.buttoncheck);
        buttonrestart = (Button)findViewById(R.id.buttonrestart);
        buttonrestart1 = (Button)findViewById(R.id.buttonrestart1);

        findViewById(R.id.page);
        findViewById(R.id.grats);
        findViewById(R.id.buttonrestart1);


        buttonstart.setOnClickListener(this);
        buttonrestart.setOnClickListener(this);
        buttoncheck.setOnClickListener(this);
        buttonplus.setOnClickListener(this);
        buttonminus.setOnClickListener(this);
        buttonrestart1.setOnClickListener(this);

        Log.d(TAG, "onCreate: set clickers worked");


    }

    public void startGame() {
        TextView  TVshowmessage= findViewById(R.id.TVshowmessage);

        myC = new Controllerguessnum();
            TVcurrentnum.setText(String.valueOf((int)(myC.ccurrentnum()) + 0));
            Log.d(TAG, "startGame: random number is " + myC.crandom());
            TVshowmessage.setText("Find the random number");



    }
    public void showmessage(){
        TextView  TVshowmessage= findViewById(R.id.TVshowmessage);

        Log.d(TAG, "onClick: button check was pressed");


        if (myC.ccheck() == "smaller"){
            Log.d(TAG, "onClick: check is ? "+ myC.ccheck() +" numbers: "+myC.ccurrentnum()+ "<"+ myC.crandom());
            TVshowmessage.setText("number is smaller than random number" + 0);
        }

        else
            if (myC.ccheck() == "equal"){
                Log.d(TAG, "onClick: check is ? "+ myC.ccheck() + "="+ myC.crandom());
                TVshowmessage.setText("congrats you found the number, "+String.valueOf((int)(myC.ccounter()))+" tries,"+ " press restart to play again" );
            }
        else {
            if(myC.ccheck() == "bigger") {
                Log.d(TAG, "onClick: check is ? "+ myC.ccheck() + ">"+ myC.crandom());
                TVshowmessage.setText("number you chose is bigger than random number" + 0);
            }
        }

    }
    public void changepage() {
        TextView tvfoundnum= findViewById(R.id.tvfound);
        RelativeLayout grats = findViewById(R.id.grats);
        RelativeLayout page = findViewById(R.id.page);
        if (myC.ccheck() == "equal") {
            page.setVisibility(View.GONE);
            grats.setVisibility(View.VISIBLE);
            tvfoundnum.setText("congrats you found the number, "+String.valueOf((int)(myC.ccounter()))+" tries, the number is "+ String.valueOf((int)(myC.crandom()))+ " press restart to play again" );

        }
        else {
            grats.setVisibility(View.GONE);
            page.setVisibility(View.VISIBLE);

        }
    }
    public void changeback() {
        RelativeLayout grats = findViewById(R.id.grats);
        RelativeLayout page = findViewById(R.id.page);
        grats.setVisibility(View.GONE);
        page.setVisibility(View.VISIBLE);

    }
    @Override
    public void onClick(View v) {
        buttonstart =(Button) findViewById(R.id.buttonstart);
        buttonplus = (Button)findViewById(R.id.buttonplus);
        buttonminus =(Button) findViewById(R.id.buttonminus);
        buttoncheck = (Button)findViewById(R.id.buttoncheck);
        buttonrestart= (Button)findViewById(R.id.buttonrestart);
        TVcurrentnum= findViewById(R.id.TVcurrentnum);
        tvcounter= findViewById(R.id.tvcounter);
        findViewById(R.id.buttonrestart1);


        if (v.getId() == R.id.buttonstart || v.getId() == R.id.buttonrestart) {
           startGame();
        }
        if (v.getId() == R.id.buttonrestart1){
            findViewById(R.id.page).setVisibility(View.VISIBLE);
            findViewById(R.id.grats).setVisibility(View.GONE);
            Log.d(TAG, "onClick: restart was pressed on second page");
            startGame();
            changeback();
        }
        //button check
        if (v.getId() == R.id.buttoncheck) {
            showmessage();
            myC.ccntplus();
            tvcounter.setText(String.valueOf((int)(myC.ccounter())+ 0));
            Log.d(TAG, "onClick: counter returned"+ tvcounter.getText());
            changepage();
        }
        if (v.getId() == R.id.buttonplus) {
            int d = Log.d(TAG, "onClick: button plus was pressed");
            myC.cplus();
            TVcurrentnum.setText(String.valueOf((int)(myC.ccurrentnum()) + 0));

        } else if (v.getId() == R.id.buttonminus) {
            Log.d(TAG, "onClick: button minus was pressed");
            myC.cminus();
            TVcurrentnum.setText(String.valueOf((int)(myC.ccurrentnum()) + 0));


        }
    }
}
