package view;

import java.util.HashMap;

import javax.swing.*;

import mode.Staff;

/**
 * 
 * @author Jianuo
 *
 */
public class EditStaffFrame extends JFrame {
	private EditStaffPanel editStaffPanel;

	public EditStaffFrame(HashMap<String, Staff> allStaff) {
		super("Add/Delete Staff Window");
        this.setSize(500, 300);
        this.setLocation(800, 100);
        editStaffPanel = new EditStaffPanel(allStaff, this);
        this.add(editStaffPanel);
	}

}
