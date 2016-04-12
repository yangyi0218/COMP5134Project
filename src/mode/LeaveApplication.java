package mode;

/**
 * A LeaveApplicaiton is the leave application made by a Staff
 * @author Jianuo YANG
 * @author 15115046G
 */
public class LeaveApplication {

	private String staffID;
	private String startDate;
	private String endDate;
	
	/**
	 * Constructs a instance of LeaveApplication
	 * @param staffID the staffID of the staff who made this LeaveApplication
	 * @param startDate the startDate of this LeaveApplication
	 * @param endDate the endDate of this LeaveApplicaiton
	 */
	
	public LeaveApplication (String staffID, String startDate, String endDate) {
		this.staffID = staffID;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getStaffID() {
		return staffID;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}

}
