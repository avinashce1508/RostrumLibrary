package admin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dimen.Dimen;

public class LibrarianInfoPane extends JPanel {


	private JTable table;
	private JButton btnEdit;
	protected Vector<LibrarianListAdapter> list;
	private DefaultTableModel model;
	private JLabel info_message;
	private JButton btnDelete;
	public LibrarianInfoPane() {
		setLayout(null);
		setSize((Dimen.SCREEN_WIDTH), (Dimen.SCREEN_HEIGHT-120));
		setBackground(Color.WHITE);
		//headers for the table
		String[] columns = new String[] {
				"ID", " Name"  ,"Password" ,  "Email " , "Address" ,"City", "Contact No" };


		final Class[] columnClass = new Class[] {
				Integer.class, String.class,String.class , String.class , String.class , String.class , Long.class     
		};
		//create table model with data
		model = new DefaultTableModel(null, columns) {
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return true;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex)
			{
				return columnClass[columnIndex];
			}           

		};

		table = new JTable(model);


		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(199);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(198);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);



		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 50, 1100, 400);
		add(scrollPane);
		table.setPreferredScrollableViewportSize(new Dimension((1100), (400)));

		// make the alignment of text to the center of the column

		DefaultTableCellRenderer cell_text_center_renderer = new DefaultTableCellRenderer();
		cell_text_center_renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, cell_text_center_renderer);

		// set editable 

		setLayout(null);
		setVisible(true);

		try {
			get_Librarian_Data_From_Server(); 
		}catch(Exception e) {
			e.printStackTrace();
		}

		info_message = new JLabel("");
		info_message.setText("<HTML><FONT COLOR = BLUE >* Double click on cell to edit the information</FONT></HTML>");
		info_message.setFont(new Font("Arial" , Font.BOLD , 15));
		info_message.setBounds(100, 450 , 600 , 35);
		add(info_message);

		Icon editlibrarianicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/edit.png");
		btnEdit = new JButton("Edit" , editlibrarianicon);
		btnEdit.setBounds(330, 500 , 200 , 40);
		btnEdit.setBorder(null);
		btnEdit.setFocusable(false);
		btnEdit.setBackground(new Color(230, 0, 57));
		btnEdit.setForeground(Color.WHITE);
		add(btnEdit);

		btnEdit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnEdit.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnEdit.setBackground(new Color(230, 0, 57));
			}

		}); // end of Submit button mouse listener

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnEdit_On_Click_Action_Performed();
				} catch (IOException | ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}         		
			}
		});
		Icon deletelibrarianicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/delete.png");
		btnDelete = new JButton("Delete" , deletelibrarianicon );
		btnDelete.setBounds(660, 500 , 200 , 40);
		btnDelete.setBorder(null);
		btnDelete.setFocusable(false);
		btnDelete.setBackground(new Color(230, 0, 57));
		btnDelete.setForeground(Color.WHITE);
		add(btnDelete);

		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground(new Color(230, 0, 57));
			}

		}); // end of Submit button mouse listener

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnDelete_On_Click_Action_Performed();
				} catch (IOException | ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}         		
			}
		});
	}

	public void btnEdit_On_Click_Action_Performed() throws IOException, ClassNotFoundException, SQLException {

		if(table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "<HTML><FONT COLOR = RED>No entries in the table</FONT></HTML>" ,"" ,JOptionPane.ERROR_MESSAGE);
		}else if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "<HTML><FONT COLOR = RED>please , select the record</FONT></HTML>" , "" ,JOptionPane.ERROR_MESSAGE);

		}else {

			Object id = table.getValueAt(table.getSelectedRow(), 0);
			Object name = table.getValueAt(table.getSelectedRow(), 1);
			Object password = table.getValueAt(table.getSelectedRow(), 2);
			Object email = table.getValueAt(table.getSelectedRow(), 3);
			Object address = table.getValueAt(table.getSelectedRow(), 4);
			Object city = table.getValueAt(table.getSelectedRow(), 5);
			Object contact_no = table.getValueAt(table.getSelectedRow(), 6);

			EditInfo edit_librarian_info = new EditInfo((Integer)id ,(String) name ,(String) password , (String)email , (String)address , (String)city , (Long)contact_no);

			if(edit_librarian_info.updateDataInDatabase()) {
				JOptionPane.showMessageDialog(null, "Record is successfully updated ", "Upadate", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Error in updating record ", "Update", JOptionPane.ERROR_MESSAGE);
			}

		}		 



	}

	public void btnDelete_On_Click_Action_Performed() throws IOException, ClassNotFoundException, SQLException {

		if(table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "<HTML><FONT COLOR = RED>No entries in the table</FONT></HTML>" ,"" ,JOptionPane.ERROR_MESSAGE);
		}else if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "<HTML><FONT COLOR = RED>please , select the record</FONT></HTML>" , "" ,JOptionPane.ERROR_MESSAGE);

		}else {

			Object id = table.getValueAt(table.getSelectedRow(), 0);
			DeleteRows deleteEntry = new DeleteRows((Integer)id);
			model.removeRow(table.getSelectedRow());


			if(deleteEntry.deleteRowFromDatabase()) {
				JOptionPane.showMessageDialog(null, "Record is successfully deleted ", "Delete Librarian", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Error in deleting record ", "Delete Librarian", JOptionPane.ERROR_MESSAGE);
			}


		}	
	}
	private void get_Librarian_Data_From_Server() throws ClassNotFoundException, IOException, SQLException {

		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[7];

		ArrayList<LibrarianTable> list = new ArrayList<LibrarianTable>();
		LibrarianListAdapter libAdapter = new LibrarianListAdapter();
		list = libAdapter.getDataFromDatabase();

		for(int i = 0 ; i < list.size() ; i++){	
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getPassword();
			row[3] = list.get(i).getEmail();
			row[4] = list.get(i).getAddress();
			row[5] = list.get(i).getCity();
			row[6] = list.get(i).getContactNo();
			model.addRow(row);
		}

	}
}