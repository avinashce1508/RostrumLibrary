package librarian;

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
import java.util.Date;
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

public class AllBooks extends JPanel {


	private JTable table;
	private JButton btnEdit;
	protected Vector<BookListAdapter> list;
	private DefaultTableModel model;
	private JLabel info_message;
	private JButton btnDelete;
	public AllBooks() {
		setLayout(null);
		setSize((Dimen.SCREEN_WIDTH), (Dimen.SCREEN_HEIGHT-120));
		setBackground(Color.WHITE);
		//headers for the table
		String[] columns = new String[] {
				"ID","ISBN" ,  " Book Name"  ,"Author" ,  "Publisher " , "Quantity left" ,"Issued", "Date" };


		final Class[] columnClass = new Class[] {
				Integer.class, String.class,String.class , String.class , String.class , Integer.class , Integer.class , Date.class     
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

		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(199);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(198);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(190);


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 1180, 400);
		add(scrollPane);
		table.setPreferredScrollableViewportSize(new Dimension((1180), (400)));

		// make the alignment of text to the center of the column

		DefaultTableCellRenderer cell_text_center_renderer = new DefaultTableCellRenderer();
		cell_text_center_renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, cell_text_center_renderer);

		// set editable 

		setLayout(null);
		setVisible(true);

		try {
			get_allBooks_from_database(); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Icon deletelibrarianicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/delete.png");
		btnDelete = new JButton("Delete" , deletelibrarianicon );
		btnDelete.setBounds((Dimen.SCREEN_WIDTH/2 -100), 500 , 200 , 40);
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}         		
			}

			private void btnDelete_On_Click_Action_Performed() throws  SQLException {
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
		});

	}
	private void get_allBooks_from_database() throws ClassNotFoundException, IOException, SQLException {

		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[8];

		ArrayList<BooksTable> list = new ArrayList<BooksTable>();
		BookListAdapter libAdapter = new BookListAdapter();
		list = libAdapter.getDataFromDatabase();

		for(int i = 0 ; i < list.size() ; i++){	
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getIsbn();
			row[2] = list.get(i).getBookName();
			row[3] = list.get(i).getAuthorName();
			row[4] = list.get(i).getPublisher();
			row[5] = list.get(i).getQuantity();
			row[6] = list.get(i).getIssued();
			row[7] = list.get(i).getAddedDate();
			model.addRow(row);
		}

	}
}
