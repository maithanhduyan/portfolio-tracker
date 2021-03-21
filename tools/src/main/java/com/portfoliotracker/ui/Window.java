package com.portfoliotracker.ui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class Window extends JFrame {

	String[] args;

	private static final Logger log = LoggerFactory.getLogger(Window.class);

	private static final long serialVersionUID = -2668676026223241027L;
	private JTextField txtAssetName;
	private JTextField txtAssetCode;
	private JLabel lblPrice;
	private JTextField txtAssetPrice;
	private JButton btnClear;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Window() {
		setTitle("Tools");
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Asset Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(40, 23, 82, 23);
		getContentPane().add(lblNewLabel);

		txtAssetName = new JTextField();
		txtAssetName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAssetName.setBounds(132, 26, 168, 19);
		getContentPane().add(txtAssetName);
		txtAssetName.setColumns(10);

		JLabel lblAssetCode = new JLabel("Asset Code:");
		lblAssetCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssetCode.setBounds(40, 56, 82, 23);
		getContentPane().add(lblAssetCode);

		txtAssetCode = new JTextField();
		txtAssetCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAssetCode.setColumns(10);
		txtAssetCode.setBounds(132, 59, 168, 19);
		getContentPane().add(txtAssetCode);

		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(40, 89, 82, 23);
		getContentPane().add(lblPrice);

		txtAssetPrice = new JTextField();
		txtAssetPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAssetPrice.setColumns(10);
		txtAssetPrice.setBounds(132, 92, 168, 19);
		getContentPane().add(txtAssetPrice);

		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAddClick(e);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(40, 127, 85, 21);
		getContentPane().add(btnAdd);

		btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnClearClick(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear.setBounds(215, 128, 85, 21);
		getContentPane().add(btnClear);

		table = new JTable();
		table.setBounds(40, 180, 500, 157);
		getContentPane().add(table);
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public void init() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		// setLocationRelativeTo(null);
		// setVisible(true);
	}

	private void btnAddClick(MouseEvent e) {
		// System.out.println("add" + txtAssetName.getText());
		log.info("Connect DB");
	}

	private void btnClearClick(MouseEvent e) {
		txtAssetName.setText("");
		txtAssetCode.setText("");
		txtAssetPrice.setText("");
	}
}
