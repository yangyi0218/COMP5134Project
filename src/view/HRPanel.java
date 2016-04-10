package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import mode.Staff;

/**
 * 
 * @author Jianuo
 *
 */

public class HRPanel extends JPanel implements ActionListener {
	
		
	private JButton editButton;
	private JButton loginButton;
	private HashMap<String, Staff> allstaff;
	
	/**
	 * 
	 * @param allStaff
	 */
	public HRPanel(HashMap<String, Staff> allStaff) {
		this.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.add(new JLabel("Welcome to HR system!"));
		this.add(topPanel, BorderLayout.NORTH);
	    
	    JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));
        for (int i = 0; i < 6; i++) {
        	centerPanel.add(new JPanel());
        }
	    
        centerPanel.add(new JPanel());
	    editButton = new JButton("Add or delete a staff");
	    centerPanel.add(editButton);
	    editButton.addActionListener(this);
	    centerPanel.add(new JPanel());
	        
	    for (int i = 0; i < 3; i++) {
	      	centerPanel.add(new JPanel());
	    }

	    centerPanel.add(new JPanel());
	    loginButton = new JButton("Login");
	    centerPanel.add(loginButton);
	    loginButton.addActionListener(this);
	    centerPanel.add(new JPanel());
	    
	    for (int i = 0; i < 3; i++) {
	    	centerPanel.add(new JPanel());
	    }
	    add(centerPanel, BorderLayout.CENTER);
	    
	    this.allstaff = allStaff;	        
	}
	
	public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if(source == editButton){ // someone clicks edit button
            EditStaffFrame editStaffFrame = new EditStaffFrame(allstaff);
            editStaffFrame.setVisible(true);
        } else{ //someone clicks login button
            LoginFrame loginFrame = new LoginFrame(allstaff);
            loginFrame.setVisible(true);
        }
        
	}	    
}
