package sdbApp;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.table.*;
import javax.swing.event.*;
import java.util.ArrayList;

//Business Layer;
public class TabbedPane 
{
	private JTabbedPane tab;
	private JPanel panel;
	
	private JButton addButton, editButton, deleteButton, deleteAllButton, undoButton;
	
	//text fields for adding new information or editing current info;
	private JTextField idInput = new JTextField(20), idEdit = new JTextField(20),
			firstNameInput = new JTextField(20), firstNameEdit = new JTextField(20),
			lastNameInput = new JTextField(20), lastNameEdit = new JTextField(20),
			majorInput = new JTextField(20), majorEdit = new JTextField(20),
			genderInput = new JTextField(20), genderEdit = new JTextField(20),
			dobInput = new JTextField(20), dobEdit = new JTextField(20), 
			enrollmentInput = new JTextField(20), enrollmentEdit = new JTextField(20),
			q1Input = new JTextField(20), q1Edit = new JTextField(20),
			q2Input = new JTextField(20), q2Edit = new JTextField(20),
			q3Input = new JTextField(20), q3Edit = new JTextField(20),
			t1Input = new JTextField(20), t1Edit = new JTextField(20),
			t2Input = new JTextField(20), t2Edit = new JTextField(20),
			t3Input = new JTextField(20), t3Edit = new JTextField(20);
	
	private JLabel id = new JLabel(), firstName = new JLabel(), lastName = new JLabel(), 
			major = new JLabel(), gender = new JLabel(), dob = new JLabel(), enrollment = new JLabel(), 
			q1 = new JLabel(), q2 = new JLabel(), q3 = new JLabel(), t1 = new JLabel(), 
			t2 = new JLabel(), t3 = new JLabel(), quizAverage = new JLabel(), testAverage = new JLabel();
	
	public TabbedPane()
	{
		panel = new JPanel();
		tab = new JTabbedPane(JTabbedPane.TOP);
		addButton = new JButton("Add");
		editButton = new JButton("Save Changes");
		deleteButton = new JButton("Delete");
		deleteAllButton = new JButton("Delete All");
		undoButton = new JButton("Undo");
		
		setTabOne();
		setTabTwo();
		setTabThree();
		setTabFour();
		setTabFive();
		
		tab.setMinimumSize(new Dimension(400, 225));
		tab.setPreferredSize(new Dimension(500, 475));
		tab.setMaximumSize(new Dimension(500, 475));
		tab.setBackground(Color.LIGHT_GRAY);
		tab.setBorder(BorderFactory.createRaisedBevelBorder());
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(tab);
	}
	
	private void setTabOne()
	{
		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setLayout(new BoxLayout(studentInfoPanel, BoxLayout.Y_AXIS));
		studentInfoPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		studentInfoPanel.add(new JLabel(" "));
		
		JPanel title = new JPanel();
		title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
		title.add(Box.createRigidArea(new Dimension(50, 10)));
		title.add(new JLabel("STUDENT INFORMATION"));
		title.add(Box.createRigidArea(new Dimension(50, 10)));
		studentInfoPanel.add(title);
		
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.Y_AXIS));
		leftSide.add(new JLabel("ID Number:             "));
		leftSide.add(new JLabel("First Name:            "));
		leftSide.add(new JLabel("Last Name:            "));
		leftSide.add(new JLabel("Major:                      "));
		leftSide.add(new JLabel("Gender:                   "));
		leftSide.add(new JLabel("Date of Birth:         "));
		leftSide.add(new JLabel("Enrollment Date:  "));
		leftSide.add(new JLabel(" "));
		
		JPanel rightSide = new JPanel();
		rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.Y_AXIS));
		rightSide.add(id);
		rightSide.add(firstName);
		rightSide.add(lastName);
		rightSide.add(major);
		rightSide.add(gender);
		rightSide.add(dob);
		rightSide.add(enrollment);
		rightSide.add(new JLabel(" "));
		
		JPanel innerPanel = new JPanel(new FlowLayout());
		innerPanel.add(leftSide);
		innerPanel.add(rightSide);
		studentInfoPanel.add(innerPanel);
		
		JPanel gradesPanel = new JPanel();
		gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.Y_AXIS));
		gradesPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		gradesPanel.add(new JLabel(" "));
		
		title = new JPanel();
		title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
		title.add(Box.createRigidArea(new Dimension(50, 10)));
		title.add(new JLabel("QUIZ AND TEST GRADES"));
		title.add(Box.createRigidArea(new Dimension(50, 10)));
		gradesPanel.add(title);
		
		leftSide = new JPanel();
		leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.Y_AXIS));
		leftSide.add(new JLabel("Quiz #1:                   "));
		leftSide.add(new JLabel("Quiz #2:                   "));
		leftSide.add(new JLabel("Quiz #3:                   "));
		JLabel quizAverageInfo = new JLabel("Quiz Average:              ");
		quizAverageInfo.setForeground(Color.decode("#4c924c"));
		leftSide.add(quizAverageInfo);
		
		leftSide.add(new JLabel("Test #1:                   "));
		leftSide.add(new JLabel("Test #2:                   "));
		leftSide.add(new JLabel("Test #3:                   "));
		JLabel testAverageInfo = new JLabel("Test Average:              ");
		testAverageInfo.setForeground(Color.decode("#4c924c"));
		leftSide.add(testAverageInfo);
		leftSide.add(new JLabel(" "));
		
		rightSide = new JPanel();
		rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.Y_AXIS));
		rightSide.add(q1);
		rightSide.add(q2);
		rightSide.add(q3);
		rightSide.add(quizAverage);
		rightSide.add(t1);
		rightSide.add(t2);
		rightSide.add(t3);
		rightSide.add(testAverage);
		rightSide.add(new JLabel(" "));
		
		innerPanel = new JPanel(new FlowLayout());
		innerPanel.add(leftSide);
		innerPanel.add(rightSide);
		gradesPanel.add(innerPanel);
		
		innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.add(studentInfoPanel);
		innerPanel.add(gradesPanel);
		
		JPanel outerPanel = new JPanel(new FlowLayout());
		outerPanel.add(innerPanel);
		
		tab.addTab("   Information    ", null, outerPanel, "View existing information on the selected student");
	}
	
	private void setTabTwo()
	{
		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setLayout(new BoxLayout(studentInfoPanel, BoxLayout.Y_AXIS));
		studentInfoPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		studentInfoPanel.add(new JLabel("STUDENT INFORMATION"));
		
		JPanel line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("ID Number:             "));
		idEdit.setMaximumSize(new Dimension(200, 20));
		idEdit.setBackground(Color.YELLOW);
		line.add(idEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("First Name:            "));
		firstNameEdit.setMaximumSize(new Dimension(200, 20));
		firstNameEdit.setBackground(Color.YELLOW);
		line.add(Box.createRigidArea(new Dimension(1, 10)));
		line.add(firstNameEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Last Name:            "));
		lastNameEdit.setMaximumSize(new Dimension(200, 20));
		lastNameEdit.setBackground(Color.YELLOW);
		line.add(Box.createRigidArea(new Dimension(1, 10)));
		line.add(lastNameEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Major:                      "));
		majorEdit.setMaximumSize(new Dimension(200, 20));
		majorEdit.setBackground(Color.YELLOW);
		line.add(majorEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Gender:                   "));
		genderEdit.setMaximumSize(new Dimension(200, 20));
		genderEdit.setBackground(Color.YELLOW);
		line.add(genderEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Date of Birth:         "));
		dobEdit.setMaximumSize(new Dimension(200, 20));
		dobEdit.setBackground(Color.YELLOW);
		line.add(Box.createRigidArea(new Dimension(1, 10)));
		line.add(dobEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Enrollment Date:  "));
		enrollmentEdit.setMaximumSize(new Dimension(200, 20));
		enrollmentEdit.setBackground(Color.YELLOW);
		line.add(Box.createRigidArea(new Dimension(2, 10)));
		line.add(enrollmentEdit);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		studentInfoPanel.add(new JLabel(" "));
		
		JPanel gradesPanel = new JPanel();
		gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.Y_AXIS));
		gradesPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		gradesPanel.add(new JLabel("QUIZ AND TEST GRADES"));
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Quiz #1:                   "));
		q1Edit.setMaximumSize(new Dimension(200, 20));
		q1Edit.setBackground(Color.YELLOW);
		line.add(q1Edit);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Quiz #2:                   "));
		q2Edit.setMaximumSize(new Dimension(200, 20));
		q2Edit.setBackground(Color.YELLOW);
		line.add(q2Edit);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Quiz #3:                   "));
		q3Edit.setMaximumSize(new Dimension(200, 20));
		q3Edit.setBackground(Color.YELLOW);
		line.add(q3Edit);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Test #1:                   "));
		t1Edit.setMaximumSize(new Dimension(200, 20));
		t1Edit.setBackground(Color.YELLOW);
		line.add(t1Edit);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Test #2:                   "));
		t2Edit.setMaximumSize(new Dimension(200, 20));
		t2Edit.setBackground(Color.YELLOW);
		line.add(t2Edit);
		line.add(new JLabel("%"));
		gradesPanel.add(line );
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Test #3:                   "));
		t3Edit.setMaximumSize(new Dimension(200, 20));
		t3Edit.setBackground(Color.YELLOW);
		line.add(t3Edit);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		gradesPanel.add(new JLabel(" "));
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.add(studentInfoPanel);
		innerPanel.add(gradesPanel);
		
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.X_AXIS));
		outerPanel.add(innerPanel);
		outerPanel.add(editButton);
		outerPanel.add(Box.createRigidArea(new Dimension(5, 10)));
		
		tab.addTab("    Edit    ", null, outerPanel, "Edit existing information on the selected student");
	}
	
	private void setTabThree()
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		panel.add(new JLabel("The \"Delete\" button deletes the selected student in the table"));
		panel.add(new JLabel("The \"Delete All\" button deletes ALL students in the table"));
		panel.add(new JLabel("The \"Undo\" button reverts the program to before the last change took place"));
		
		JPanel miniPanel = new JPanel(), tempPanel = new JPanel(new FlowLayout());
		miniPanel.setLayout(new BoxLayout(miniPanel, BoxLayout.Y_AXIS));
		miniPanel.setBorder(BorderFactory.createEtchedBorder());
		tempPanel = new JPanel(new FlowLayout());
		miniPanel.add(Box.createRigidArea(new Dimension(500, 10)));
		tempPanel.add(deleteButton);
		tempPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		tempPanel.add(deleteAllButton);
		tempPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		tempPanel.add(undoButton);
		miniPanel.add(tempPanel);
		miniPanel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		panel.add(miniPanel);
		
		tab.addTab("   Delete/Undo    ", null, panel, "Delete existing information on the selected student");
	}
	
	private void setTabFour()
	{
		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setLayout(new BoxLayout(studentInfoPanel, BoxLayout.Y_AXIS));
		studentInfoPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		studentInfoPanel.add(new JLabel("STUDENT INFORMATION"));
		
		JPanel line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("ID Number:             "));
		idInput.setMaximumSize(new Dimension(200, 20));
		line.add(idInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("First Name:            "));
		firstNameInput.setMaximumSize(new Dimension(200, 20));
		line.add(Box.createRigidArea(new Dimension(1, 10)));
		line.add(firstNameInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Last Name:            "));
		lastNameInput.setMaximumSize(new Dimension(200, 20));
		line.add(Box.createRigidArea(new Dimension(1, 10)));
		line.add(lastNameInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Major:                      "));
		majorInput.setMaximumSize(new Dimension(200, 20));
		line.add(majorInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Gender:                   "));
		genderInput.setMaximumSize(new Dimension(200, 20));
		line.add(genderInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Date of Birth:         "));
		dobInput.setMaximumSize(new Dimension(200, 20));
		line.add(Box.createRigidArea(new Dimension(1, 10)));
		line.add(dobInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Enrollment Date:  "));
		enrollmentInput.setMaximumSize(new Dimension(200, 20));
		line.add(Box.createRigidArea(new Dimension(2, 10)));
		line.add(enrollmentInput);
		line.add(new JLabel("   "));
		studentInfoPanel.add(line);
		studentInfoPanel.add(new JLabel(" "));
		
		JPanel gradesPanel = new JPanel();
		gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.Y_AXIS));
		gradesPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		gradesPanel.add(new JLabel("QUIZ AND TEST GRADES"));
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Quiz #1:                   "));
		q1Input.setMaximumSize(new Dimension(200, 20));
		line.add(q1Input);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Quiz #2:                   "));
		q2Input.setMaximumSize(new Dimension(200, 20));
		line.add(q2Input);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Quiz #3:                   "));
		q3Input.setMaximumSize(new Dimension(200, 20));
		line.add(q3Input);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Test #1:                   "));
		t1Input.setMaximumSize(new Dimension(200, 20));
		line.add(t1Input);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Test #2:                   "));
		t2Input.setMaximumSize(new Dimension(200, 20));
		line.add(t2Input);
		line.add(new JLabel("%"));
		gradesPanel.add(line );
		
		line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.add(Box.createRigidArea(new Dimension(30, 10)));
		line.add(new JLabel("Test #3:                   "));
		t3Input.setMaximumSize(new Dimension(200, 20));
		line.add(t3Input);
		line.add(new JLabel("%"));
		gradesPanel.add(line);
		gradesPanel.add(new JLabel(" "));
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.add(studentInfoPanel);
		innerPanel.add(gradesPanel);
		
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.X_AXIS));
		outerPanel.add(Box.createRigidArea(new Dimension(25, 10)));
		outerPanel.add(innerPanel);
		outerPanel.add(Box.createRigidArea(new Dimension(21, 10)));
		outerPanel.add(addButton);
		
		tab.addTab("    Add     ", null, outerPanel, "Add information for a new student");
	}
	
	private void setTabFive()
	{
		JPanel top = new JPanel(), bottom = new JPanel(), outerPanel = new JPanel(new FlowLayout());
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
		top.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "CREDITS", TitledBorder.CENTER, TitledBorder.TOP));
		bottom.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "HELP SECTION", TitledBorder.CENTER, TitledBorder.TOP));
		
		JPanel subTop = new JPanel();
		subTop.setLayout(new BoxLayout(subTop, BoxLayout.Y_AXIS));
		
		JPanel titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Programmer"));
		subTop.add(titles);
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Tony Man"));
		subTop.add(titles);
		top.add(subTop);
		top.add(Box.createRigidArea(new Dimension(20, 10)));
		
		subTop = new JPanel();
		subTop.setLayout(new BoxLayout(subTop, BoxLayout.Y_AXIS));
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Designer"));
		subTop.add(titles);
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Tony Man"));
		subTop.add(titles);
		top.add(subTop);
		top.add(Box.createRigidArea(new Dimension(20, 10)));
		
		subTop = new JPanel();
		subTop.setLayout(new BoxLayout(subTop, BoxLayout.Y_AXIS));
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Tester"));
		subTop.add(titles);
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Tony Man"));
		subTop.add(titles);
		top.add(subTop);
		top.add(Box.createRigidArea(new Dimension(20, 10)));
		
		subTop = new JPanel();
		subTop.setLayout(new BoxLayout(subTop, BoxLayout.Y_AXIS));
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Publisher"));
		subTop.add(titles);
		titles = new JPanel(new FlowLayout());
		titles.add(new JLabel("Tony Man"));
		subTop.add(titles);
		top.add(subTop);
		top.add(Box.createRigidArea(new Dimension(20, 10)));
		
		bottom.add(new JLabel("Welcome to the Student Database App."));
		bottom.add(new JLabel("The creator of this beautiful work of art is listed above."));
		bottom.add(new JLabel("Navigate the app by selecting a student in the above table."));
		bottom.add(new JLabel("The search bar automatically locates table rows with instances of the text."));
		bottom.add(new JLabel("The \"information\" tab contains the bulk information on the selected student."));
		bottom.add(new JLabel("The \"edit\" tab allows you to change the information on the selected student."));
		bottom.add(new JLabel("The \"delete\" tab allows you to delete the selected student or all students."));
		bottom.add(new JLabel("The \"add\" tab allows you to add a student with the predefined categories."));
		bottom.add(new JLabel("You can also make changes to the table directly but while doing so, "));
		bottom.add(new JLabel("all other app functionality is restricted until the edit is complete."));
		bottom.add(new JLabel("The app automatically saves upon completion of a direct table edit or"));
		bottom.add(new JLabel("upon clicking the add/delete/save changes button."));
		
		outerPanel.add(Box.createRigidArea(new Dimension(500, 20)));
		outerPanel.add(top);
		outerPanel.add(Box.createRigidArea(new Dimension(500, 10)));
		outerPanel.add(bottom);
		
		tab.addTab("    About/Help    ", null, outerPanel, "Get help for using this application");
	}
	
	public void setInfoFields(ArrayList<String[]> data, int tableRowNumber, boolean rowIsSelected)
	{
		quizAverage.setForeground(Color.decode("#4c924c"));
		testAverage.setForeground(Color.decode("#4c924c"));
		
		id.setText(data.get(tableRowNumber)[0]);
		firstName.setText(data.get(tableRowNumber)[1]);
		lastName.setText(data.get(tableRowNumber)[2]);
		major.setText(data.get(tableRowNumber)[3]);
		gender.setText(data.get(tableRowNumber)[4]);
		dob.setText(data.get(tableRowNumber)[5]);
		enrollment.setText(data.get(tableRowNumber)[6]);
		
		if(data.get(tableRowNumber)[7].equals("-") || data.get(tableRowNumber)[7].length() == 0)
			q1.setText(data.get(tableRowNumber)[7]);
		else
			q1.setText(data.get(tableRowNumber)[7] + "%");
		if(data.get(tableRowNumber)[8].equals("-") || data.get(tableRowNumber)[8].length() == 0)
			q2.setText(data.get(tableRowNumber)[8]);
		else
			q2.setText(data.get(tableRowNumber)[8] + "%");
		if(data.get(tableRowNumber)[9].equals("-") || data.get(tableRowNumber)[9].length() == 0)
			q3.setText(data.get(tableRowNumber)[9]);
		else
			q3.setText(data.get(tableRowNumber)[9] + "%");
		if(data.get(tableRowNumber)[10].equals("-") || data.get(tableRowNumber)[10].length() == 0)
			t1.setText(data.get(tableRowNumber)[10]);
		else
			t1.setText(data.get(tableRowNumber)[10] + "%");
		if(data.get(tableRowNumber)[11].equals("-") || data.get(tableRowNumber)[11].length() == 0)
			t2.setText(data.get(tableRowNumber)[11]);
		else
			t2.setText(data.get(tableRowNumber)[11] + "%");
		if(data.get(tableRowNumber)[12].equals("-") || data.get(tableRowNumber)[12].length() == 0)
			t3.setText(data.get(tableRowNumber)[12]);
		else
			t3.setText(data.get(tableRowNumber)[12] + "%");
		
		if(rowIsSelected)
		{
			//try to compute quiz average and test average;
			try
			{
				quizAverage.setText(NumberFormat.getPercentInstance().format((Double.parseDouble(data.get(tableRowNumber)[7]) 
						+ Double.parseDouble(data.get(tableRowNumber)[8]) + Double.parseDouble(data.get(tableRowNumber)[9])) / 300));
			}
			catch(Exception e)
			{
				quizAverage.setText("-");
			}
			try
			{
				testAverage.setText(NumberFormat.getPercentInstance().format((Double.parseDouble(data.get(tableRowNumber)[10]) 
						+ Double.parseDouble(data.get(tableRowNumber)[11]) + Double.parseDouble(data.get(tableRowNumber)[12])) / 300));
			}
			catch(Exception e)
			{
				testAverage.setText("-");
			}
		}
		else
		{
			quizAverage.setText("");
			testAverage.setText("");
		}
	}
	
	//same as setInfoFields() except it lacks computing the quiz and test average;
	public void setEditFields(ArrayList<String[]> data, int tableRowNumber)
	{
		idEdit.setText(data.get(tableRowNumber)[0]);
		firstNameEdit.setText(data.get(tableRowNumber)[1]);
		lastNameEdit.setText(data.get(tableRowNumber)[2]);
		majorEdit.setText(data.get(tableRowNumber)[3]);
		genderEdit.setText(data.get(tableRowNumber)[4]);
		dobEdit.setText(data.get(tableRowNumber)[5]);
		enrollmentEdit.setText(data.get(tableRowNumber)[6]);
		q1Edit.setText(data.get(tableRowNumber)[7]);
		q2Edit.setText(data.get(tableRowNumber)[8]);
		q3Edit.setText(data.get(tableRowNumber)[9]);
		t1Edit.setText(data.get(tableRowNumber)[10]);
		t2Edit.setText(data.get(tableRowNumber)[11]);
		t3Edit.setText(data.get(tableRowNumber)[12]);
	}
	
	public String[] getNewData()
	{
		String[] data = new String[13];
		//if input field is empty;
		if(idInput.getText().length() == 0)
			data[0] = "-";
		else
			data[0] = idInput.getText();
		idInput.setText("");
		if(firstNameInput.getText().length() == 0)
			data[1] = "-";
		else
			data[1] = firstNameInput.getText();
		firstNameInput.setText("");
		if(lastNameInput.getText().length() == 0)
			data[2] = "-";
		else
			data[2] = lastNameInput.getText();
		lastNameInput.setText("");
		if(majorInput.getText().length() == 0)
			data[3] = "-";
		else
			data[3] = majorInput.getText();
		majorInput.setText("");
		if(genderInput.getText().length() == 0)
			data[4] = "-";
		else
			data[4] = genderInput.getText();
		genderInput.setText("");
		if(dobInput.getText().length() == 0)
			data[5] = "-";
		else
			data[5] = dobInput.getText();
		dobInput.setText("");
		if(enrollmentInput.getText().length() == 0)
			data[6] = "-";
		else
			data[6] = enrollmentInput.getText();
		enrollmentInput.setText("");
		if(q1Input.getText().length() == 0)
			data[7] = "-";
		else
			data[7] = q1Input.getText();
		q1Input.setText("");
		if(q2Input.getText().length() == 0)
			data[8] = "-";
		else
			data[8] = q2Input.getText();
		q2Input.setText("");
		if(q3Input.getText().length() == 0)
			data[9] = "-";
		else
			data[9] = q3Input.getText();
		q3Input.setText("");
		if(t1Input.getText().length() == 0)
			data[10] = "-";
		else
			data[10] = t1Input.getText();
		t1Input.setText("");
		if(t2Input.getText().length() == 0)
			data[11] = "-";
		else
			data[11] = t2Input.getText();
		t2Input.setText("");
		if(t3Input.getText().length() == 0)
			data[12] = "-";
		else
			data[12] = t3Input.getText();
		t3Input.setText("");
		return data;
	}
	
	//same as getNewData() except the edit fields stay the same;
	public String[] getModifiedData()
	{
		String[] data = new String[13];
		if(idEdit.getText().length() == 0)
			data[0] = "-";
		else
			data[0] = idEdit.getText();
		if(firstNameEdit.getText().length() == 0)
			data[1] = "-";
		else
			data[1] = firstNameEdit.getText();
		if(lastNameEdit.getText().length() == 0)
			data[2] = "-";
		else
			data[2] = lastNameEdit.getText();
		if(majorEdit.getText().length() == 0)
			data[3] = "-";
		else
			data[3] = majorEdit.getText();
		if(genderEdit.getText().length() == 0)
			data[4] = "-";
		else
			data[4] = genderEdit.getText();
		if(dobEdit.getText().length() == 0)
			data[5] = "-";
		else
			data[5] = dobEdit.getText();
		if(enrollmentEdit.getText().length() == 0)
			data[6] = "-";
		else
			data[6] = enrollmentEdit.getText();
		if(q1Edit.getText().length() == 0)
			data[7] = "-";
		else
			data[7] = q1Edit.getText();
		if(q2Edit.getText().length() == 0)
			data[8] = "-";
		else
			data[8] = q2Edit.getText();
		if(q3Edit.getText().length() == 0)
			data[9] = "-";
		else
			data[9] = q3Edit.getText();
		if(t1Edit.getText().length() == 0)
			data[10] = "-";
		else
			data[10] = t1Edit.getText();
		if(t2Edit.getText().length() == 0)
			data[11] = "-";
		else
			data[11] = t2Edit.getText();
		if(t3Edit.getText().length() == 0)
			data[12] = "-";
		else
			data[12] = t3Edit.getText();
		return data;
	}
	
	//the database is the listener object because the buttons modify the values in the text file;
	public void addActionListener(StudentDatabaseApp sdbApp)
	{
		editButton.addActionListener(sdbApp);
		deleteButton.addActionListener(sdbApp);
		deleteAllButton.addActionListener(sdbApp);
		addButton.addActionListener(sdbApp);
		undoButton.addActionListener(sdbApp);
	}
	
	public JPanel getComponent()
	{
		return panel;
	}
}