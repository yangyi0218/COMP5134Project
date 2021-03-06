package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


import mode.LeaveApplication;
import mode.Staff;

public class AskForLeavePanel extends JPanel implements ActionListener {
	String startDate;
    String endDate;
    JTextField fromDateTextField;
    JTextField toDateTextField;
    AskForLeaveFrame askForLeaveFrame;
    String staffID;
    Staff staff;

    public AskForLeavePanel(String staffID, AskForLeaveFrame askForLeaveFrame) {
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
        this.staffID = staffID;
        this.askForLeaveFrame = askForLeaveFrame;
        this.staff = HRSystemRun.allStaff.get(staffID);


    }


    public void actionPerformed(ActionEvent e) {
        startDate = fromDateTextField.getText();
        endDate = toDateTextField.getText();
        LeaveApplication leaveApplication = HRSystemRun.allStaff.get(staffID).askForLeave(startDate, endDate);
        
        boolean response = makeRequest(leaveApplication);

        if (response == true) {
            JOptionPane.showMessageDialog(askForLeaveFrame, "supervisors says yes");
        } else {
            JOptionPane.showMessageDialog(askForLeaveFrame, "supervisors says no");
        }
    
    }
    public boolean makeRequest(LeaveApplication leaveApplication) {
    	Staff supervisor = staff.getSupervisor();
    	AskForLeaveFrame supervisorFrame = HRSystemRun.allAskForLeaveFrame.get(supervisor);
        AskForLeavePanel supervisorPanel = supervisorFrame.getAskForLeavePanel();
    	return supervisorPanel.receiveLeaveRequest(leaveApplication);
    }
    
	public boolean receiveLeaveRequest(LeaveApplication leaveApplication){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        String message = leaveApplication.getStaffID() + " asks leave from " 
        + leaveApplication.getStartDate() + " to " + leaveApplication.getEndDate();
        int dialogResult = JOptionPane.showConfirmDialog(askForLeaveFrame, message,"Warning",dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION) { // if the response to leave application of the supervisee is approved
            if(staff.handleApplication()) {// the staff has no supervisor (i.e. this staff is a director), 
                return true;
            }
            else {// if this staff has supervisor, pass this request to supervisor of this staff
                return makeRequest(leaveApplication);
            }
        }
        else{ // the response to leaveAppliction of the supervisee is reject
            return false;
        }
	}

}
