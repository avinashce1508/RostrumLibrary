package librarian;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dimen.Dimen;

public class LibrarianMainPage extends JFrame{
	private JPanel contentPane , headerPane  , maincontentPane;
	private JButton btnHome , btnAddBooks ,btnViewallBooks , btnLogOut;
	private JLabel logo_image;
	private JButton btnViewIssuedBooks , btnIssuedBooks;
	private JButton btnReturnBook;
	public  LibrarianMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Dimen.SCREEN_WIDTH, Dimen.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setVisible(true);
		setContentPane(contentPane);

		headerPane = new JPanel();
		headerPane.setLayout(null);
		headerPane.setBounds(0 , 0 , Dimen.SCREEN_WIDTH , 100);
		headerPane.setBackground(Color.DARK_GRAY);
		contentPane.add(headerPane);

		logo_image = new JLabel("");
		logo_image.setBounds(20 , 1 , 100 , 100);
		headerPane.add(logo_image);
		logo_image.setIcon(new ImageIcon("/home/avinash/workspace/Library Management System/images/librarylogo.png"));


		//		lblHeader = new JLabel("<HTML><CENTER><B><FONT>ADMINISTRATOR</FONT></B></CENTER>	</HTML>");
		//		lblHeader.setBounds(540 , 35 , 400 , 50 );
		//		lblHeader.setFont(new Font("Arial" , Font.BOLD , 25));
		//		lblHeader.setForeground(new Color(255, 191, 0));
		//		headerPane.add(lblHeader);

		maincontentPane = new JPanel();
		maincontentPane.setLayout(null);
		maincontentPane.setBackground(Color.white);
		maincontentPane.add(new HomePane());
		maincontentPane.setBounds(0 , 100 , Dimen.SCREEN_WIDTH , Dimen.SCREEN_HEIGHT-120);
		contentPane.add(maincontentPane);

		Icon homeicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/Home.png");
		btnHome = new JButton("<HTML><CENTER><B><FONT >HOME</FONT></B></CENTER></HTML>" , homeicon);
		btnHome.setBounds(120, 25 , 100, 40);
		btnHome.setBackground(Color.DARK_GRAY);
		btnHome.setBorder(null);
		btnHome.setFocusable(false);
		btnHome.setForeground(new Color(255, 191, 0));
		headerPane.add(btnHome);

		btnHome.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnHome.setBackground(new Color(255, 191, 0));
				btnHome.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnHome.setBackground(Color.DARK_GRAY);
				btnHome.setForeground(new Color(255, 191, 0));
			}
		}); // end of Home button mouse listener

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnHome_OnClick_Action_Performed();

			}

		});// end of Home button action listener
		Icon addbookicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/addbook.png");
		btnAddBooks = new JButton("<HTML><CENTER><B><FONT >Add Book</FONT></B></CENTER></HTML>" , addbookicon);
		btnAddBooks.setBounds(230, 25 , 150, 40);
		btnAddBooks.setBorder(null);
		btnAddBooks.setBackground(Color.DARK_GRAY);
		btnAddBooks.setFocusable(false);
		btnAddBooks.setForeground(new Color(255, 191, 0));
		headerPane.add(btnAddBooks);

		btnAddBooks.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddBooks.setBackground(new Color(255, 191, 0));
				btnAddBooks.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnAddBooks.setBackground(Color.DARK_GRAY);
				btnAddBooks.setForeground(new Color(255, 191, 0));
			}

		}); // end of AddBooks button mouse listener

		btnAddBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {	
					btnAddBooks_OnClick_Action_Performed();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}

		});// end of AddBooks button action listener
		Icon viewbooks= new ImageIcon("/home/avinash/workspace/Library Management System/images/viewbooks.png");	
		btnViewallBooks = new JButton("<HTML><CENTER><B><FONT >View Books</FONT></B></CENTER></HTML>" , viewbooks);
		btnViewallBooks.setBounds(390, 25 , 150, 40);
		btnViewallBooks.setBackground(Color.DARK_GRAY);
		btnViewallBooks.setBorder(null);
		btnViewallBooks.setFocusable(false);
		btnViewallBooks.setForeground(new Color(255, 191, 0));
		headerPane.add(btnViewallBooks);

		btnViewallBooks.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnViewallBooks.setBackground(new Color(255, 191, 0));
				btnViewallBooks.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnViewallBooks.setBackground(Color.DARK_GRAY);
				btnViewallBooks.setForeground(new Color(255, 191, 0));
			}

		}); // end of ViewBooks button mouse listener

		btnViewallBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnViewAllBooks_OnClick_Action_Performed();

			}

		});// end of ViewBooks button action listener

		Icon issuebookicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/issuebook.png");
		btnIssuedBooks = new JButton("<HTML><CENTER><B><FONT >Issue Book</FONT></B></CENTER></HTML>" , issuebookicon);
		btnIssuedBooks.setBounds(550, 25 , 150, 40);
		btnIssuedBooks.setBorder(null);
		btnIssuedBooks.setBackground(Color.DARK_GRAY);
		btnIssuedBooks.setFocusable(false);
		btnIssuedBooks.setForeground(new Color(255, 191, 0));
		headerPane.add(btnIssuedBooks);

		btnIssuedBooks.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnIssuedBooks.setBackground(new Color(255, 191, 0));
				btnIssuedBooks.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnIssuedBooks.setBackground(Color.DARK_GRAY);
				btnIssuedBooks.setForeground(new Color(255, 191, 0));
			}

		}); // end of IssueBooks button mouse listener

		btnIssuedBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {	
					btnIssueBooks_OnClick_Action_Performed();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}

		});// end of IssueBooks button action listener

		Icon viewIssuedBooks = new ImageIcon("/home/avinash/workspace/Library Management System/images/viewbooks.png");	
		btnViewIssuedBooks = new JButton("<HTML><CENTER><B><FONT >View Issued Books</FONT></B></CENTER></HTML>" , viewIssuedBooks);
		btnViewIssuedBooks.setBounds(710, 25 ,200, 40);
		btnViewIssuedBooks.setBackground(Color.DARK_GRAY);
		btnViewIssuedBooks.setBorder(null);
		btnViewIssuedBooks.setFocusable(false);
		btnViewIssuedBooks.setForeground(new Color(255, 191, 0));
		headerPane.add(btnViewIssuedBooks);

		btnViewIssuedBooks.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnViewIssuedBooks.setBackground(new Color(255, 191, 0));
				btnViewIssuedBooks.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnViewIssuedBooks.setBackground(Color.DARK_GRAY);
				btnViewIssuedBooks.setForeground(new Color(255, 191, 0));
			}

		}); // end of ViewIssueBooks button mouse listener

		btnViewIssuedBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnViewIssuedBooks_OnClick_Action_Performed();

			}

		});// end of ViewIssueBooks button action listener

		Icon returnbookicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/returnbook.png");
		btnReturnBook = new JButton("<HTML><CENTER><B><FONT >Return Book</FONT></B></CENTER></HTML>" , returnbookicon);
		btnReturnBook.setBounds(920, 25 , 150, 40);
		btnReturnBook.setBorder(null);
		btnReturnBook.setBackground(Color.DARK_GRAY);
		btnReturnBook.setFocusable(false);
		btnReturnBook.setForeground(new Color(255, 191, 0));
		headerPane.add(btnReturnBook);

		btnReturnBook.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnReturnBook.setBackground(new Color(255, 191, 0));
				btnReturnBook.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnReturnBook.setBackground(Color.DARK_GRAY);
				btnReturnBook.setForeground(new Color(255, 191, 0));
			}

		}); // end of Return book button mouse listener

		btnReturnBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {	
					btnReturnBook_OnClick_Action_Performed();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}

		});// end of Return book button action listener	
		Icon logouticon = new ImageIcon("/home/avinash/workspace/Library Management System/images/Logout.png");
		btnLogOut =  new JButton("<HTML><CENTER><B><FONT>Logout</FONT></B></CENTER></HTML>" , logouticon);
		btnLogOut.setBounds(1130 , 25 , 150 , 40);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut.setForeground(new Color(255, 191, 0));
		headerPane.add(btnLogOut);

		btnLogOut.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(255, 191, 0));
				btnLogOut.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(Color.DARK_GRAY);
				btnLogOut.setForeground(new Color(255, 191, 0));
			}
		});

		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					btnLogOut_OnClicked_Action_Performed();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void btnHome_OnClick_Action_Performed() {

		maincontentPane.removeAll();
		maincontentPane.add(new HomePane());
		maincontentPane.repaint();
		maincontentPane.revalidate();

	}

	public void btnAddBooks_OnClick_Action_Performed() {
		maincontentPane.removeAll();
		maincontentPane.add(new AddBooks());
		maincontentPane.repaint();
		maincontentPane.revalidate();
	}

	public void btnViewAllBooks_OnClick_Action_Performed() {
		maincontentPane.removeAll();
		maincontentPane.add(new AllBooks());
		maincontentPane.repaint();
		maincontentPane.revalidate();
	}

	public void btnIssueBooks_OnClick_Action_Performed() {
		maincontentPane.removeAll();
		maincontentPane.add(new IssueBooks());
		maincontentPane.repaint();
		maincontentPane.revalidate();
	}

	public void btnViewIssuedBooks_OnClick_Action_Performed() {
		maincontentPane.removeAll();
		maincontentPane.add(new ViewIssuedBooks());
		maincontentPane.repaint();
		maincontentPane.revalidate();
	}
	private void btnReturnBook_OnClick_Action_Performed() {
		maincontentPane.removeAll();
		maincontentPane.add(new ReturnBook());
		maincontentPane.repaint();
		maincontentPane.revalidate();
	}
	private void btnLogOut_OnClicked_Action_Performed() throws IOException {
		dispose();
		new LibrarianLogin();
	}

}
