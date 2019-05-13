package user.login.success;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import user.login.controller.LoginController;
import user.login.lecturer.Contract;
import user.login.lecturer.FullTime;
import user.login.lecturer.Lecturer;
import user.login.lecturer.PartTime;
import user.login.model.LoginModel;
import user.login.view.LoginView;

public class DepartmentHome extends JFrame {
	private JLabel lblUsername;
	private JPanel homePanel;
	private JPanel firstPanel;
	private JLabel departmentName;
	private JLabel departmentType;
	private JLabel userName;
	private JTextField searchTxt;
	private JPanel allLecPanel;
	private JTable allLecTable;
	public DefaultTableModel allLecModel;
	private JTable fullTimeLecTable;
	public DefaultTableModel fullTimeLecModel;
	private JPanel fullTimePanel;
	private JPanel partTimePanel;
	private JTable partTimeTable;
	private JTable contractTable;
	private DefaultTableModel partTimeLecModel;
	private DefaultTableModel contractLecModel;
	private JComboBox searchItem;
	private JButton searchBtn;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	private JPanel searchPanel;
	private JTable searchTable;
	public DefaultTableModel searchModel;
	private JPanel contractPanel;

	public DepartmentHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Home");
		setSize(1000, 699);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);

		JMenu mnFile = new JMenu("File");
		menu.add(mnFile);

		JMenuItem mntmHome = new JMenuItem("Home");
		mnFile.add(mntmHome);

		JMenuItem mntmMyDepartment = new JMenuItem("My Department");
		mnFile.add(mntmMyDepartment);

		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirm",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == 0) {
					dispose();
					LoginView view = new LoginView();
					view.setVisible(true);
					LoginModel model = new LoginModel();
					LoginController control = new LoginController(view, model);
				}
			}
		});
		mnFile.add(logoutMenuItem);

		JPanel home = new JPanel();
		getContentPane().add(home);
		home.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Bell MT", Font.PLAIN, 30));
		lblWelcome.setBounds(218, 11, 129, 61);
		home.add(lblWelcome);

		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Bell MT", Font.PLAIN, 30));
		lblUsername.setBounds(357, 11, 129, 61);
		home.add(lblUsername);

		homePanel = new JPanel();
		homePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		homePanel.setBounds(10, 115, 964, 513);
		home.add(homePanel);
		homePanel.setLayout(new CardLayout(0, 0));

		firstPanel = new JPanel();
		homePanel.add(firstPanel, "name_713349903665249");
		firstPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DepartmentHome.class.getResource("/Image/avatar.png")));
		lblNewLabel.setBounds(10, 11, 202, 258);
		firstPanel.add(lblNewLabel);

		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setFont(new Font("Bell MT", Font.PLAIN, 17));
		lblUserName.setBounds(222, 11, 89, 29);
		firstPanel.add(lblUserName);

		userName = new JLabel("");
		userName.setFont(new Font("Bell MT", Font.PLAIN, 17));
		userName.setBounds(321, 11, 146, 29);
		firstPanel.add(userName);

		JLabel lblDepTitle = new JLabel("Title:");
		lblDepTitle.setFont(new Font("Bell MT", Font.PLAIN, 17));
		lblDepTitle.setBounds(222, 52, 89, 29);
		firstPanel.add(lblDepTitle);

		departmentName = new JLabel("");
		departmentName.setFont(new Font("Bell MT", Font.PLAIN, 17));
		departmentName.setBounds(321, 51, 146, 29);
		firstPanel.add(departmentName);

		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Bell MT", Font.PLAIN, 17));
		lblType.setBounds(222, 92, 89, 29);
		firstPanel.add(lblType);

		departmentType = new JLabel("");
		departmentType.setFont(new Font("Bell MT", Font.PLAIN, 17));
		departmentType.setBounds(321, 92, 146, 29);
		firstPanel.add(departmentType);

		allLecPanel = new JPanel();
		allLecPanel.setVisible(false);
		homePanel.add(allLecPanel);

		Object[] allColumns = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department" };
		allLecModel = new DefaultTableModel();
		allLecModel.setColumnIdentifiers(allColumns);

		allLecTable = new JTable();
		allLecTable.setModel(allLecModel);

		allLecTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		allLecTable.setBackground(Color.LIGHT_GRAY);
		allLecTable.setForeground(Color.black);
		allLecTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		allLecTable.setRowHeight(30);
		allLecTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		allLecTable.getColumnModel().getColumn(1).setMinWidth(120);
		allLecTable.getColumnModel().getColumn(3).setMinWidth(160);
		allLecTable.getColumnModel().getColumn(4).setMinWidth(220);
		allLecTable.getColumnModel().getColumn(5).setMinWidth(160);
		allLecTable.getColumnModel().getColumn(6).setMinWidth(200);
		allLecPanel.setLayout(null);

		JScrollPane allLecPane = new JScrollPane(allLecTable);
		allLecPane.setBounds(10, 11, 944, 487);

		allLecPanel.add(allLecPane);

		fullTimePanel = new JPanel();
		homePanel.add(fullTimePanel);

		Object[] fullTimeColumns = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Salary" };
		fullTimeLecModel = new DefaultTableModel();
		fullTimeLecModel.setColumnIdentifiers(fullTimeColumns);

		fullTimeLecTable = new JTable(fullTimeLecModel);
		fullTimeLecTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		fullTimeLecTable.setBackground(Color.LIGHT_GRAY);
		fullTimeLecTable.setForeground(Color.black);
		fullTimeLecTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		fullTimeLecTable.setRowHeight(30);
		fullTimeLecTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		fullTimeLecTable.getColumnModel().getColumn(3).setMinWidth(180);
		fullTimeLecTable.getColumnModel().getColumn(4).setMinWidth(250);
		fullTimeLecTable.getColumnModel().getColumn(5).setMinWidth(160);
		fullTimeLecTable.getColumnModel().getColumn(6).setMinWidth(190);
		fullTimePanel.setLayout(null);

		JScrollPane fullTimePane = new JScrollPane(fullTimeLecTable);
		fullTimePane.setBounds(10, 5, 940, 493);
		fullTimePanel.add(fullTimePane);

		partTimePanel = new JPanel();
		homePanel.add(partTimePanel);

		Object[] partTimeColumns = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Pay rate" };
		partTimeLecModel = new DefaultTableModel();
		partTimeLecModel.setColumnIdentifiers(partTimeColumns);

		partTimeTable = new JTable(partTimeLecModel);
		partTimeTable.setBackground(Color.LIGHT_GRAY);
		partTimeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		partTimeTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		partTimeTable.setRowHeight(30);
		partTimeTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		partTimeTable.getColumnModel().getColumn(3).setMinWidth(160);
		partTimeTable.getColumnModel().getColumn(4).setMinWidth(220);
		partTimeTable.getColumnModel().getColumn(5).setMinWidth(160);
		partTimeTable.getColumnModel().getColumn(6).setMinWidth(150);
		partTimePanel.setLayout(null);

		JScrollPane partTimePane = new JScrollPane(partTimeTable);
		partTimePane.setBounds(10, 5, 940, 493);
		partTimePanel.add(partTimePane);

		contractPanel = new JPanel();
		homePanel.add(contractPanel);

		Object[] contractColumn = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Salary",
				"Contract Expiry" };
		contractLecModel = new DefaultTableModel();
		contractLecModel.setColumnIdentifiers(contractColumn);

		contractTable = new JTable(contractLecModel);
		contractTable.setBackground(Color.LIGHT_GRAY);
		contractTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		contractTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		contractTable.setRowHeight(30);
		contractTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		contractTable.getColumnModel().getColumn(3).setMinWidth(160);
		contractTable.getColumnModel().getColumn(4).setMinWidth(170);
		contractTable.getColumnModel().getColumn(5).setMinWidth(130);
		contractTable.getColumnModel().getColumn(6).setMinWidth(120);
		contractTable.getColumnModel().getColumn(7).setMinWidth(130);
		contractTable.getColumnModel().getColumn(8).setMinWidth(140);
		contractPanel.setLayout(null);

		JScrollPane contracPane = new JScrollPane(contractTable);
		contracPane.setBounds(10, 5, 940, 493);

		contractPanel.add(contracPane);

		searchPanel = new JPanel();
		homePanel.add(searchPanel);

		Object[] searchColums = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Type" };

		searchModel = new DefaultTableModel();
		searchModel.setColumnIdentifiers(searchColums);

		searchTable = new JTable();
		searchTable.setModel(searchModel);
		searchTable.setBackground(Color.LIGHT_GRAY);
		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		searchTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		searchTable.setRowHeight(30);
		searchTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		searchTable.getColumnModel().getColumn(3).setMinWidth(160);
		searchTable.getColumnModel().getColumn(4).setMinWidth(180);
		searchTable.getColumnModel().getColumn(5).setMinWidth(140);
		searchTable.getColumnModel().getColumn(6).setMinWidth(150);
		searchTable.getColumnModel().getColumn(7).setMinWidth(140);
		searchPanel.setLayout(null);

		JScrollPane searchPane = new JScrollPane(searchTable);
		searchPane.setBounds(10, 5, 940, 493);

		searchPanel.add(searchPane);

		JLabel lblMyDepartment = new JLabel("My Department");
		lblMyDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMyDepartment.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblMyDepartment.setBounds(10, 72, 146, 23);
		lblMyDepartment.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				firstPanel.setVisible(true);
				allLecPanel.setVisible(false);
				partTimePanel.setVisible(false);
				fullTimePanel.setVisible(false);
				contractPanel.setVisible(false);
				searchPanel.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {

			}
		});
		home.add(lblMyDepartment);

		JLabel lblLecturers = new JLabel("Lecturers");
		lblLecturers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLecturers.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblLecturers.setBounds(199, 72, 93, 23);
		lblLecturers.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				allLecPanel.setVisible(true);
				firstPanel.setVisible(false);
				partTimePanel.setVisible(false);
				fullTimePanel.setVisible(false);
				contractPanel.setVisible(false);
				searchPanel.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		home.add(lblLecturers);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 102, 964, 2);
		home.add(separator);

		JLabel lblFullTime = new JLabel("Full Time");
		lblFullTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFullTime.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblFullTime.setBounds(340, 72, 93, 23);
		lblFullTime.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				fullTimePanel.setVisible(true);
				firstPanel.setVisible(false);
				allLecPanel.setVisible(false);
				partTimePanel.setVisible(false);
				contractPanel.setVisible(false);
				searchPanel.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {

			}
		});
		home.add(lblFullTime);

		JLabel lblPartTime = new JLabel("Part Time");
		lblPartTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPartTime.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblPartTime.setBounds(488, 72, 93, 23);
		lblPartTime.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				partTimePanel.setVisible(true);
				firstPanel.setVisible(false);
				allLecPanel.setVisible(false);
				fullTimePanel.setVisible(false);
				contractPanel.setVisible(false);
				searchPanel.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {

			}
		});
		home.add(lblPartTime);

		JLabel lblContract = new JLabel("Contract");
		lblContract.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblContract.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblContract.setBounds(630, 72, 93, 23);
		lblContract.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				contractPanel.setVisible(true);
				firstPanel.setVisible(false);
				allLecPanel.setVisible(false);
				partTimePanel.setVisible(false);
				fullTimePanel.setVisible(false);
				searchPanel.setVisible(false);

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		home.add(lblContract);

		searchTxt = new JTextField();
		searchTxt.setBounds(729, 75, 129, 20);
		home.add(searchTxt);
		searchTxt.setColumns(10);
		setVisible(true);

		searchItem = new JComboBox();
		searchItem.setModel(new DefaultComboBoxModel<String>(new String[] { "ID", "Name", "Address", "Email" }));
		searchItem.setBounds(860, 75, 64, 20);
		home.add(searchItem);

		searchBtn = new JButton("");
		searchBtn.setIcon(new ImageIcon(DepartmentHome.class.getResource("/Image/Capture.PNG")));
		searchBtn.setBounds(934, 72, 34, 23);
		home.add(searchBtn);
	}

	public void setUserName(String username) {
		lblUsername.setText(username);
		userName.setText(username);
	}

	public String getUserName() {
		return userName.getText();
	}

	public void setDepName(String dep) {
		departmentName.setText(dep);
	}

	public void setDepType(String type) {
		departmentType.setText(type);
	}

	public void setAllRecords(ArrayList<Lecturer> l) {

		for (Lecturer lecturer : l) {
			if (lecturer instanceof FullTime) {
				fullTimeLecModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
						lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
						lecturer.getDepartment(), ((FullTime) lecturer).getSalary() });
			} else if (lecturer instanceof PartTime) {
				partTimeLecModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
						lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
						lecturer.getDepartment(), ((PartTime) lecturer).getPayRate() });
			} else if (lecturer instanceof Contract) {
				contractLecModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
						lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
						lecturer.getDepartment(), ((Contract) lecturer).getSalary(),
						sdf.format(((Contract) lecturer).getEndDate()) });
			}
			allLecModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
					lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
					lecturer.getDepartment() });

		}
	}

	public void addSearch(ActionListener acl) {
		searchBtn.addActionListener(acl);
	}

	public String getSearchCriteria() {
		return searchItem.getSelectedItem().toString();
	}

	public String getSearchItem() throws NumberFormatException {
		return searchTxt.getText();
	}

	public int getSearchRow()
	{
		return searchModel.getRowCount();
	}
	public void setSearchResults(ArrayList<Lecturer> lecturer) {
		searchPanel.setVisible(true);
		firstPanel.setVisible(false);
		allLecPanel.setVisible(false);
		partTimePanel.setVisible(false);
		fullTimePanel.setVisible(false);
		contractPanel.setVisible(false);
		String type = "";
		
		for (Lecturer l : lecturer) {
				if (l instanceof FullTime) {
					type = "Full time";
				} else if (l instanceof PartTime) {
					type = "Part Time";
				} else {
					type = "Contract";
				}
				searchModel.addRow(new Object[] { l.getID(), l.getName(), l.getAddress(), l.getPhoneNumber(),
						l.getEmail(), sdf.format(l.getStartDate()), l.getDepartment(), type });
		}
		

	}
}
