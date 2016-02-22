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
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;

public class View extends JFrame {
	private JTable tableMat;
	private JComboBox sizeBox;
	private JComboBox lengthBox;
	
	Object[] results;
	private int matrixArea;
	public View() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Size: ");
		panel.add(lblNewLabel);
		
		
		String[] sizeList = { "3", "4", "5", "6", "7", "8" };
		
		JComboBox sizeBox = new JComboBox(sizeList);
		panel.add(sizeBox);
		
		JLabel lblNewLabel_2 = new JLabel("Length:");
		panel.add(lblNewLabel_2);
		
		String[] lengthList = { "3", "4", "5", "6", "7", "8", "9" };
		
		JComboBox lengthBox = new JComboBox(lengthList);
		panel.add(lengthBox);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel matrixHolder = new JLabel("Matrix: ");
		panel_1.add(matrixHolder);
		
		tableMat = new JTable();
		tableMat.setSize(this.matrixArea, this.matrixArea);
		panel_1.add(tableMat);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JList list = new JList(results);
		panel_2.add(list);
		
		JButton btnNewButton = new JButton("Enter");
		panel_2.add(btnNewButton);
	}

	
	protected void onEnterClicked(){
		
		String matrixSize = (String) this.sizeBox.getSelectedItem();
		int lengthSize = (Integer) this.lengthBox.getSelectedItem();
		
		this.matrixArea = lengthSize;
	}
}
