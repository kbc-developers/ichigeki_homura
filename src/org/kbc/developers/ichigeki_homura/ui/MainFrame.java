package org.kbc.developers.ichigeki_homura.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367600225000809387L;

	public MainFrame(String title) {
		super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 160);
        setLocationRelativeTo(null);
	}
}
