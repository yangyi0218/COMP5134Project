package view;


import javax.swing.*;


public class LoginFrame extends JFrame {
	private LoginPanel loginPanel;

	public LoginFrame() {
		super("Login");
        this.setSize(500, 300);
        this.setLocation(100, 600);
        loginPanel = new LoginPanel(this);
        this.add(loginPanel);
	}

}
