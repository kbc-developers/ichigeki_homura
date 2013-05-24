package org.kbc.developers.ichigeki_homura;

import org.kbc.developers.ichigeki_homura.ui.MainFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class AppMain {
	
	/**
     * @param args
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        
        JButton btnNewButton = new JButton("Exec");
        mainFrame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }
}
