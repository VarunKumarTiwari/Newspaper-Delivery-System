package com.NDS.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NavigationWindow  {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public NavigationWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Blood Donation");
		frame.setBounds(100, 100, 647, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBloodDonation = new JLabel("Newspaper Delivery");
		lblBloodDonation.setFont(new Font("Nirmala UI", Font.BOLD, 27));
		lblBloodDonation.setForeground(new Color(107, 142, 35));
		lblBloodDonation.setBounds(28, 28, 279, 37);
		frame.getContentPane().add(lblBloodDonation);
		
		JButton btnBloodDonor = new JButton("Clint for HSQL");
		btnBloodDonor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBloodDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        ManagPublication b = new ManagPublication();
		        b.frame.setVisible(true);
			}
		});
		btnBloodDonor.setBounds(67, 91, 123, 37);
		frame.getContentPane().add(btnBloodDonor);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Search_Select b = new Search_Select();
		        b.frame.setVisible(true);
			}
		});
		btnSearch.setBounds(67, 235, 123, 37);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExportD = new JButton("Export Details");
		btnExportD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
		        Export b = new Export();
		        b.frame.setVisible(true);
			}
		});
		btnExportD.setBounds(67, 299, 123, 37);
		frame.getContentPane().add(btnExportD);
		
		JButton btnClintOfRest = new JButton("Clint for REST");
		btnClintOfRest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClintOfRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnClintOfRest.setBounds(67, 162, 123, 37);
		frame.getContentPane().add(btnClintOfRest);
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("icons.png")).getImage().getScaledInstance(327, 323, Image.SCALE_SMOOTH)));
		//	lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("news.png")).getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)));
			lblbloodIcon.setBounds(264, 11, 327, 343);
			frame.getContentPane().add(lblbloodIcon);
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblNewLabel.setBounds(0, 0, 631, 365);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}
