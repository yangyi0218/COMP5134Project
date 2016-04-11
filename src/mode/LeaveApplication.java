package mode;

/**
 * 
 * @author Jianuo
 *
 */
public class LeaveApplication {

	private String staffID;
	private String startDate;
	private String endDate;
	
	/**
	 * 
	 * @param staffID
	 * @param startDate
	 * @param endDate
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
