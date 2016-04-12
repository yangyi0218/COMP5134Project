package mode;




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
	 * Returns the LeaveApplication made by Staff
	 * @param startDate the startDate of LeaveApplication
	 * @param endDate the endDate of LeaveApplication
	 * @return the LeaveApplication made by Staff
	 */
	public LeaveApplication askForLeave(String startDate, String endDate){
		LeaveApplication leaveApplication = new LeaveApplication(staffID, startDate, endDate);
		return leaveApplication;
	}
	
	/**
	 * Indicates whether this Staff can make final decision
	 * @return true ==> Staff can make final decision, false ==> Staff cannot make final decision
	 */
	public boolean handleApplication() {
		if (this.supervisor == null) {
			return true;
		}else {
			return false;
		}
		
	}
	

}
