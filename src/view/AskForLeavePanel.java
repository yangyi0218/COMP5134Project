package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;


import mode.LeaveApplication;
import mode.Staff;

public class AskForLeavePanel extends JPanel implements ActionListener {
	String startTime;
    String endTime;
    JTextField fromDateTextField;
    JTextField toDateTextField;
    AskForLeaveFrame askForLeaveFrame;
    HashMap<String, Staff> allStaff;
    String staffID;

    public AskForLeavePanel(HashMap<String, Staff> allStaff, String staffID, AskForLeaveFrame askForLeaveFrame) {
        if (staffID.equals("001")) {
        	JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Welcome Director!"));
            this.add(topPanel, BorderLayout.NORTH);
        } else {
        	JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Welcome " + staffID + ", Please input your leaving time."));
            this.add(topPanel, BorderLayout.NORTH);
            JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));
            
            for (int i = 0; i < 3; i++) {
            	centerPanel.add(new JPanel());
            }

            centerPanel.add(new JLabel("From", SwingConstants.RIGHT));
            fromDateTextField = new JTextField("", 20);
            centerPanel.add(fromDateTextField);
            centerPanel.add(new JLabel("yyyy/mm/dd", SwingConstants.LEFT));
            
            for (int i = 0; i < 3; i++) {
            	add(new JPanel());
            }
            
            centerPanel.add(new JLabel("To", SwingConstants.RIGHT));
            toDateTextField = new JTextField("", 20);
            centerPanel.add(toDateTextField);
            centerPanel.add(new JLabel("yyyy/mm/dd", SwingConstants.LEFT));
            for (int i = 0; i < 4; i++) {
            	centerPanel.add(new JPanel());
            }
            JButton applyButton = new JButton("Apply");
            centerPanel.add(applyButton);
            applyButton.addActionListener(this);
            
            for (int i = 0; i < 7; i++) {
            	centerPanel.add(new JPanel());
            }
            add(centerPanel, BorderLayout.CENTER);
        }
        this.allStaff = allStaff;
        this.staffID = staffID;
        this.askForLeaveFrame = askForLeaveFrame;

    }


    public void actionPerformed(ActionEvent e) {
        startTime = fromDateTextField.getText();
        endTime = toDateTextField.getText();

        LeaveApplication leaveApplication = new LeaveApplication(staffID, startTime, endTime);
        Staff staff = allStaff.get(staffID);
        boolean response = staff.askForLeave(leaveApplication);

        if (response == true) {
            JOptionPane.showMessageDialog(askForLeaveFrame, "supervisors says yes");
        } else {
            JOptionPane.showMessageDialog(askForLeaveFrame, "supervisors says no");
        }
    }

}
