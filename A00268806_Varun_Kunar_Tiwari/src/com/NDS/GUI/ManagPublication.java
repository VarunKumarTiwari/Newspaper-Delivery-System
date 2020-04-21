package com.NDS.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.NDS.AutoID.IDGenerater;
import com.NDS.Data.PubDao;
import com.NDS.Validate.validation;
import com.NDS.Data.Data;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JPanel;

public class ManagPublication {

	JFrame frame;
	private JTextField amount;
	private JTextField name;
	private JTextField price;
	private JTable table;
	// private TableFillData tfd = new TableFillData();
	private int id_;
	private IDGenerater idGen = new IDGenerater();
	private JTextField delete;
	private JTextField update;
	private validation val = new validation();
	// private static Data fill;
	// private BDonorDao dao = new BDonorDao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagPublication window = new ManagPublication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagPublication() {
		initialize();

	}

	public static TableModel fillTable() {
		List<Data> fill = PubDao.INSTANCE.display();
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Pub. ID", "Name", "Frequecny", "Amount", "Price" }, 0);
		for (Data x : fill) {
			model.addRow(new Object[] { x.getId(), x.getName(), x.getFrequecny(), x.getAmount(), x.getPrice() });
		}

		return model;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Donor Detail Form");
		frame.setBounds(100, 100, 796, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDonorName_1 = new JLabel("Publication Name");
		lblDonorName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDonorName_1.setBounds(23, 187, 119, 14);
		frame.getContentPane().add(lblDonorName_1);

		JLabel lblBloodGroup = new JLabel("Amount");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloodGroup.setBounds(23, 227, 86, 14);
		frame.getContentPane().add(lblBloodGroup);

		JLabel lblSex = new JLabel("Release Frequency");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(23, 269, 126, 14);
		frame.getContentPane().add(lblSex);

		JComboBox frequency = new JComboBox();
		frequency.setFont(new Font("Tahoma", Font.BOLD, 11));
		frequency.setModel(
				new DefaultComboBoxModel(new String[] { "Select Frequency", "Yearly", "Monthly", "Weekly", "Daily" }));
		frequency.setBounds(159, 265, 132, 22);
		frame.getContentPane().add(frequency);

		JLabel lblAge = new JLabel("Price\r\n");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(23, 314, 86, 14);
		frame.getContentPane().add(lblAge);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(21, 140, 46, 14);
		frame.getContentPane().add(lblDate);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int Id = idGen.autoIDGenerate();
				
				String Name = name.getText();
				String Amount = amount.getText();
				String Frequency = frequency.getSelectedItem().toString();
				String Price = price.getText();
				boolean flag = true;
				
				if (val.checkEmptyInput(Name, Amount, Frequency, Price) == false) {
					JOptionPane.showMessageDialog(null, "Input can not be Empty");
					flag = false;
				}
				
				if (val.checkInputValid(Amount, Price) == false) {

					JOptionPane.showMessageDialog(null, "Invalid Input");
					flag = false;
				}
				if (val.checkOnlyNevSign(Amount, Price) == false) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					flag = false;
				}

				if (flag) {

					int Amountnew = Integer.parseInt(Amount);

					int Pricenew = Integer.parseInt(Price);

					Data data = new Data();
					data.setId(Id);
					data.setName(Name);
					data.setAmount(Amountnew);
					data.setFrequecny(Frequency);
					data.setPrice(Pricenew);
					PubDao.INSTANCE.create(data);
					table.setModel(fillTable());
				}

			}
		});
		btnAdd.setBounds(99, 371, 89, 23);
		frame.getContentPane().add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 21, 442, 307);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(fillTable());
		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		JLabel label = new JLabel(formatter.format(date));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(65, 140, 77, 14);
		frame.getContentPane().add(label);

		amount = new JTextField();
		amount.setBounds(159, 224, 132, 20);
		frame.getContentPane().add(amount);
		amount.setColumns(10);

		name = new JTextField();
		name.setBounds(159, 184, 132, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		price = new JTextField();
		price.setBounds(159, 311, 132, 20);
		frame.getContentPane().add(price);
		price.setColumns(10);

		JButton btnCancel = new JButton("EXIT");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				NavigationWindow b = new NavigationWindow();
				b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(681, 414, 89, 23);
		frame.getContentPane().add(btnCancel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(328, 339, 341, 43);
		frame.getContentPane().add(panel_1);

		JLabel lblUpdateById = new JLabel("Update by ID");
		lblUpdateById.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUpdateById.setBounds(10, 15, 86, 14);
		panel_1.add(lblUpdateById);

		update = new JTextField();
		update.setColumns(10);
		update.setBounds(95, 12, 139, 20);
		panel_1.add(update);

		JButton button = new JButton("UPDATE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String Update2 = update.getText();
				String Amount = amount.getText();
				String Frequency = frequency.getSelectedItem().toString();
				String Price = price.getText();
				String Name = name.getText();
				boolean flag = true;

				if (val.checkUpdateEmptyInput(Update2,Name, Amount, Frequency, Price) == false) {
					JOptionPane.showMessageDialog(null, "Input can not be Empty");
					flag = false;
				}else {
				if (val.checkOnlyNevSignUp(Update2,Amount, Price) == false) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					flag = false;
				}
				if (val.checkInputValidUp(Update2,Amount, Price) == false) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					flag = false;
				}
				}
				if (flag) {

					int Amountnew = Integer.parseInt(Amount);
					int Update = Integer.parseInt(Update2);
					int Pricenew = Integer.parseInt(Price);

					if (PubDao.INSTANCE.ifExist(Update)) {

						Data data = new Data();
						data.setId(Update);
						data.setName(Name);
						data.setAmount(Amountnew);
						data.setFrequecny(Frequency);
						data.setPrice(Pricenew);
						PubDao.INSTANCE.update(data);
						table.setModel(fillTable());
						JOptionPane.showMessageDialog(null, "Updated Successfully");
					} else {
						JOptionPane.showMessageDialog(null, "Entered ID does not exist");
					}
				
				

				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(244, 11, 89, 23);
		panel_1.add(button);

		JPanel panel = new JPanel();
		panel.setBounds(330, 394, 341, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(242, 11, 89, 23);
		panel.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDeleteById = new JLabel("Delete by ID");
		lblDeleteById.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeleteById.setBounds(10, 15, 86, 14);
		panel.add(lblDeleteById);

		delete = new JTextField();
		delete.setBounds(93, 12, 139, 20);
		panel.add(delete);
		delete.setColumns(10);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete2 = delete.getText();
				boolean flage = true;
				if(val.deleteInputEmpty(delete2)==false)
				{
					JOptionPane.showMessageDialog(null, "ID is empty while deleting");
					flage=  false;
				}
				else {
				if(val.deleteInvalideEmpty(delete2)==false)
				{
					JOptionPane.showMessageDialog(null, "ID should be number");
					flage=  false;
				}
				}
				if(flage==true)
				{
				int Delete = Integer.parseInt(delete2);
				if (PubDao.INSTANCE.ifExist(Delete)) {
					PubDao.INSTANCE.delete(Delete);
					table.setModel(fillTable());
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Entered ID does not exist");
				}
				}
			}
		});

		JLabel lblManage = new JLabel("Manage");
		lblManage.setForeground(new Color(107, 142, 35));
		lblManage.setFont(new Font("Nirmala UI", Font.BOLD, 27));
		lblManage.setBounds(167, 9, 117, 37);
		frame.getContentPane().add(lblManage);

		JLabel lblPublication = new JLabel("Publication");
		lblPublication.setForeground(new Color(107, 142, 35));
		lblPublication.setFont(new Font("Nirmala UI", Font.BOLD, 27));
		lblPublication.setBounds(149, 53, 156, 37);
		frame.getContentPane().add(lblPublication);

		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("ireland.png")).getImage()
				.getScaledInstance(123, 99, Image.SCALE_SMOOTH)));

		lblbloodIcon.setBounds(19, 9, 123, 99);
		frame.getContentPane().add(lblbloodIcon);

		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 780, 448);
		frame.getContentPane().add(lblbackground);

	}
}
