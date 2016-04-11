package view;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import mode.Staff;

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
