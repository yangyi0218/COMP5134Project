package view;

import java.util.HashMap;

import javax.swing.*;

import mode.Staff;

public class LoginFrame extends JFrame {
	private LoginPanel loginPanel;

	public LoginFrame(//HashMap<String, Staff> allStaff, HashMap<Staff, AskForLeaveFrame> allAskForLeaveFrame
			) {
		super("Login");
        this.setSize(500, 300);
        this.setLocation(100, 600);
        loginPanel = new LoginPanel(//allStaff, allAskForLeaveFrame, 
        		this);
        this.add(loginPanel);
	}

}
