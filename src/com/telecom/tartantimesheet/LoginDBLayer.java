package com.telecom.tartantimesheet;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.telecom.tartantimesheet.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class LoginDBLayer {
	
	public LoginDBLayer() throws Exception{
	}
	
	Login l = null;
	View view;
	
	
	public void checkLogin(String user, String password, Login l, View view) {
		this.l = l;
		this.view = view;
		new AsyncLoginCheck(view.getContext()).execute(user,password);
	}
	
	private class AsyncLoginCheck extends AsyncTask<String,Void,String>{
		
	    ProgressDialog progressDialog ;
	    Context targetCtx ;
		
		public AsyncLoginCheck(Context context){
			//this.targetCtx = context;
			//progressDialog = new ProgressDialog ( targetCtx ) ;
	        //progressDialog.setCancelable ( false ) ;
	        //progressDialog.setIndeterminate ( true ) ;
		}
		
		protected void onPreExecute() {
			//ProgressDialog.show(targetCtx, "Loading", "Please wait ...");
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return Integer.toString(checkLogin(params[0], params[1])) ;
		}
		
		protected void onPostExecute(String studentID){
			//if(progressDialog != null && progressDialog.isShowing()){
	            //progressDialog.dismiss ( ) ;
	        //}
			l.loginReady(studentID, view);
		}
		
		private int checkLogin(String userId, String password) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://appdb.csecpuvkxxf0.us-east-1.rds.amazonaws.com:3306/AppDB","cmu","johnheinz");
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT Student_ID FROM Student "
													+"WHERE Andrew_ID = ?  AND Password = ?");
				ps.setString(1, userId);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					studentID = rs.getInt(1);
					//studentID = 1;
	            } else {
	            	studentID = -1;
	                System.out.println("Could not read a record");
	                //throw new RecordNotFoundException();
	            }
			} catch (ClassNotFoundException e) {
				studentID = -1;
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				studentID = -1;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return studentID;
		}

		
	}
	
	
	

	
	private int studentID = -1;
	private String andrewID;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getAndrewID() {
		return andrewID;
	}
	public void setAndrewID(String andrewID) {
		this.andrewID = andrewID;
	}

	}
