package com.bank.gui;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DataTable extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;

	DataTable(ResultSet res){
		
		
		ResultSetMetaData rsmd;
		try {
			rsmd = res.getMetaData();
			int colcount = rsmd.getColumnCount();
		    Vector columns = new Vector(colcount);
		        for(int i=1; i<=colcount; i++)
		    {
		        columns.add(rsmd.getColumnName(i).toString());
		        System.out.println(rsmd.getColumnName(i));
		    }
		    Vector data = new Vector();
		    Vector row;

		    // Store row data
		    while(res.next())
		    {
		        row = new Vector(colcount);
		        for(int i=1; i<=colcount; i++)
		        {
		            row.add(res.getString(i));
		            System.out.println(res.getString(i));
		        }
		        data.add(row);
		    }
		    table = new JTable(data, columns);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    scrollPane.setViewportView(table);
		    setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e); 
		}
	    
	}
	
		
}		
		
		
		
		
//		String data[][]={ {"101","Amit","670000"},    
//                {"102","Jai","780000"},    
//                {"101","Sachin","700000"}};    
//String column[]={"ID","NAME","SALARY"};  
//
//JTable jt=new JTable(data,column);    
//jt.setBounds(30,40,200,300);          
//JScrollPane sp=new JScrollPane(jt);    
//add(sp);          
//setSize(300,400);    
//setVisible(true);
//	}
	


