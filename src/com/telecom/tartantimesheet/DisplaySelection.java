package com.telecom.tartantimesheet;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.text.Html;


public class DisplaySelection extends Activity {
	
	final DisplaySelection ds = this;
	public static ArrayList<String> ArrayofName = new ArrayList<String>();
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection);
        
        TextView txtSchedule = (TextView) findViewById(R.id.txtSchedule);
        txtSchedule.setTextColor(Color.WHITE);
        
        String n = "<b>Schedule</b>";
        txtSchedule.setText(Html.fromHtml(n));
        
        //GridView gvSelection = (GridView) findViewById(R.id.gvSelection);
        //gvSelection.setBackgroundColor(Color.WHITE);
        //gvSelection.setVerticalSpacing(1);
        //gvSelection.setHorizontalSpacing(1);
        
        
        DisplaySelectionDB dsDB = new DisplaySelectionDB();
        Context c = getApplicationContext();
        String studentID = "1";
        dsDB.displayGrid(studentID, ds, c);
	}
	
	public void displayGrid(List<OriginalSchedule> o, Context c){
		
		TextView txtGridStatus = (TextView) findViewById(R.id.txtGridStatus);
		
		if(!o.isEmpty()){
			
			txtGridStatus.setVisibility(View.INVISIBLE);
			GridView gv = (GridView) findViewById(R.id.gvSelection);
			
			List<String> data = new ArrayList<String>();
			
			for(int i = 0 ; i < o.size() ; i ++){
				data.add(o.get(i).getDay() + "    " + o.get(i).getStartTime() + " " + o.get(i).getEndTime());
			}
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(c, R.layout.list_item, data);
			gv.setAdapter(adapter);
		}
		else{
			txtGridStatus.setVisibility(View.VISIBLE);
			txtGridStatus.setText("No records to show");
		}
	}
	
}
