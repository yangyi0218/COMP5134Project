package view;

import java.util.HashMap;

import javax.swing.*;

import mode.Staff;

public class AskForLeaveFrame extends JFrame {
	private AskForLeavePanel askForLeavePanel;

    public AskForLeaveFrame(//HashMap<String, Staff> allStaff, HashMap<Staff, AskForLeaveFrame> allAskForLeaveFrame, 
    		String staffID){
        super("LeaveApplication Window");
        this.setSize(500, 300);
        this.setLocation(800, 600);
        askForLeavePanel = new AskForLeavePanel(//allStaff, allAskForLeaveFrame, 
        		staffID, this);
        this.add(askForLeavePanel);
    }
    
    public AskForLeavePanel getAskForLeavePanel(){
    	return askForLeavePanel;
    }

}
