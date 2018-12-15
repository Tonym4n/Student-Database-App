package sdbApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Database layer;
public class TableDisplay
{
	private DefaultTableModel model;
	private JTable table;
	private JPanel panel;
	private JScrollPane tableScrollBar;
	private String[] colName = {"Student ID", "First Name", "Last Name", "Major"};
	
	public TableDisplay(ArrayList<String[]> data)
	{
		String[][] studentData = new String[data.size()][];
		for(int i = 0; i < data.size(); i++)
			studentData[i] = data.get(i);
		
		//create a table based off of the default table model;
		model = new DefaultTableModel(studentData, colName);
		table = new JTable(model);
		panel = new JPanel();
		//gives the table a scroll bar if it becomes too big;
		tableScrollBar = new JScrollPane(table);
		
		//ensures the table uses the entire height of the app screen;
		table.setFillsViewportHeight(true);
		table.setBackground(Color.CYAN);
		table.setGridColor(Color.BLUE);
		table.setBorder(BorderFactory.createLoweredBevelBorder());
		
		//makes it so user is only allowed to select one row;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(tableScrollBar);
	}
	
	public JPanel getComponent()
	{
		return panel;
	}
	
	public JTable getTable()
	{
		return table;
	}
	
	public void addListSelectionListener(StudentDatabaseApp sdbApp)
	{
		//add a listener for when user clicks on different rows in table;
		ListSelectionModel selectedRow = table.getSelectionModel();
		selectedRow.addListSelectionListener(sdbApp);
	}
	
	public void addTableModelListener(StudentDatabaseApp sdbApp)
	{
		model.addTableModelListener(sdbApp);
	}
	
	//checks every table cell for the searchItem; if present, shifts the row containing it
	//to the top of the table and mirrors the action in the ArrayList;
	public void searchTableFor(String searchItem, ArrayList<String[]> data)
	{
		searchItem = searchItem.toLowerCase();
		for(int rowChecked = 0; rowChecked < table.getRowCount(); rowChecked++)
		{
			for(int columnChecked = 0; columnChecked < table.getColumnCount(); columnChecked++)
			{
				String cellItem = (String)table.getValueAt(rowChecked, columnChecked);
				cellItem = cellItem.toLowerCase();
				if(cellItem.length() >= searchItem.length() && cellItem.indexOf(searchItem) != -1)
				{
					data.add(0, data.get(rowChecked));;
					data.remove(rowChecked + 1);
					model.moveRow(rowChecked, rowChecked, 0);
					break;
				}
			}
		}
	}
	
	public void addRow(ArrayList<String[]> data)
	{
		saveToFile(data);
		model.addRow(data.get(data.size() - 1));
	}
	
	public void deleteRow(ArrayList<String[]> data)
	{
		saveToFile(data);
		int row = table.getSelectedRow();
		model.removeRow(row);
	}
	
	public void deleteAll(ArrayList<String[]> data)
	{
		for(int row = 0; row < table.getRowCount(); )
			model.removeRow(row);
		data.clear();
		saveToFile(data);
	}
	
	public void editRow(ArrayList<String[]> data)
	{
		saveToFile(data);
		if(table.getEditingRow() != -1)
			return;
		int row = table.getSelectedRow();
		table.setValueAt(data.get(row)[0], row, 0);
		table.setValueAt(data.get(row)[1], row, 1);
		table.setValueAt(data.get(row)[2], row, 2);
		table.setValueAt(data.get(row)[3], row, 3);
	}
	
	//clear the table, then rebuild it using a previous copy of the data;
	public void restoreTable(ArrayList<String[]> data)
	{
		saveToFile(data);
		for(int row = 0; row < table.getRowCount(); )
			model.removeRow(row);
		
		for(int row = 0; row < data.size(); row++)
			model.addRow(data.get(row));
	}
	
	private void saveToFile(ArrayList<String[]> newData)
	{
		try
		{
			Scanner inputStream = new Scanner(new File("sdbApp.txt"));
			String firstThreeLines = "";
			for(int i = 0; i < 3; i++)
				firstThreeLines = firstThreeLines + inputStream.nextLine() + "\r\n";
			inputStream.close();
			//overwrite the text file with new data;
			PrintWriter outputStream = new PrintWriter(new File("sdbApp.txt"));
			outputStream.print(firstThreeLines);
			for(int i = 0; i < newData.size(); i++)
			{
				for(int j = 0; j < newData.get(i).length; j++)
					outputStream.print(newData.get(i)[j] + ";");
				outputStream.print("\r\n");
			}
			outputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.\nAborting program.");
			System.exit(0);
		}
	}
}