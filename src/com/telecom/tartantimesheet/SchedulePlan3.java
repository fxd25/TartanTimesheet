package com.telecom.tartantimesheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SchedulePlan3 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduleplan3);
        
        Button displaySelection = (Button) findViewById(R.id.btnDisplaySelection);
        displaySelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DisplaySelection.class);
                startActivityForResult(myIntent, 0);
            }

        });

	}
	
	
}
