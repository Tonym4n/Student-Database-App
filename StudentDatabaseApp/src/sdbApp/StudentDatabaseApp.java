package sdbApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Interface Layer;
public class StudentDatabaseApp extends JFrame implements ActionListener, ListSelectionListener, TableModelListener, KeyListener
{
	private Container body;
	private TableDisplay table;
	private AutoSearchBar searchBar;
	private TabbedPane tab;
	private String keyString = "";
	
	private ArrayList<String[]> studentData = new ArrayList<String[]>();
	private ArrayList<String[]> tempStudentData = new ArrayList<String[]>();
	
	public StudentDatabaseApp()
	{
		super("Student Database App");
		//retrieve the data from a text file;
		loadData();
		copyData(studentData, tempStudentData);
		body = getContentPane();
		
		table = new TableDisplay(studentData);
		table.addListSelectionListener(this);
		table.addTableModelListener(this);
		searchBar = new AutoSearchBar();
		searchBar.addKeyListener(this);
		searchBar.addActionListener(this);
		tab = new TabbedPane();
		tab.addActionListener(this);
		
		//setting up the app layout;
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		body.add(table.getComponent());
		body.add(searchBar.getComponent());
		body.add(tab.getComponent());
		
		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//executes when a button is pressed;
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			//add a table row each time button is clicked;
			case "Add":
				if(table.getTable().getEditingRow() != -1)
					break;
				tempStudentData.clear();
				copyData(studentData, tempStudentData);
				String[] newStudent = new String[13];
				newStudent = tab.getNewData();
				studentData.add(newStudent);
				table.addRow(studentData); 
				break;
			//delete the selected table row;
			case "Delete":
				if(table.getTable().getEditingRow() != -1)
					break;
				//-1 gets returned if no row is selected;
				if(table.getTable().getSelectedRow() != -1)
				{
					tempStudentData.clear();
					copyData(studentData, tempStudentData);
					studentData.remove(table.getTable().getSelectedRow());
					table.deleteRow(studentData);
				}
				break;
			case "Delete All":
				if(table.getTable().getEditingRow() != -1)
					break;
				tempStudentData.clear();
				copyData(studentData, tempStudentData);
				table.deleteAll(studentData);
				break;
			//update the selected table row;
			case "Save Changes":
				if(table.getTable().getEditingRow() != -1)
					break;
				if(table.getTable().getSelectedRow() != -1)
				{
					tempStudentData.clear();
					copyData(studentData, tempStudentData);
					int row = table.getTable().getSelectedRow();
					studentData.set(row, tab.getModifiedData());
					table.editRow(studentData);
					tab.setInfoFields(studentData, row, true);
					tab.setEditFields(studentData, row);
				}
				break;
			//undoes the last change made;
			case "Undo":
				if(table.getTable().getEditingRow() != -1)
					break;
				studentData.clear();
				copyData(tempStudentData, studentData);
				table.restoreTable(studentData);
				break;
			//clear the search bar;
			case "Clear":
				if(table.getTable().getEditingRow() != -1)
					break;
				searchBar.clearText();
				break;
			default: 
				break;
		}
	}
	
	//executes when a different row is selected in the table;
	public void valueChanged(ListSelectionEvent e)
	{
		//display info for the tabs each time a new row is selected;
		if(table.getTable().getSelectedRow() != -1)
		{	
			int row = table.getTable().getSelectedRow();
			tab.setInfoFields(studentData, row, true);
			tab.setEditFields(studentData, row);
		}
		//returns -1 when a row is deleted (because row selection changes);
		//set the labels to empty values when a row is deleted;
		else
		{
			ArrayList<String[]> emptyData = new ArrayList<String[]>();
			String[] emptyString = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
			emptyData.add(emptyString);
			tab.setInfoFields(emptyData, 0, false);
			tab.setEditFields(emptyData, 0);
		}
	}
	
	//executes when directly editing values in the table;
	public void tableChanged(TableModelEvent e)
	{
		//.getEditingRow() acts as a sort of control variable so when table values are being updated;
		//this event doesn't fire again and lock up the program;
		if(table.getTable().getEditingRow() != -1)
		{
			tempStudentData.clear();
			copyData(studentData, tempStudentData);
			int row = e.getLastRow();
			int col = e.getColumn();
			String changedValue = (String)table.getTable().getValueAt(row, col);
			if(changedValue.length() == 0)
				changedValue = "-";
			
			String[] tempStringArray = new String[13];
			for(int i = 0; i < tempStringArray.length; i++)
				tempStringArray[i] = studentData.get(row)[i];
			tempStringArray[col] = changedValue;
			studentData.set(row, tempStringArray);
			
			table.editRow(studentData);
			tab.setInfoFields(studentData, row, true);
			tab.setEditFields(studentData, row);
		}
	}
	
	public void keyTyped(KeyEvent e)
	{
		//nothing needs to happen here;
	}
	
	public void keyPressed(KeyEvent e)
	{
		//nothing needs to happen here;
	}
	
	//best method to perform autosearch;
	public void keyReleased(KeyEvent e)
	{
		//if not directly editing table cells at the moment and the search bar has a different search term;
		if(table.getTable().getEditingRow() == -1 && keyString.equalsIgnoreCase(searchBar.getText()) == false)
		{
			keyString = searchBar.getText();
			table.searchTableFor(keyString, studentData);
		}
		if(table.getTable().getSelectedRow() != -1)
		{	
			int row = table.getTable().getSelectedRow();
			tab.setInfoFields(studentData, row, true);
			tab.setEditFields(studentData, row);
		}
	}
	
	private void loadData()
	{
		try
		{
			Scanner inputStream = new Scanner(new File("sdbApp.txt"));
			//skip first 3 lines of the file, which only contains the intro for the data file;
			inputStream.nextLine();
			inputStream.nextLine();
			inputStream.nextLine();
			
			while(inputStream.hasNextLine())
			{
				String line = inputStream.nextLine();
				String[] student = line.split(";");
				studentData.add(student);
			}
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.\nAborting program.");
			System.exit(0);
		}
	}
	
	//the copy ArrayList contains all the data from right before the original data gets modified;
	private void copyData(ArrayList<String[]> original, ArrayList<String[]> copy)
	{
		for(String[] data : original)
			copy.add(data);
	}
	
	public static void main(String[] args) 
	{
		StudentDatabaseApp sdbApp = new StudentDatabaseApp();
	}
}