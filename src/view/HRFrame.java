package view;

import javax.swing.*;

/**
 * 
 * @author Jianuo
 *
 */
public class HRFrame extends JFrame {
	private HRPanel hrPanel;
	
	public HRFrame() {
		super("HRSystem");
		this.setSize(500, 300);
		this.setLocation(100, 100);
		hrPanel = new HRPanel();
		this.add(hrPanel);
		
	}

}
