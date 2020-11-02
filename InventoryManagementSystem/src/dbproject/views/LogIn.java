package dbproject.views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Rectangle;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Cursor;
import java.awt.Toolkit;

public class LogIn extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUser;
	private JLabel lblSiomai;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogIn;
	private JPasswordField JPass;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnAbout;
	private JMenuItem mntmHowToUse;
	private JMenuItem mntmRegister;

	public LogIn() {
		setBackground(new Color(244, 164, 96));
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/dbproject/resources/siopao-clipart-1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Management System");
		setBounds(490, 50, 426, 503);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 306, 84, 34);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 341, 84, 34);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblPassword);
		
		lblSiomai = new JLabel("SIOMAI AND SIOPAO PRODUCTS");
		lblSiomai.setBackground(new Color(255, 255, 255));
		lblSiomai.setBorder(null);
		lblSiomai.setBounds(64, 253, 276, 50);
		lblSiomai.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblSiomai);
		
		txtUser = new JTextField();
		txtUser.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), new Color(0, 204, 255), null, null));
		txtUser.setBounds(136, 314, 216, 20);
		contentPane.add(txtUser);
		
		JPass = new JPasswordField();
		JPass.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), new Color(0, 204, 255), null, null));
		JPass.setBackground(new Color(255, 255, 255));
		JPass.setBounds(136, 349, 216, 20);
		contentPane.add(JPass);
		
		btnLogIn = new JButton("Log-in");
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.setBorderPainted(false);
		btnLogIn.setBorder(UIManager.getBorder("Button.border"));
		btnLogIn.setBackground(new Color(153, 204, 255));
		btnLogIn.setBounds(278, 380, 74, 34);
		btnLogIn.addActionListener(this);
		btnLogIn.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		contentPane.add(btnLogIn);
		
		menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.setBounds(0, 0, 410, 20);
		contentPane.add(menuBar);
		
		mnFile = new JMenu("Sign-Up");
		menuBar.add(mnFile);
		
		mntmRegister = new JMenuItem("Register");
		mnFile.add(mntmRegister);
		mntmRegister.addActionListener(this);
		
		mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);
		
		mntmHowToUse = new JMenuItem("About");
		mnAbout.add(mntmHowToUse);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LogIn.class.getResource("/dbproject/resources/siopao-clipart-1.jpg")));
		label.setBounds(41, 0, 324, 340);
		contentPane.add(label);
	}
	String sql = "";
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==btnLogIn){
	       String user = txtUser.getText();
	       String pass = JPass.getText();
	       sql = "SELECT Username, Password FROM tblAccounts WHERE Username = '" + user + "' AND Password = '" + pass + "'";
	       System.out.println(sql);
	       if(user.contains("admin")&& pass.contains("12345")){
				JOptionPane.showMessageDialog(null, "Successfully Login!");
		    	this.setVisible(false);
		    	new MainForm().setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"The Username or Password you've entered is INCORRECT.");
			}
	}
		else if(evt.getSource()== mntmRegister){
			new RegistrationForm().setVisible(true);
			this.setVisible(false);
		}
	}
}
