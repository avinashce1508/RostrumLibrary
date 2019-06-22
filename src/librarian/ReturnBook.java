package librarian;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import dimen.Dimen;

public class ReturnBook extends JPanel {
	
	private JLabel lblISBN , lblIssuerId;
	private JLabel lblReturnBook;
	private JTextField tfISBN;
	private JTextField tfIssuerId;
	private JLabel invalid_message;
	private JButton btnReturnBook;
	public ReturnBook(){
		
		setLayout(null);
		setSize(Dimen.SCREEN_WIDTH , (Dimen.SCREEN_HEIGHT - 120));
		setBackground(Color.WHITE);
		
		lblReturnBook = new JLabel("RETURN BOOKS");
		lblReturnBook.setBounds(560, 50, 250, 30);
		lblReturnBook.setFont(new Font("Tahoma" , Font.BOLD , 25));
		add(lblReturnBook);
		
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
		
	
		invalid_message = new JLabel("");
		invalid_message.setBounds(420, 330, 600, 15);
		add(invalid_message);

		// login credential panel
		
	
		btnReturnBook = new JButton("Return Book" , new ImageIcon("/home/avinash/workspace/NewLibrary/images/submit.png"));
		btnReturnBook.setBounds(570 , 300 , 200 , 40);
		btnReturnBook.setBackground(new Color(230, 0, 57));
		btnReturnBook.setForeground(Color.white);
		btnReturnBook.setFocusable(false);
		btnReturnBook.setBorder(null);
		add(btnReturnBook);

		btnReturnBook.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnReturnBook.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnReturnBook.setBackground(new Color(230, 0, 57));
			}

		});
		btnReturnBook.addActionListener(new ActionListener() {

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

		if ( tfIssuerId.getText().equals("")|| tfISBN.getText().trim().equals("")) {

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
			String issuerId = tfIssuerId.getText().trim();
			String isbn = tfISBN.getText().trim();
			ReturnBookInfoUpload uploadInfo = new ReturnBookInfoUpload( isbn , issuerId);
			if (uploadInfo.uploadInfoToDatabase()) {
				JOptionPane.showMessageDialog(null, "Book returned ", "Return Book",
					JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,"Book not returned  ", "Return Book",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	private void afterSubmit_Clicked_Action_Performed() {
		tfIssuerId.setText(null);
		tfISBN.setText(null);

	}

}
