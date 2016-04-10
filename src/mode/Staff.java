package mode;

import javax.swing.JOptionPane;

import view.AskForLeaveFrame;

/**
 * 
 * @author Jianuo
 *
 */
public class Staff {
	
	private String staffID;
	private Staff supervisor;
	private AskForLeaveFrame askForLeaveFrame;
	private int supervisedStaff = 0;
	/**
	 * 
	 * @param staffID
	 * @param supervisor
	 */
	public Staff(String staffID, Staff supervisor) {
		this.staffID = staffID;
		this.supervisor = supervisor;
	}
	
	//
	//getters and setters
	//
	
	public AskForLeaveFrame getAskForLeaveFrame() {
		return askForLeaveFrame;
	}
	public void setAskForLeaveFrame(AskForLeaveFrame askForLeaveFrame) {
		this.askForLeaveFrame = askForLeaveFrame;
	}
	public String getStaffID() {
		return staffID;
	}
	public Staff getSupervisor() {
		return supervisor;
	}
	
	public int getSupervisedStaff() {
		return supervisedStaff;
	}
	//
	//
	//
	
	public void supervise(boolean addsupervisee) {
		if(addsupervisee){
			this.supervisedStaff++;
		}else {
			this.supervisedStaff--;
		}
	}
	

	
	public boolean askForLeave(LeaveApplication leaveApplication){
		return supervisor.receiveLeaveRequest(leaveApplication);
	}
	
	public boolean receiveLeaveRequest(LeaveApplication leaveApplication){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        String message = leaveApplication.staffID + " asks leave from " + leaveApplication.startDate + " to " + leaveApplication.endDate;
        int dialogResult = JOptionPane.showConfirmDialog(askForLeaveFrame, message,"Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION) {
            if(supervisor != null)
                return askForLeave(leaveApplication);
            else
                return true;
        }
        else{
            return false;
        }
	}
	

}
