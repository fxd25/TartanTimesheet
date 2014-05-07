package com.telecom.tartantimesheet;

import com.telecom.tartantimesheet.R;
import com.telecom.tartantimesheet.ChooseSelection;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity {
	/** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	final Login l = this;
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        
        TextView txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtUserName.setTextColor(Color.WHITE);
        
        TextView txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtPassword.setTextColor(Color.WHITE);
        
        TextView txtInputUser = (TextView) findViewById(R.id.txtInputUser);
        txtInputUser.setTextColor(Color.BLACK);
        txtInputUser.setBackgroundColor(Color.WHITE);
        
        TextView txtInputPassword = (TextView) findViewById(R.id.txtInputPassword);
        txtInputPassword.setTextColor(Color.BLACK);
        txtInputPassword.setBackgroundColor(Color.WHITE);
        
        Button next = (Button) findViewById(R.id.btnSubmit);
        next.setTextColor(Color.WHITE);
        next.setBackgroundColor(Color.DKGRAY);
        next.setOnClickListener(new View.OnClickListener() {
        	
            public void onClick(View view) {
            	try {
					LoginDBLayer db = new LoginDBLayer();
					String userID = ((TextView)findViewById(R.id.txtInputUser)).getText().toString();
					String password = ((TextView)findViewById(R.id.txtInputPassword)).getText().toString();
					System.out.println(userID);
					System.out.println("password in login.java-->" +password);
					db.checkLogin(userID, password, l, view);
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

        });
    }
    
    public void loginReady(String input, View view){
    	TextView txtStatus = (TextView) findViewById(R.id.txtStatus);
    	
    	int studentID = Integer.parseInt(input);
    	if(studentID != -1){
    		Intent myIntent = new Intent(view.getContext(), ChooseSelection.class);
    		myIntent.putExtra("studentID", "studentID");
            startActivityForResult(myIntent, 0);
    	}
    	else{
    		txtStatus.setVisibility(View.VISIBLE);
    		txtStatus.setBackgroundColor(Color.WHITE);
    		txtStatus.setText("Invalid Login");
    	}
    }

}
