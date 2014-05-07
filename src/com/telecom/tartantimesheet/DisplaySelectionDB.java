package com.telecom.tartantimesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.app.ProgressDialog;

public class DisplaySelectionDB {
	
	DisplaySelection ds = null;
	Context c;
	//ProgressDialog progressDialog ;
	//Context targetCtx ;
	
	
	public void displayGrid(String studentID, DisplaySelection ds, Context c){
		this.ds = ds;
		this.c = c;
		new AsyncDisplayGrid(c).execute(studentID);
	}
	
	private class AsyncDisplayGrid extends AsyncTask<String,Void,List<OriginalSchedule>>{
		
		//ProgressDialog progressDialog ;
	    //Context targetCtx ;

		public AsyncDisplayGrid(Context c) {
			//this.targetCtx = c;
			//progressDialog = new ProgressDialog ( c ) ;
	        //progressDialog.setCancelable ( false ) ;
	        //progressDialog.setIndeterminate ( true ) ;
			// TODO Auto-generated constructor stub
		}
		
		protected void onPreExecute() {
			//ProgressDialog.show(targetCtx, "Loading", "Please wait ...");
			//ProgressDialog.show(c, "Loading", "Please wait ...");
		}

		@Override
		protected List<OriginalSchedule> doInBackground(String... params) {
			// TODO Auto-generated method stub
			return getSelection(params[0]);
		}
		
		protected void onPostExecute(List<OriginalSchedule> o){
/*			if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss ( ) ;
			}*/
			ds.displayGrid(o, c);
		}
		
		private List<OriginalSchedule> getSelection(String studentID){
			System.out.println("studentID-->" +studentID);
			List<OriginalSchedule>  ol = new ArrayList<OriginalSchedule>();
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://appdb.csecpuvkxxf0.us-east-1.rds.amazonaws.com:3306/AppDB","cmu","johnheinz");
				PreparedStatement ps = (PreparedStatement) con.prepareCall("SELECT Day, StartTime, EndTime FROM Original_Schedule " +
											"WHERE Student_ID = ?");
				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();
				System.out.println("rs-->" +rs);
				while(rs.next()){
					OriginalSchedule o = new OriginalSchedule();
					o.setDay(rs.getString(1));
					o.setStartTime(rs.getTime(2));
					o.setEndTime(rs.getTime(3));
					ol.add(o);
					
					//rs.next();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//for (int i = 0; i < ol.size() ; i++ ){
			//	System.out.println(ol.get(i).getDay());
			//}
			return ol;
		}
	}
}
