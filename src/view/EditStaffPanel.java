package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import mode.Staff;

/**
 * 
 * @author Jianuo
 *
 */

public class EditStaffPanel extends JPanel implements ActionListener {
    String staffID;
    String supervisorID;
    JTextField staffIDField;
    JTextField supervisorIDField;
    JButton addButton;
    JButton deleteButton;
    EditStaffFrame editStaffFrame;

    /**
     * 
     * @param allStaff
     * @param addStaffFrame
     */
    public EditStaffPanel(EditStaffFrame editStaffFrame) {
        this.editStaffFrame = editStaffFrame;
        this.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Add or delete a staff"));
        this.add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));
        for (int i = 0; i < 6; i++) {
        	centerPanel.add(new JPanel());
        }

        centerPanel.add(new JLabel("Staff ID", SwingConstants.RIGHT));
        staffIDField = new JTextField("", 20);
        centerPanel.add(staffIDField);
        centerPanel.add(new JPanel());

        centerPanel.add(new JLabel("Supervisor ID", SwingConstants.RIGHT));
        supervisorIDField = new JTextField("", 20);
        centerPanel.add(supervisorIDField);
        centerPanel.add(new JPanel());
        
        for (int i = 0; i < 3; i++) {
        	centerPanel.add(new JPanel());
        }

        centerPanel.add(new JPanel());
        addButton = new JButton("Add");
        centerPanel.add(addButton);
        addButton.addActionListener(this);
        centerPanel.add(new JPanel());        

        centerPanel.add(new JPanel());
        deleteButton = new JButton("Delete");
        centerPanel.add(deleteButton);
        deleteButton.addActionListener(this);
        for (int i = 0; i < 4; i++) {
        	centerPanel.add(new JPanel());
        }
        
        add(centerPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        staffID = staffIDField.getText();
        supervisorID = supervisorIDField.getText();

        Object source = e.getSource();
        if(source == addButton) { // add a staff
            if (staffID.trim().equals("") || supervisorID.trim().equals("")) {
                JOptionPane.showMessageDialog(editStaffFrame, "Error: something is missing!");
            } else if (HRSystemRun.allStaff.containsKey(staffID)) {
                JOptionPane.showMessageDialog(editStaffFrame, "Error: staff id already exists!");
            } else if (!HRSystemRun.allStaff.containsKey(supervisorID)) {
                JOptionPane.showMessageDialog(editStaffFrame, "Error: supervisor does not exist!");
            } else {
                Staff supervisor = HRSystemRun.allStaff.get(supervisorID);
                Staff staff = new Staff(staffID, supervisor);
                HRSystemRun.allStaff.put(staffID, staff);
                supervisor.supervise(true);
                JOptionPane.showMessageDialog(editStaffFrame, "Add successfully!");
            }
        }else{ //delete a staff
            if(!HRSystemRun.allStaff.containsKey(staffID)){
                JOptionPane.showMessageDialog(editStaffFrame, "Error: staff does not exist!");
            }else if (staffID.trim().equals("001")){
            	JOptionPane.showMessageDialog(editStaffFrame, "Error: You can not delete Director!");
            }else if(HRSystemRun.allStaff.get(staffID).getSupervisedStaff() != 0) {
            	JOptionPane.showMessageDialog(editStaffFrame, "Error: staff supervises others!");
            }else {
            	HRSystemRun.allStaff.get(staffID).getSupervisor().supervise(false);
            	HRSystemRun.allStaff.remove(staffID);
                JOptionPane.showMessageDialog(editStaffFrame, "Delete successfully!");
            }
        }
    }
}
