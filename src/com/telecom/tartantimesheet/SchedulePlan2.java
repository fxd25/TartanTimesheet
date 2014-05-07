package com.telecom.tartantimesheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SchedulePlan2 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduleplan2);
        
        Button cont2 = (Button) findViewById(R.id.btnContinue2);
        cont2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SchedulePlan3.class);
                startActivityForResult(myIntent, 0);
            }

        });

	}
	
	
}
