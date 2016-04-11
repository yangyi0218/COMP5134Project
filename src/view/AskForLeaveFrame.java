package view;


import javax.swing.*;



public class AskForLeaveFrame extends JFrame {
	private AskForLeavePanel askForLeavePanel;

    public AskForLeaveFrame(String staffID){
        super("LeaveApplication Window");
        this.setSize(500, 300);
        this.setLocation(800, 600);
        askForLeavePanel = new AskForLeavePanel(staffID, this);
        this.add(askForLeavePanel);
    }
    
    public AskForLeavePanel getAskForLeavePanel(){
    	return askForLeavePanel;
    }

}
