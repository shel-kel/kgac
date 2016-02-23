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
	private JComboBox<String> sizeBox;
	private JComboBox<String> lengthBox;
	
	Object[] results;
	private JLabel lblNewLabel_1;
	private JTextField matrixField;
	
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Size: ");
		panel.add(lblNewLabel);
		
		String[] sizeList = { "3", "4", "5", "6", "7", "8", "9" };
		
		JComboBox<String> sizeBox = new JComboBox<String>(sizeList);
		panel.add(sizeBox);
		
		JLabel lblNewLabel_2 = new JLabel("Length:");
		panel.add(lblNewLabel_2);
		
		String[] lengthList = { "3", "4", "5", "6", "7", "8", "9" };
		
		JComboBox<String> lengthBox = new JComboBox<String>(lengthList);
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
		int matrixSize = Integer.valueOf((String) this.sizeBox.getSelectedItem());
		int wordLength = Integer.valueOf((String) this.lengthBox.getSelectedItem());
		String[][] matrix = new String[matrixSize][matrixSize];
		String matrixString = this.matrixField.getText();
		String[] matrixList = matrixString.split(","); 
		
		for (int x = 0; x <= matrixSize; x++) {
			for (int y = 0; y <= matrixSize; y++) {
				matrix[y][x] = matrixList[x];
			}
		}
	

		Filter fil = new Filter();
		Finder fin = new Finder(matrix);
	}

}
