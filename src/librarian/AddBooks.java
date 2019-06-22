package librarian;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import dimen.Dimen;


public class AddBooks extends JPanel {
	
	private JLabel lblBookName, lblAuthor, lblPublisher;
	private JLabel lblQuantity;
	private JLabel lblAddBooks;
	private JTextField tfBookName;
	private JTextField tfQuantity;
	private JButton btnAddBook;
	private JLabel invalid_message;
	private JLabel lblISBN;
	private JTextField tfISBN;
	private JTextField tfAuthor;
	private JTextField tfPublisher;

	public AddBooks() {

		setLayout(null);
		setSize(Dimen.SCREEN_WIDTH , (Dimen.SCREEN_HEIGHT - 120));
		setBackground(Color.WHITE);
		
		lblAddBooks = new JLabel("ADD BOOKS");
		lblAddBooks.setBounds(560, 50, 250, 30);
		lblAddBooks.setFont(new Font("Tahoma" , Font.BOLD , 25));
		add(lblAddBooks);
		
		lblISBN = new JLabel("ISBN No");
		lblISBN.setBounds(300, 150, 100, 30);
		add(lblISBN);

		tfISBN = new JTextField();
		tfISBN.setBounds(420, 150, 500, 30);
		tfISBN.setColumns(10);
		add(tfISBN);
		
		lblBookName = new JLabel("Name");
		lblBookName.setBounds(300, 200, 100, 30);
		add(lblBookName);

		tfBookName = new JTextField();
		tfBookName.setBounds(420, 200, 500, 30);
		tfBookName.setColumns(10);
		add(tfBookName);
		
		lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(300, 250, 100, 30);
		add(lblAuthor);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(30);
		tfAuthor.setBounds(420, 250, 500, 30);
		add(tfAuthor);
		
		lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(300, 300, 100, 30);
		add(lblPublisher);

		tfPublisher = new JTextField();
		tfPublisher.setColumns(30);
		tfPublisher.setBounds(420, 300, 500, 30);
		add(tfPublisher);

		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(300, 350, 100, 30);
		add(lblQuantity);

		tfQuantity = new JTextField();
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(420, 350, 500, 30);
		add(tfQuantity);

		invalid_message = new JLabel("");
		invalid_message.setBounds(420, 400, 600, 15);
		add(invalid_message);

		// login credential panel
		
	
		btnAddBook = new JButton("SUBMIT" , new ImageIcon("/home/avinash/workspace/NewLibrary/images/submit.png"));
		btnAddBook.setBounds(570 , 460 , 200 , 40);
		btnAddBook.setBackground(new Color(230, 0, 57));
		btnAddBook.setForeground(Color.white);
		btnAddBook.setFocusable(false);
		btnAddBook.setBorder(null);
		add(btnAddBook);

		btnAddBook.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddBook.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnAddBook.setBackground(new Color(230, 0, 57));
			}

		});
		btnAddBook.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					btnSubmit_OnClicked_Action_Performed();
					afterSubmit_Clicked_Action_Performed();
				} catch (IOException | ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


	}

	private void btnSubmit_OnClicked_Action_Performed() throws IOException, ClassNotFoundException, SQLException {

		if (tfBookName.getText().equals("") || tfAuthor.getText().equals("")|| tfPublisher.getText().equals("") || tfQuantity.getText().equals("")|| tfISBN.getText().trim().equals("")) {

			invalid_message.setText("<HTML><FONT COLOR = RED> Please , fill the all field in book info</FONT></HTML>");

			Timer t = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					invalid_message.setText(null);
				}
			}); // end of Timer action listener
			t.start();
			t.setRepeats(false);
			return;

		} else {
			String name = tfBookName.getText().trim();
			Pattern authorName = Pattern.compile("^[a-zA-Z]+$");
			String author = tfAuthor.getText().trim();
			Matcher m = authorName.matcher(author);
			if(m.matches()) {
				
			}else {
				invalid_message
				.setText("<HTML><FONT COLOR = RED> Author name cannot contain number  </FONT></HTML>");
				Timer t = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						invalid_message.setText(null);
					}
				}); // end of Timer action listener
				t.start();
				t.setRepeats(false);
				return;
			}
			String publisher = tfPublisher.getText().trim(); 
			int quantity = 0;
			try {
			if (Integer.parseInt(tfQuantity.getText().trim()) < 0) {
				invalid_message
				.setText("<HTML><FONT COLOR = RED> Quantity cannot be less than 0 </FONT></HTML>");

				Timer t = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						invalid_message.setText(null);
					}
				}); // end of Timer action listener
				t.start();
				t.setRepeats(false);
				return;
			} else {
				quantity = Integer.parseInt(tfQuantity.getText().trim());
			}
			}catch(NumberFormatException e) {
				invalid_message.setText("<HTML><FONT COLOR = RED> Please Enter the valid quantity </FONT></HTML>");
				Timer t = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						invalid_message.setText(null);
					}
				}); // end of Timer action listener
				t.start();
				t.setRepeats(false);
				return;
			}
			String isbn = tfISBN.getText().trim();
			
			AddBookInfoUpload uploadInfo = new AddBookInfoUpload( isbn ,name, author, publisher, quantity);
			if (uploadInfo.uploadInfoToDatabase()) {
				JOptionPane.showMessageDialog(null, "Book added successfully ", "Add Book",
					JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,"Book is not added successfully ", "Add Book",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}

	private void afterSubmit_Clicked_Action_Performed() {

		tfBookName.setText(null);
		tfAuthor.setText(null);
		tfQuantity.setText(null);
		tfPublisher.setText(null);
		tfISBN.setText(null);

	}
}