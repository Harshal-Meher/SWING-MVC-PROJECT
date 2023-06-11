package controller;

	import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.sql.*;
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	public class DatabaseViewer
	{

		public void Show() throws SQLException, ClassNotFoundException
		{
			
			 String url="jdbc:mysql://localhost:3306/swing2",uname="root",pass="abc123";
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,uname,pass);
			 Statement st=con.createStatement();
			 
	        // Create a statement to execute SQL queries
	        Statement statement = null;
	        try 
	        {
	            statement = con.createStatement();
	        }
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        // Execute a SELECT query to get data from the database
	        String sql = "SELECT * FROM  sw2";
	        ResultSet resultSet = null;
	        try
	        {
	            resultSet = statement.executeQuery(sql);
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        // Create a JFrame to display the data
	        JFrame frame = new JFrame("Database Data");
	        // Create a JTable to display the data
	        JTable table = new JTable(buildTableModel(resultSet));
	        // Add the JTable to the JFrame
	        frame.add(new JScrollPane(table));
	        // Display the JFrame
	        frame.pack();
	        frame.setSize(500,140);
	        frame.setVisible(true);
			
	    }
	    private static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException
	    {
	        // Create a table model to hold the data
	        DefaultTableModel tableModel = new DefaultTableModel();
	        
	        // Get the column names from the database
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        
	        for (int i = 1; i <= metaData.getColumnCount(); i++)
	        {
	            tableModel.addColumn(metaData.getColumnName(i));
	        }
	        // Get the data from the database
	        while (resultSet.next()) 
	        {
	            // Create a new row in the table model
	            Object[] row = new Object[tableModel.getColumnCount()];
	            
	            for (int i = 0; i < row.length; i++) 
	            {
	                row[i] = resultSet.getObject(i + 1);
	            }
	            tableModel.addRow(row);
	        }
			return tableModel;
			
	    
}
	    
	}