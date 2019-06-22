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

public class IssueBooks extends JPanel {

	private JLabel lblIssuerName, lblIssuerId, lblIssuerContactNo;
	private JLabel lblISBN;
	private JLabel lblIssueBooks;
	private JTextField tfIssuerName;
	private JTextField tfIssuerContactNo;
	private JButton btnIssueBook;
	private JLabel invalid_message;
	
	private JTextField tfISBN;
	private JTextField tfIssuerId;

	public IssueBooks() {

		setLayout(null);
		setSize(Dimen.SCREEN_WIDTH , (Dimen.SCREEN_HEIGHT - 120));
		setBackground(Color.WHITE);
		
		lblIssueBooks = new JLabel("ISSUE BOOKS");
		lblIssueBooks.setBounds(560, 50, 250, 30);
		lblIssueBooks.setFont(new Font("Tahoma" , Font.BOLD , 25));
		add(lblIssueBooks);

		
		lblISBN = new JLabel("ISBN No");
		lblISBN.setBounds(250, 150, 150, 30);
		add(lblISBN);

		tfISBN = new JTextField();
		tfISBN.setBounds(420, 150, 500, 30);
		tfISBN.setColumns(10);
		add(tfISBN);
		
		lblIssuerId = new JLabel("Issuer ID");
		lblIssuerId.setBounds(250, 190, 150, 30);
		add(lblIssuerId);

		tfIssuerId = new JTextField();
		tfIssuerId.setColumns(30);
		tfIssuerId.setBounds(420, 190 , 500, 30);
		add(tfIssuerId);
		
		
		lblIssuerName = new JLabel("Issuer Name");
		lblIssuerName.setBounds(250, 230, 150, 30);
		add(lblIssuerName);

		tfIssuerName = new JTextField();
		tfIssuerName.setBounds(420, 230, 500, 30);
		tfIssuerName.setColumns(10);
		add(tfIssuerName);
		
		lblIssuerContactNo = new JLabel("Issuer Contact No");
		lblIssuerContactNo.setBounds(250, 270, 150, 30);
		add(lblIssuerContactNo);

		tfIssuerContactNo = new JTextField();
		tfIssuerContactNo.setColumns(10);
		tfIssuerContactNo.setBounds(420, 270, 500, 30);
		add(tfIssuerContactNo);
		

		invalid_message = new JLabel("");
		invalid_message.setBounds(420, 330, 600, 15);
		add(invalid_message);

		// login credential panel
		
	
		btnIssueBook = new JButton("Issue Book" , new ImageIcon("/home/avinash/workspace/NewLibrary/images/submit.png"));
		btnIssueBook.setBounds(570 , 380 , 200 , 40);
		btnIssueBook.setBackground(new Color(230, 0, 57));
		btnIssueBook.setForeground(Color.white);
		btnIssueBook.setFocusable(false);
		btnIssueBook.setBorder(null);
		add(btnIssueBook);

		btnIssueBook.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnIssueBook.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnIssueBook.setBackground(new Color(230, 0, 57));
			}

		});
		btnIssueBook.addActionListener(new ActionListener() {

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

		if (tfIssuerName.getText().equals("") || tfIssuerId.getText().equals("") || tfIssuerContactNo.getText().equals("")|| tfISBN.getText().trim().equals("")) {

			invalid_message.setText("<HTML><FONT COLOR = RED> Please , fill the all field in personal info</FONT></HTML>");

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
			String issuerName = tfIssuerName.getText().trim();
			String issuerId = tfIssuerId.getText().trim();
			Pattern contactNoFormat = Pattern.compile("((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}");
			String contactNo = tfIssuerContactNo.getText().trim();
			Matcher m = contactNoFormat.matcher(contactNo);
			if (m.matches()) {
				
			} else  {
				invalid_message
				.setText("<HTML><FONT COLOR = RED> Please , fill the correct mobile number</FONT></HTML>");

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
			
			IssueBookInfoUpload uploadInfo = new IssueBookInfoUpload( isbn ,issuerName, issuerId, Long.parseLong(contactNo));
			if (uploadInfo.uploadInfoToDatabase()) {
				JOptionPane.showMessageDialog(null, "Book issued successfully ", "Issue Book",
					JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,"Books are not availabel", "Issue Book",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}

	private void afterSubmit_Clicked_Action_Performed() {

		tfIssuerName.setText(null);
		tfIssuerId.setText(null);
		tfIssuerContactNo.setText(null);
		tfISBN.setText(null);

	}
}
