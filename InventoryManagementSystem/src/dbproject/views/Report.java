package dbproject.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dbproject.commons.DbConnection;
import dbproject.commons.Read;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.Cursor;

import javax.swing.border.BevelBorder;

import java.awt.Toolkit;

public class Report extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblSaveAs;
	private JLabel lblOwner;
	private JButton btnGenerateReport;
	private JButton btnBack;
	private JLabel lblCCIP;
	private JScrollPane JScrollPane;
	private JTable tblProducts;
	private DefaultTableModel tblProductsModel;
	private JLabel lblpdf;
	private JButton btnLogout;
	
	public Report() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Report.class.getResource("/dbproject/resources/siopao-clipart-1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Management System");
		setBounds(300, 50, 739, 655);;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblOwner = new JLabel("Entera's Factory");
		lblOwner.setBounds(109, 13, 114, 30);
		lblOwner.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblOwner);
		
		lblSaveAs = new JLabel("Save as:");
		lblSaveAs.setFont(new Font("Arial", Font.BOLD, 12));
		lblSaveAs.setBounds(10, 502, 60, 30);
		contentPane.add(lblSaveAs);
		
		lblCCIP = new JLabel("SIOMAI AND SIOPAO INVENTORY PRODUCTS");
		lblCCIP.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblCCIP.setBounds(257, 11, 456, 30);
		contentPane.add(lblCCIP);
		
		btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(new Color(153, 204, 204));
		btnBack.setBounds(10, 16, 89, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerateReport.setBackground(new Color(153, 204, 204));
		btnGenerateReport.setBounds(10, 555, 140, 23);
		contentPane.add(btnGenerateReport);
		btnGenerateReport.addActionListener(this);
		
		JScrollPane = new JScrollPane();
		JScrollPane.setBorder(null);
		JScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JScrollPane.setBounds(10, 50, 703, 438);
		contentPane.add(JScrollPane);
		
		tblProducts = new JTable();
		String[] ColummnNames = {
				"", "Items", "Quantity", "Pieces/Pack", "Pack", "Barcode", "Date In", "Date Out", "Expiration Date"
		};
		tblProductsModel = new DefaultTableModel(null, ColummnNames);
		tblProducts.setModel(tblProductsModel);
		tblProducts.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblProducts.getColumnModel().getColumn(1).setPreferredWidth(180);
		JScrollPane.setViewportView(tblProducts);
		tblProducts.setFont(new Font("Arial", Font.BOLD, 12));
		JScrollPane.setViewportView(tblProducts);
		
		lblpdf = new JLabel(".PDF");
		lblpdf.setBounds(72, 511, 46, 14);
		contentPane.add(lblpdf);
		
		btnLogout = new JButton("Log Out");
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBackground(new Color(153, 204, 204));
		btnLogout.setBounds(10, 582, 140, 23);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(this);
		
		conn = dbConn.connect();
		String[] strRecords = new String[9];
	    int iCounter = 0;
	      
		tblProductsModel.setRowCount(0);
	    tblProductsModel = (DefaultTableModel)tblProducts.getModel();
	    try {
	       rs = read.select(conn, "SELECT * FROM tblProducts");
	        while (rs.next()){
	        
	          strRecords[0] = ++iCounter + "";
	          strRecords[1] = rs.getString(1);
	          strRecords[2] = rs.getString(2);
	          strRecords[3] = rs.getString(3);
	          strRecords[4] = rs.getString(4);
	          strRecords[5] = rs.getString(5);
	          strRecords[6] = (new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate(6))).toString();
	          strRecords[7] = (new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate(7))).toString();
	          strRecords[8] = (new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate(8))).toString();
	          tblProductsModel.addRow(strRecords);
	        }
	      }
	      catch (Exception e){
	        e.getStackTrace();
	      }
	}
	 Document my_pdf_report = new Document();          
	 Connection conn = null;
	 ResultSet rs = null;
	 Read read = new Read();
	 DbConnection dbConn = new DbConnection();
	 Document document = new Document();
	 
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()== btnBack){
			this.setVisible(false);
			new MainForm().setVisible(true);
		}
		else if(evt.getSource() == btnGenerateReport){
			try{
				PdfWriter.getInstance(document, new FileOutputStream("Inventory Report.pdf"));
				document.open();
				
				Paragraph p;
				p = new Paragraph(16,"ANGONO NATIONAL HIGH SCHOOL \n TEAM SCORPION \n INVENTORY MANAGEMENT SYSTEM \n \n REPORT");
				p.setAlignment(Element.ALIGN_CENTER);
				p.setSpacingAfter(20);
				p.setSpacingBefore(20);
				document.add(p);
				
				Paragraph h;
				h = new Paragraph(20,"As of ____(MM) , ____(dd) , ______(yyyy) , this is the report for the update in product's record as fet'ched from the system.");
				h.setAlignment(Element.ALIGN_JUSTIFIED);
				h.setIndentationRight(20);
				h.setSpacingAfter(20);
				h.setSpacingBefore(20);
				document.add(h);
				
				PdfPTable table=new PdfPTable(8);
			       table.addCell("Items");
			       table.addCell("Quantity");
			       table.addCell("Pieces Pack");
			       table.addCell("Pack");
			       table.addCell("Barcode");
			       table.addCell("Date In");
			       table.addCell("Date Out");
			       table.addCell("Expiration Date");
			       table.setWidthPercentage(100);
			       
			       Class.forName("oracle.jdbc.driver.OracleDriver");
			       conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","12345");
			       Statement st = conn.createStatement();
			       
			       ResultSet rs=st.executeQuery("Select * from tblProducts");
			       while(rs.next()){
			           table.addCell(rs.getString("Items"));
			           table.addCell(rs.getString("Quantity"));
			           table.addCell(rs.getString("Pieces_Pack"));
			           table.addCell(rs.getString("Pack"));
			           table.addCell(rs.getString("Barcode"));
			           table.addCell(new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate("Date_In")).toString());
			           table.addCell(new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate("Date_Out")).toString());
			           table.addCell(new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate("Expiration_Date")).toString());
			           }
			       JOptionPane.showMessageDialog(null, "Successfully Generate Report");
			       document.add(table);
			       document.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(evt.getSource()==btnLogout){
	  		JOptionPane.showMessageDialog(null, "Successfully Logout");
			this.setVisible(false);
	        new LogIn().setVisible(true);
		}
	}
}