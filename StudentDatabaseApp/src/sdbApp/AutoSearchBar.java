package sdbApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AutoSearchBar 
{
	private JPanel panel;
	private JTextField searchBar;
	private JButton clearButton;
	
	public AutoSearchBar()
	{
		panel = new JPanel();
		searchBar = new JTextField(50);
		clearButton = new JButton("Clear");
		
		searchBar.setText("Search Bar (not case-sensitive)");
		searchBar.setBackground(Color.decode("#e5e5e5"));
		searchBar.setForeground(Color.decode("#949499"));
		searchBar.setMaximumSize(new Dimension(500, 30));
		searchBar.setPreferredSize(new Dimension(350, 30));
		searchBar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GREEN, 2), BorderFactory.createLoweredBevelBorder())));
		
		clearButton.setMaximumSize(new Dimension(80, 30));
		clearButton.setPreferredSize(new Dimension(80, 30));
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panel.add(searchBar);
		panel.add(clearButton);
	}
	
	public JPanel getComponent()
	{
		return panel;
	}
	
	public void addKeyListener(StudentDatabaseApp sdbApp)
	{
		searchBar.addKeyListener(sdbApp);
	}
	
	public void addActionListener(StudentDatabaseApp sdbApp)
	{
		clearButton.addActionListener(sdbApp);
	}
	
	public String getText()
	{
		searchBar.setForeground(Color.BLACK);
		return searchBar.getText();
	}
	
	public void clearText()
	{
		searchBar.setText("");
	}
}