package dbproject.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbproject.commons.Create;
import dbproject.commons.DbConnection;
import dbproject.commons.Delete;
import dbproject.commons.Read;
import dbproject.commons.Update;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Toolkit;

public class MainForm extends JFrame implements ActionListener{
	
	private JTable tblProducts;
	private JScrollPane JScrollPane;
	private JPanel contentPane;
	private JLabel lblOwnersName;
	private JLabel lblSiomaiFactory;
	private JLabel lblItems;
	private JLabel lblDateIn;
	private JLabel lblDateOut;
	private JLabel lblQuantity;
	private JLabel lblExpDate;
	private JLabel lblBarcode;
	private JLabel lblPiecespack;
	private JLabel lblPack;
	private JTextField txtBarcode;
	private JTextField txtItems;
	private JTextField txtQuantity;
	private JTextField txtPiecesPack;
	private JTextField txtPack;
	private JTextField txtIn;
	private JTextField txtExp;
	private JTextField txtOut;
	private JButton btnAddProduct;
	private JButton btnDeleteProduct;
	private JButton btnShowProduct;
	private JButton btnUpdate;
	private JButton btnGenerateReport;
	private DefaultTableModel tblProductsModel;


	public MainForm() {
		setForeground(new Color(244, 164, 96));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/dbproject/resources/siopao-clipart-1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Management System");
		setBounds(300, 50, 778, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblOwnersName = new JLabel("Entera's Factory");
		lblOwnersName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblOwnersName.setBounds(10, 11, 121, 30);
		contentPane.add(lblOwnersName);
		
		JScrollPane = new JScrollPane();
		JScrollPane.setBounds(10, 47, 742, 248);
		contentPane.add(JScrollPane);
		
		tblProducts = new JTable();
		tblProducts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				tblProductsModel = (DefaultTableModel)tblProducts.getModel();

				int iSelectedRow = tblProducts.getSelectedRow();
				String ColumnVal2 = tblProducts.getValueAt(iSelectedRow, 1).toString();
				String ColumnVal3 = tblProducts.getValueAt(iSelectedRow, 2).toString();
				String ColumnVal4 = tblProducts.getValueAt(iSelectedRow, 3).toString();
				String ColumnVal5 = tblProducts.getValueAt(iSelectedRow, 4).toString();
				String ColumnVal6 = tblProducts.getValueAt(iSelectedRow, 5).toString();
				String ColumnVal7 = tblProducts.getValueAt(iSelectedRow, 6).toString();
				String ColumnVal8 = tblProducts.getValueAt(iSelectedRow, 7).toString();
				String ColumnVal9 = tblProducts.getValueAt(iSelectedRow, 8).toString();
				
			    tblProductsModel.getValueAt(tblProducts.getSelectedRow(),0);

				txtItems.setText(ColumnVal2);
				txtQuantity.setText(ColumnVal3);
				txtPiecesPack.setText(ColumnVal4);
				txtPack.setText(ColumnVal5);
				txtBarcode.setText(ColumnVal6);
				txtIn.setText(ColumnVal7);
				txtOut.setText(ColumnVal8);
				txtExp.setText(ColumnVal9);
			}
		});
		String[] ColummnNames = {
				"", "Items", "Quantity", "Pieces/Pack", "Pack", "Barcode", "Date In", "Date Out", "Expiration Date"
		};
		tblProductsModel = new DefaultTableModel(null, ColummnNames);
		tblProducts.setModel(tblProductsModel);
		tblProducts.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblProducts.getColumnModel().getColumn(1).setPreferredWidth(180);
		JScrollPane.setViewportView(tblProducts);
		tblProducts.setFont(new Font("Arial", Font.BOLD, 12));
		
		lblItems = new JLabel("Items:");
		lblItems.setForeground(new Color(0, 0, 0));
		lblItems.setBackground(new Color(255, 255, 255));
		lblItems.setFont(new Font("Arial", Font.BOLD, 12));
		lblItems.setBounds(10, 314, 58, 23);
		contentPane.add(lblItems);
		
		txtItems = new JTextField();
		txtItems.setBounds(112, 316, 200, 20);
		contentPane.add(txtItems);
		txtItems.setColumns(2);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(SystemColor.desktop);
		lblQuantity.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuantity.setBounds(10, 345, 85, 23);
		contentPane.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(112, 347, 200, 20);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(3);
		
		lblPiecespack = new JLabel("Pieces/Pack:");
		lblPiecespack.setForeground(SystemColor.desktop);
		lblPiecespack.setFont(new Font("Arial", Font.BOLD, 12));
		lblPiecespack.setBounds(10, 379, 85, 14);
		contentPane.add(lblPiecespack);
		
		txtPiecesPack = new JTextField();
		txtPiecesPack.setBounds(112, 377, 200, 20);
		contentPane.add(txtPiecesPack);
		txtPiecesPack.setColumns(4);
		
		lblPack = new JLabel("Pack:");
		lblPack.setForeground(SystemColor.desktop);
		lblPack.setFont(new Font("Arial", Font.BOLD, 12));
		lblPack.setBounds(10, 414, 46, 14);
		contentPane.add(lblPack);
		
		txtPack = new JTextField();
		txtPack.setBounds(112, 410, 200, 20);
		contentPane.add(txtPack);
		txtPack.setColumns(5);
		
		lblBarcode = new JLabel("Barcode:");
		lblBarcode.setForeground(SystemColor.desktop);
		lblBarcode.setFont(new Font("Arial", Font.BOLD, 12));
		lblBarcode.setBounds(10, 439, 58, 23);
		contentPane.add(lblBarcode);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(112, 441, 200, 20);
		contentPane.add(txtBarcode);
		txtBarcode.setColumns(6);
		
		lblDateIn = new JLabel("Date In:");
		lblDateIn.setForeground(SystemColor.desktop);
		lblDateIn.setFont(new Font("Arial", Font.BOLD, 12));
		lblDateIn.setBounds(10, 473, 68, 23);
		contentPane.add(lblDateIn);
		
		txtIn = new JTextField();
		txtIn.setBounds(112, 475, 200, 20);
		contentPane.add(txtIn);
		txtIn.setColumns(7);
		
		lblDateOut = new JLabel("Date Out:");
		lblDateOut.setForeground(SystemColor.desktop);
		lblDateOut.setFont(new Font("Arial", Font.BOLD, 12));
		lblDateOut.setBounds(10, 506, 68, 20);
		contentPane.add(lblDateOut);
		
		txtOut = new JTextField();
		txtOut.setBounds(112, 507, 200, 20);
		contentPane.add(txtOut);
		txtOut.setColumns(8);
		
		lblExpDate = new JLabel("Exp. Date:");
		lblExpDate.setForeground(SystemColor.desktop);
		lblExpDate.setFont(new Font("Arial", Font.BOLD, 12));
		lblExpDate.setBounds(10, 537, 68, 20);
		contentPane.add(lblExpDate);
		
		txtExp = new JTextField();
		txtExp.setBounds(112, 538, 200, 20);
		contentPane.add(txtExp);
		txtExp.setColumns(9);
		
		btnAddProduct = new JButton("Add Product");
		btnAddProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddProduct.setBackground(new Color(204, 204, 255));
		btnAddProduct.setBounds(600, 388, 139, 23);
		contentPane.add(btnAddProduct);
		btnAddProduct.addActionListener(this);
		
		btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteProduct.setBackground(new Color(204, 204, 255));
		btnDeleteProduct.setBounds(600, 422, 139, 23);
		contentPane.add(btnDeleteProduct);
		btnDeleteProduct.addActionListener(this);
		
		btnShowProduct = new JButton("Show Product");
		btnShowProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowProduct.setBackground(new Color(204, 204, 255));
		btnShowProduct.setBounds(600, 490, 139, 23);
		contentPane.add(btnShowProduct);
		btnShowProduct.addActionListener(this);
		
		btnUpdate = new JButton("Update Product");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBackground(new Color(204, 204, 255));
		btnUpdate.setBounds(600, 456, 139, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnGenerateReport = new JButton("Report");
		btnGenerateReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerateReport.setBackground(new Color(204, 204, 255));
		btnGenerateReport.setBounds(600, 524, 139, 23);
		contentPane.add(btnGenerateReport);
		btnGenerateReport.addActionListener(this);
		
		lblSiomaiFactory = new JLabel("SIOMAI AND SIOPAO INVENTORY PRODUCTS");
		lblSiomaiFactory.setForeground(new Color(0, 0, 0));
		lblSiomaiFactory.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblSiomaiFactory.setBounds(259, 11, 448, 30);
		contentPane.add(lblSiomaiFactory);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(MainForm.class.getResource("/dbproject/resources/golden siomai cebu philippines chicken beef japanese dumplings siopao chili sauce-0346.jpg")));
		label.setBounds(0, 0, 762, 571);
		contentPane.add(label);
	
	}
	
	  DbConnection dbConn = new DbConnection();
	  Read read = new Read();
	  Connection conn = null;
	  ResultSet rs = null;
	  String sql = "";
	  Create create = new Create();
	  Delete delete = new Delete();
	  Update update = new Update();
	  private JLabel label;
	  
	  public void actionPerformed(ActionEvent evt) {
		   if(evt.getSource()== btnShowProduct){
			  showproduct();
		  	}
			if(evt.getSource()==btnAddProduct){
				sql = "INSERT INTO tblProducts VALUES('" +
						txtItems.getText() + "', '" +
						txtQuantity.getText() + "', '" +
						txtPiecesPack.getText() + "', '" +
						txtPack.getText() + "', '" +
						txtBarcode.getText() + "', " +
						"TO_DATE('" + txtIn.getText() +  "', 'mm/dd/yyyy'), " +
						"TO_DATE('"	+ txtOut.getText() + "', 'mm/dd/yyyy'), " +
						"TO_DATE('"	+ txtExp.getText() +  "', 'mm/dd/yyyy'))";
				System.out.println("sql: " + sql);
				if(create.insert(conn, sql)>0)
					JOptionPane.showMessageDialog(null, "Successfully added!");
				else
					JOptionPane.showMessageDialog(null, "Error in adding record.....");
				showproduct();
			}
			else if(evt.getSource()==btnDeleteProduct){
				if(JOptionPane.showConfirmDialog(null, "Do you really want to delete the record of Items?", " ", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			sql = "Delete From tblProducts Where Items = '" + txtItems.getText() + "'";
				System.out.println("sql: " + sql);
				if(delete.delete(conn, sql)>0)
					JOptionPane.showMessageDialog(null,"Sucessfully deleted!");
				else
					JOptionPane.showMessageDialog(null, "Error in deleting record.....");
				showproduct();
				}
			}
			else if(evt.getSource()==btnUpdate){
				sql="UPDATE tblProducts SET Quantity = '"+ txtQuantity.getText() + 
						"',Pieces_Pack = '"+ txtPiecesPack.getText() +
						"',Pack = '"+ txtPack.getText() +
						"' ,Barcode = '"+ txtBarcode.getText() + "'" + ",Date_In = " +
						"TO_DATE('" + txtIn.getText() +  "', 'mm/dd/yyyy'), " + "Date_Out = " +
						"TO_DATE('" + txtOut.getText() + "', 'mm/dd/yyyy'), " + "Expiration_Date = " +
						"TO_DATE('" + txtExp.getText() +  "', 'mm/dd/yyyy')" + " Where Items = '" + txtItems.getText() + "'";
				System.out.println("sql: " + sql);
				if(update.update(conn, sql)>0)
					JOptionPane.showMessageDialog(null, "Successfully updated!");
				else
					JOptionPane.showMessageDialog(null, "Error in updating record.....");
				showproduct();
				}
			else if(evt.getSource()==btnGenerateReport){
				this.setVisible(false);
				new Report().setVisible(true);
			}
		}
	private void showproduct() {
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
}
