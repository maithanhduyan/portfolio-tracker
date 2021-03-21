package com.portfoliotracker.ui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.portfoliotracker.entities.Asset;
import com.portfoliotracker.services.AssetService;

@Controller
public class Window extends JFrame {

	@Autowired
	AssetService assetService;

	String[] args;

	private static final long serialVersionUID = -2668676026223241027L;
	private static final Logger log = LoggerFactory.getLogger(Window.class);
	private JTextField txtAssetName;
	private JTextField txtAssetCode;
	private JLabel lblPrice;
	private JTextField txtAssetPrice;
	private JButton btnClear;
	private JTable table;
	private JLabel lblName;
	private JLabel lblAssetCode;
	private JButton btnAdd;
	private DefaultTableModel mTableModel;

	/**
	 * Create the frame.
	 */
	@Autowired
	public Window() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				onWindowOpen(e);
			}
		});
		setTitle("Tools");
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);

		lblName = new JLabel("Asset Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(40, 23, 82, 23);
		getContentPane().add(lblName);

		txtAssetName = new JTextField();
		txtAssetName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAssetName.setBounds(132, 26, 168, 19);
		getContentPane().add(txtAssetName);
		txtAssetName.setColumns(10);

		lblAssetCode = new JLabel("Asset Code:");
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

		btnAdd = new JButton("Add");
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
		btnClear.setBounds(215, 127, 85, 21);
		getContentPane().add(btnClear);

		Object columnNames[] = { "Asset Name", "Code", "Price" };
		Object rowData[][] = { { "Asset Name", "Code", "Price" } };
		// create a table model and table based on it
		mTableModel = new DefaultTableModel(rowData, columnNames);
		table = new JTable(mTableModel);
		table.setBounds(40, 158, 500, 179);
		getContentPane().add(table);
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public void initialFrame() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		// setLocationRelativeTo(null);
		// setVisible(true);
	}

	private void btnAddClick(MouseEvent e) {
		Object[] rows;
		Asset asset = null;
		try {
			asset = new Asset();
			asset.setId(UUID.randomUUID().toString());
			asset.setName(txtAssetName.getText());
			asset.setCode(txtAssetCode.getText());
			asset.setDescription("");
			asset.setPrice(Double.parseDouble(txtAssetPrice.getText()));
			asset.setCreatedDate(new Date());
			Asset newAss = assetService.saveAsset(asset);
			rows = new Object[] { newAss.getName(),newAss.getCode(), newAss.getPrice() };
			mTableModel.addRow(rows);
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}

	}

	private void btnClearClick(MouseEvent e) {
		clearForm();
	}

	void clearForm() {
		txtAssetName.setText("");
		txtAssetCode.setText("");
		txtAssetPrice.setText("");
	}

	private void onWindowOpen(WindowEvent e) {
		log.info("Loading Asset");
		List<Asset> assets = null;
		Object[] row;
		try {
			assets = assetService.findList();
			for (int i = 0; i < assets.size(); i++) {
				row = new Object[] { assets.get(i).getName(), assets.get(i).getCode(), assets.get(i).getPrice() };
				mTableModel.addRow(row);
			}
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}
	}
}
