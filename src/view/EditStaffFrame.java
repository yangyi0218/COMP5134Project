package view;

import javax.swing.*;


/**
 * 
 * @author Jianuo
 *
 */
public class EditStaffFrame extends JFrame {
	private EditStaffPanel editStaffPanel;

	public EditStaffFrame() {
		super("Add/Delete Staff Window");
        this.setSize(500, 300);
        this.setLocation(800, 100);
        editStaffPanel = new EditStaffPanel(this);
        this.add(editStaffPanel);
	}

}
