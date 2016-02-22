//Prompts user for various information
//Passes information to controller
//Controller uses that information to make Finder and Filter
//Displays a list of possible words
//And the matrix itself probably, that shouldn't be too hard
//doesn't need to be fancy or anything

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;

public class View extends JFrame {
	private JTable tableMat;
	private JComboBox sizeBox;
	private JComboBox lengthBox;
	
	Object[] results;
	private int matrixArea;
	private JLabel lblNewLabel_1;
	private JTextField matrixField;
	private String[][][] matrixList;
	public View() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Size: ");
		panel.add(lblNewLabel);
		
		String[] sizeList = { "3", "4", "5", "6", "7", "8", "9" };
		
		JComboBox sizeBox = new JComboBox(sizeList);
		panel.add(sizeBox);
		
		JLabel lblNewLabel_2 = new JLabel("Length:");
		panel.add(lblNewLabel_2);
		
		Object[] lengthList = { "3", "4", "5", "6", "7", "8", "9" };
		
		JComboBox lengthBox = new JComboBox(lengthList);
		panel.add(lengthBox);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel_1 = new JLabel("Matrix: (Enter letters seperated by commas)");
		panel_1.add(lblNewLabel_1);
		
		matrixField = new JTextField();
		panel_1.add(matrixField);
		matrixField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton submitButton = new JButton("Submit");
		panel_2.add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onSubmitBtnClicked();
			}
		});
	}

	
	protected void onSubmitBtnClicked(){
		int x = 0;
		int y = 0;
		String[][] matrix = new String[x][y];
		int matrixSize = Integer.valueOf((String) this.sizeBox.getSelectedItem());
		String matrixString = this.matrixField.getText();
		java.util.List<String> this.matrixList = Arrays.asList(matrixString.split(","));
		matrixList = 
		while (x != matrixSize) {
			while (y != matrixSize) {
				matrix = this.matrixList[0];
			}
		}
	
	}

}
