package com.telecom.tartantimesheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SchedulePlan extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduleplan);
        
        Button cont = (Button) findViewById(R.id.btnContinue);
        cont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SchedulePlan2.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
	}
}
