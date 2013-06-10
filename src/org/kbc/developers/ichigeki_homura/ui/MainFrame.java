package org.kbc.developers.ichigeki_homura.ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;

import org.kbc.developers.ichigeki_homura.util.IchigekiRunnable;
import org.kbc.developers.ichigeki_homura.util.IchigekiRunnable.IchigekiEventListener;
import org.kbc.developers.ichigeki_homura.util.Log;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367600225000809387L;
	private static final String TAG = MainFrame.class.getSimpleName();
	private JTextField textField;
	private JTextPane mTextPane;

	private IchigekiEventListener mIchigekiEventListener = new IchigekiEventListener() {
		
		@Override
		public void onMessage(String message) {
			Log.i(TAG, message);
			//mTextPane.setText(mTextPane.getText() + "\n" + message); 
		}
		
		@Override
		public void onFinish(Throwable e) {
			
		}
	};

	public MainFrame() {
		super();
		setTitle("test");
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 160);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("ichihomu_icon.png"));
        setIconImage(icon.getImage());
        
        JButton btnExec = new JButton("Exec");
        btnExec.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		Thread thread = new Thread(new IchigekiRunnable(textField.getText(), mIchigekiEventListener));
        		thread.run();
        	}
        });
        getContentPane().add(btnExec, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 20, 0};
        gbl_panel.rowHeights = new int[]{25, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.BOTH;
        gbc_textField.insets = new Insets(0, 0, 0, 5);
        gbc_textField.gridx = 0;
        gbc_textField.gridy = 0;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("...");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent  event) {
        		JFileChooser fileChooset = new JFileChooser();
        		fileChooset.showOpenDialog(MainFrame.this);
        		File file = fileChooset.getSelectedFile();
        		textField.setText(file.getPath());
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 0;
        panel.add(btnNewButton, gbc_btnNewButton);
        
        mTextPane = new JTextPane();
        getContentPane().add(mTextPane, BorderLayout.CENTER);
	}
}
