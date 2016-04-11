package mode;


import view.AskForLeaveFrame;

/**
 * A Staff is a staff of the Company with a staffID and a supervisor.
 * @author Jianuo YANG
 * @author 15115046G
 */
public class Staff {
	
	private String staffID;
	private Staff supervisor;
	private int supervisedStaff = 0;
	
	/**
	 * Constructs a new instance of Staff with the specified staffID and supervisor
	 * @param staffID the ID of the Staff
	 * @param supervisor the supervisor Staff of this Staff
	 */
	public Staff(String staffID, Staff supervisor) {
		this.staffID = staffID;
		this.supervisor = supervisor;
	}
	
	//
	//getters and setters
	//
	
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
	
	/**
	 * Indicates whether a supervisee is added/deleted
	 * @param addsupervisee true ==> add a supervisee, false ==> delete a supervisee
	 */
	public void supervise(boolean addsupervisee) {
		if(addsupervisee){ // add a supervisee
			this.supervisedStaff++;
		}else { //delete a supervisee
			this.supervisedStaff--;
		}
	}
	

	/**
	 * Returns the response of LeaveApplication from supervisor(s), makes a LeaveApplication to supervisor(s).
	 * @param leaveApplication the LeaveApplication the of staff
	 * @return 
	 * @return the response from supervisor(s)
	 */

	public LeaveApplication askForLeave(String startDate, String endDate){
		LeaveApplication leaveApplication = new LeaveApplication(staffID, startDate, endDate);
		return leaveApplication;
	}
	
	/**
	 * Returns the response to LeaveApplication of supervisee, 
	 * @param leaveApplication the LeaveApplication from supervisee
	 * @return the response to LeaveApplication of suerpvisee
	 */

	public boolean handleApplication() {
		if (this.supervisor == null) {
			return true;
		}else {
			return false;
		}
		
	}
	

}
