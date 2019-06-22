package librarian;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dimen.Dimen;

public class ViewIssuedBooks extends JPanel {
	private JTable table;
	protected Vector<IssuedBookListAdapter> list;
	private DefaultTableModel model;
	
	public ViewIssuedBooks() {
		
		setLayout(null);
		setSize((Dimen.SCREEN_WIDTH), (Dimen.SCREEN_HEIGHT-120));
		setBackground(Color.WHITE);
		//headers for the table
		String[] columns = new String[] {
				"ID", " ISBN No"  ,"Issuer ID" ,  "Issuer Name " , "Issuer Contact No" ,"Issue Date", };


		final Class[] columnClass = new Class[] {
				Integer.class, String.class,String.class , String.class , Long.class , Date.class    
		};
		//create table model with data
		model = new DefaultTableModel(null, columns) {
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
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
		table.getColumnModel().getColumn(1).setPreferredWidth(199);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(198);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(140, 50, 1030, 500);
		add(scrollPane);
		table.setPreferredScrollableViewportSize(new Dimension((1030), (500)));

		// make the alignment of text to the center of the column

		DefaultTableCellRenderer cell_text_center_renderer = new DefaultTableCellRenderer();
		cell_text_center_renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, cell_text_center_renderer);

		// set editable 

		setLayout(null);
		setVisible(true);

		try {
			get_IssuedBooks_Data_From_Database(); 
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	private void get_IssuedBooks_Data_From_Database() throws ClassNotFoundException, IOException, SQLException {

		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[6];

		ArrayList<IssuedBooksTable> list = new ArrayList<IssuedBooksTable>();
		IssuedBookListAdapter libAdapter = new IssuedBookListAdapter();
		list = libAdapter.getDataFromDatabase();

		for(int i = 0 ; i < list.size() ; i++){	
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getIsbn();
			row[2] = list.get(i).getIssuerId();
			row[3] = list.get(i).getIssuerName();
			row[4] = list.get(i).getIssuerContactNo();
			row[5] = list.get(i).getIssueDate();
			model.addRow(row);
		}

	}
}
