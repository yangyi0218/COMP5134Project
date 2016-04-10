package view;

import java.util.HashMap;

import mode.Staff;

/**
 * 
 * @author Jianuo
 *
 */
public class HRSystemRun {
	public static HashMap<String, Staff> allStaff;

	public static void main(String[] args) {
		
		allStaff = new HashMap<>();
		Staff director = new Staff("001",null);
		allStaff.put("001",director);
		
		HRFrame hrFrame = new HRFrame(allStaff);
		hrFrame.setVisible(true);

	}

}
