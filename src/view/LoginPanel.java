package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import mode.Staff;

public class LoginPanel extends JPanel implements ActionListener {
	
	String staffID;
	JTextField staffIDField;
	JButton loginButton;
	LoginFrame loginFrame;

    public LoginPanel(LoginFrame loginFrame) {
    
        this.loginFrame = loginFrame;
        this.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Enter your ID to login"));
        this.add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new GridLayout(6, 3, 5, 10));
        for (int i = 0; i < 6; i++) {
        	centerPanel.add(new JPanel());
        }
        
        centerPanel.add(new JLabel("Staff ID", SwingConstants.RIGHT));
        staffIDField = new JTextField("", 20);
        centerPanel.add(staffIDField);
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
    }

    public void actionPerformed(ActionEvent e) {
        staffID = staffIDField.getText();

        if (staffID.trim().equals("")) {
            JOptionPane.showMessageDialog(loginFrame, "Error: something is missing");
        } else if (!HRSystemRun.allStaff.containsKey(staffID)) {
            JOptionPane.showMessageDialog(loginFrame, "Error: staff does not exist");

        } else {
            JOptionPane.showMessageDialog(loginFrame, "Login successfully!");
            Staff staff = HRSystemRun.allStaff.get(staffID);
            AskForLeaveFrame askForLeaveFrame = new AskForLeaveFrame(staffID);
            HRSystemRun.allAskForLeaveFrame.put(staff, askForLeaveFrame);
            askForLeaveFrame.setVisible(true);
      }
  }

}
