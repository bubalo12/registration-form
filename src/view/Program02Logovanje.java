package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DAO;
import model.Database;
import model.User;
import model.UserTypes;

import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JCheckBox;

public class Program02Logovanje {

	private JFrame frame;
	private JPanel panelLogin, panelAdmin, panelUser;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JLabel lblAdminPanel;
	private JLabel lblUserPanel;
	private JButton btnBack;
	private JTextField textPrezime;
	private JTextField textIme;
	private JTextField textGodiste;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textPasswordRep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program02Logovanje window = new Program02Logovanje();
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
	public Program02Logovanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 848, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_469718816096900");
		panelLogin.setLayout(null);

		JButton btnPanel = new JButton("LOGIN");
		btnPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textFieldUsername.getText().trim().toLowerCase();
				String password = textFieldPassword.getText().trim().toLowerCase();

				boolean loginOK = false;
				DAO dao = new DAO();

				User ulogovan = null;
				try {
					ulogovan = dao.selectUserByUsernameAndPassword(username, password);
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				;

				try {
					if (dao.selectUserByUsernameAndPassword(username, password) != null) {
						if (ulogovan != null) {
							if (ulogovan.getType().equals("admin")) {

								panelLogin.setVisible(false);
								panelAdmin.setVisible(true);
							} else if (ulogovan.getType().equals("user")) {
								panelLogin.setVisible(false);
								panelUser.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(frame.getContentPane(), "Doslo je do greske");
							}
						}

						// JOptionPane.showMessageDialog(frame.getContentPane(), "Pogresni parametri za
						// logovannje");
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JPanel panelRegister = new JPanel();
		frame.getContentPane().add(panelRegister, "name_2679229632010400");
		panelRegister.setLayout(null);
		btnPanel.setBounds(361, 188, 157, 25);
		panelLogin.add(btnPanel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(361, 42, 101, 16);
		panelLogin.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(361, 106, 75, 16);
		panelLogin.add(lblPassword);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(361, 69, 157, 22);
		panelLogin.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(361, 133, 157, 22);
		panelLogin.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelRegister.setVisible(true);

			}
		});
		btnRegister.setBounds(361, 224, 157, 23);
		panelLogin.add(btnRegister);

		panelAdmin = new JPanel();
		frame.getContentPane().add(panelAdmin, "name_469811282619800");
		panelAdmin.setLayout(null);

		JButton btnPanelKlik = new JButton("LOGOUT");
		btnPanelKlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelAdmin.setVisible(false);
			}
		});
		btnPanelKlik.setBounds(125, 390, 139, 25);
		panelAdmin.add(btnPanelKlik);

		lblAdminPanel = new JLabel("ADMIN PANEL");
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdminPanel.setBounds(179, 13, 387, 56);
		panelAdmin.add(lblAdminPanel);

		panelUser = new JPanel();
		frame.getContentPane().add(panelUser, "name_469909772577000");
		panelUser.setLayout(null);

		JButton btnPanelKlik_1 = new JButton("LOGOUT");
		btnPanelKlik_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelUser.setVisible(false);
			}
		});
		btnPanelKlik_1.setBounds(601, 380, 129, 25);
		panelUser.add(btnPanelKlik_1);

		lblUserPanel = new JLabel("User panel");
		lblUserPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserPanel.setBounds(197, 85, 362, 25);
		panelUser.add(lblUserPanel);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegister.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnBack.setBounds(60, 47, 89, 23);
		panelRegister.add(btnBack);

		textPrezime = new JTextField();
		textPrezime.setBounds(501, 90, 143, 20);
		panelRegister.add(textPrezime);
		textPrezime.setColumns(10);

		textIme = new JTextField();
		textIme.setBounds(501, 48, 143, 20);
		panelRegister.add(textIme);
		textIme.setColumns(10);

		textGodiste = new JTextField();
		textGodiste.setBounds(501, 141, 143, 20);
		panelRegister.add(textGodiste);
		textGodiste.setColumns(10);

		textUsername = new JTextField();
		textUsername.setBounds(501, 193, 143, 20);
		panelRegister.add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JTextField();
		textPassword.setBounds(501, 240, 143, 20);
		panelRegister.add(textPassword);
		textPassword.setColumns(10);

		textPasswordRep = new JTextField();
		textPasswordRep.setBounds(501, 286, 143, 20);
		panelRegister.add(textPasswordRep);
		textPasswordRep.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setBounds(375, 51, 89, 14);
		panelRegister.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prezime:");
		lblNewLabel_1.setBounds(375, 93, 89, 14);
		panelRegister.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Godiste:");
		lblNewLabel_2.setBounds(375, 144, 89, 14);
		panelRegister.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setBounds(375, 196, 89, 14);
		panelRegister.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(375, 243, 89, 14);
		panelRegister.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Repeat password:");
		lblNewLabel_5.setBounds(375, 289, 89, 14);
		panelRegister.add(lblNewLabel_5);

		JCheckBox chckbxNisamRobot = new JCheckBox("Nisam robot");
		chckbxNisamRobot.setBounds(493, 327, 97, 23);
		panelRegister.add(chckbxNisamRobot);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNisamRobot.isSelected()) {
					String password, passwordRep;
					password = textPassword.getText().trim();
					passwordRep = textPasswordRep.getText().trim();
					if (password.equals(passwordRep)) {
						String ime, prezime, godiste, username;
						ime = textIme.getText().trim();
						prezime = textPrezime.getText().trim();
						godiste = textGodiste.getText().trim();
						username = textUsername.getText().trim();
						if((ime!=null && !ime.isEmpty())&&(prezime!=null &&!prezime.isEmpty())&&(username!=null&& !username.isEmpty())
								&&(godiste!=null&& !godiste.isEmpty())) {
							try {
								DAO dao = new DAO();
								int g = Integer.parseInt(textGodiste.getText().trim());
								if(dao.isUsernameAvailable(username)) {
									dao.insertUser(new User(g, username, passwordRep, ime, prezime, g, username));
									JOptionPane.showMessageDialog(btnSubmit, "Registracija je uspesna!!!");
									
									
								}
								else {
									JOptionPane.showMessageDialog(btnSubmit, "Korisnicko ime je zauzeto!!!");
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(btnSubmit, "Godiste mora biti broj");
							}
							
						}
						else{
							JOptionPane.showMessageDialog(btnSubmit, "Niste uneli sve podatke");
						}

					} else {
						JOptionPane.showMessageDialog(btnSubmit, "Sifre se moraju biti identicne!!!");
					}

				} else {
					JOptionPane.showMessageDialog(btnSubmit, "Morate cekirati da niste robot!!!");
				}

			}
		});
		btnSubmit.setBounds(501, 372, 89, 23);
		panelRegister.add(btnSubmit);

	}
}
