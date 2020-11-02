package dbproject.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtName;
	private JTextField txtEmail;
	private JLabel lblUser;
	private JLabel lblPass;
	private JLabel lblCPass;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblRegister;
	private JButton btnRegister;

	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IMS Registration Form");
		setBounds(490, 200, 426, 305);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRegister = new JLabel("Registration Form");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(121, 11, 132, 20);
		getContentPane().add(lblRegister);
		
		lblUser = new JLabel("Username :");
		lblUser.setFont(new Font("Arial", Font.BOLD, 13));
		lblUser.setBounds(27, 50, 102, 20);
		getContentPane().add(lblUser);
		
		lblPass = new JLabel("Password :");
		lblPass.setFont(new Font("Arial", Font.BOLD, 13));
		lblPass.setBounds(27, 80, 102, 22);
		getContentPane().add(lblPass);
		
		lblCPass = new JLabel("Confirm Password :");
		lblCPass.setFont(new Font("Arial", Font.BOLD, 13));
		lblCPass.setBounds(27, 115, 140, 22);
		getContentPane().add(lblCPass);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Arial", Font.BOLD, 13));
		lblName.setBounds(27, 145, 102, 22);
		getContentPane().add(lblName);

		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail.setBounds(27, 178, 102, 20);
		getContentPane().add(lblEmail);

		txtUser = new JTextField("");
		txtUser.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(135, 206, 235), new Color(0, 191, 255), null, null));
		txtUser.setBounds(161, 51, 176, 20);
		getContentPane().add(txtUser);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(135, 206, 235), new Color(0, 191, 255), null, null));
		txtPassword.setBounds(161, 82, 176, 20);
		getContentPane().add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(135, 206, 235), new Color(0, 191, 255), null, null));
		txtConfirmPassword.setBounds(161, 117, 176, 20);
		getContentPane().add(txtConfirmPassword);

		txtName = new JTextField("");
		txtName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(135, 206, 235), new Color(0, 191, 255), null, null));
		txtName.setBounds(161, 148, 176, 20);
		getContentPane().add(txtName);

		txtEmail = new JTextField("");
		txtEmail.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(135, 206, 235), new Color(0, 191, 255), null, null));
		txtEmail.setBounds(161, 179, 176, 20);
		getContentPane().add(txtEmail);

		btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(135, 206, 235));
		btnRegister.setBorder(new LineBorder(new Color(135, 206, 235)));
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 13));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(DataInfo()) {
					JOptionPane.showMessageDialog(null, "Successfully Register, You may now proceed to the Inventory Management System, Thank you!");
					new LogIn().setVisible(true);
					setVisible(false);
				}
			}
		});
		btnRegister.setBounds(161, 227, 89, 23);
		getContentPane().add(btnRegister);		

	}
	
	private boolean DataInfo() {
		
		String strUsername = txtUser.getText();
		String strPassword = new String(txtPassword.getPassword());
		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
		String strName = txtName.getText();
		String strEmail = txtEmail.getText();
		
		if(strUsername.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Input (Username)");
			txtUser.requestFocusInWindow(); 
			return false;
		}
		if(strPassword.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Input (Password)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}
		
		if(strConfirmPassword.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Input (Confirm Password)");
			txtConfirmPassword.requestFocusInWindow(); 
			return false;
		}
		if(!strPassword.equals(strConfirmPassword)) {
			JOptionPane.showMessageDialog(null,"Please Input (Password Not Match!)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}		
		if(strName.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Input (Name)");
			txtName.requestFocusInWindow(); 
			return false;
		}	
		
		if(strEmail.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Input (Email)");
			txtEmail.requestFocusInWindow(); 
			return false;
		}	
		
		Connection connect = null;
		Statement stmt = null;
		boolean Status = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","12345");

			stmt = connect.createStatement();
			
			String sql = "INSERT INTO tblAccounts " + "(Username,Password,Email,Name) " 
													+ "VALUES ('" + strUsername + "','"
													+ strPassword + "','"
													+ strEmail + "'" + ",'"
													+ strName + "') ";
			stmt.execute(sql);

			txtUser.setText("");
			txtPassword.setText("");
			txtConfirmPassword.setText("");
			txtName.setText("");
			txtEmail.setText("");
				
			Status  = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (stmt != null) {
				stmt.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return Status;

	}
}
