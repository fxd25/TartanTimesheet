package com.telecom.tartantimesheet;

import com.telecom.tartantimesheet.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ChooseSelection extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseselection);
        
        Button manualEntry = (Button) findViewById(R.id.btnManualEntry);
        manualEntry.setTextColor(Color.WHITE);
        manualEntry.setBackgroundColor(Color.DKGRAY);
        
        Button schedule = (Button) findViewById(R.id.btnSchedulePlan);
        schedule.setTextColor(Color.WHITE);
        schedule.setBackgroundColor(Color.DKGRAY);
        
        schedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SchedulePlan.class);
                myIntent.putExtra("studentID", getIntent().getExtras().getString("studentID"));
                startActivityForResult(myIntent, 0);
            }

        });
	}
}