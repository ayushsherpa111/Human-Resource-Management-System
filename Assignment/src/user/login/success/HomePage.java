package user.login.success;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import user.login.authorised.Department;
import user.login.controller.LoginController;
import user.login.lecturer.Contract;
import user.login.lecturer.FullTime;
import user.login.lecturer.Lecturer;
import user.login.lecturer.PartTime;
import user.login.model.LoginModel;
import user.login.view.LoginView;

public class HomePage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDepartmentName;
	private JTextField txtDepartmentType;
	private JTextField txtDepartmentUsername;
	private JPasswordField departmentPassword;
	public JLabel lblAddDept;
	public JLabel lblAddLecturer;
	public JLabel lblViewLecturer;
	public JLabel lblViewDepartment;
	private JButton btnAddDepartment;
	private JButton btnResetDepartment;
	private JButton btnBack;
	public JPanel addDepartment;
	public JPanel viewDepartmentsPanel;
	private ArrayList<Department> data = new ArrayList<>();
	private ArrayList<Lecturer> lecturerData = new ArrayList<>();
	private JButton btnDelete;
	public JTable table;
	public JTextField updateDepartmentType;
	public JTextField updateDepartmentUsername;
	public JPasswordField updatePassword;
	public JPanel homePanel;
	public JTextField updateDepartmentName;
	public DefaultTableModel model;
	private int counter = 1;
	private JButton btnUpdate;
	private static int c;
	private JLabel adminUsername;
	private JTextField txtLecturerID;
	private JTextField txtLecturerName;
	private JTextField txtLecturerAddress;
	private JTextField txtLecturerPhone;
	private JTextField txtEmail;
	private JComboBox<String> lecturerType;
	private JPanel addLecturer;
	private JButton btnResetLecturer;
	private JButton btnAddLecturer;
	private JComboBox<String> departmentOptions;
	private JTextField lecturerDate;
	public JPanel viewlectureres;
	public JTable allLecturerTable;
	public JPanel allLecPane;
	public DefaultTableModel lecturerModel;
	public JPanel fullTimePane;
	public DefaultTableModel fullTimeModel;
	public JTable fullTimeTable;
	public JPanel searchPanel;
	private JLabel lblId;
	private JLabel lblSearchID;
	private JLabel lblName;
	private JLabel lblSearchName;
	private JLabel lblAddress;
	private JLabel lblSearchAddress;
	private JLabel lblEmail;
	private JLabel lblSearchEmail;
	private JLabel lblPhoneNumber;
	private JLabel lblSearchPhone;
	private JLabel lblType;
	private JLabel lblSearchType;
	private JLabel lblStartDate;
	private JLabel lblSearchDate;
	private JLabel lblDep;
	private JLabel lblSearchDepartment;
	private JButton btnSearch;
	private JTextField searchData;
	private JComboBox<String> searchItem;
	public JPanel partTimePanel;
	public DefaultTableModel partTimeModel;
	public JTable partTimeTable;
	public JTable contractTable;
	public DefaultTableModel contractModel;
	public JPanel contractPanel;
	public JTextField txtUpdateLecName;
	public JTextField txtUpdateLecAddress;
	public JTextField txtUpdateLecEmail;
	public JTextField txtUpdateLecPhone;
	public JTextField txtUpdateDepartmentLec;
	public JButton deleteLecturer;
	public JButton updateLecturer;
	private JTextField txtUpdateLecSalary;
	private JTextField txtUpdateLecPayRate;
	private JButton updatePay;
	private JTextField txtUpdateLecSalaryCon;
	private JButton btnContractUpdate;
	private JButton btnUpdateSalary;
	private JLabel lblThereAreCurrently;
	private JLabel numberOfDepartments;
	private JLabel lblDepartments_1;
	private JMenu menu;
	private JLabel numberOfLecturer;

	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setTitle("Home");
		setSize(1000, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 974, 590);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setFont(new Font("Bell MT", Font.PLAIN, 13));
		sideBarPanel.setBounds(0, 0, 195, 587);
		mainPanel.add(sideBarPanel);
		sideBarPanel.setForeground(Color.WHITE);
		sideBarPanel.setBackground(Color.GRAY);
		sideBarPanel.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setBackground(Color.WHITE);
		lblMenu.setFont(new Font("Bell MT", Font.PLAIN, 21));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(10, 11, 177, 30);
		sideBarPanel.add(lblMenu);

		lblAddDept = new JLabel("Add Department");
		lblAddDept.setToolTipText("Add New Department");
		lblAddDept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddDept.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblAddDept.setBounds(10, 81, 177, 23);
		lblAddDept.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				viewDepartmentsPanel.setVisible(false);
				homePanel.setVisible(false);
				addLecturer.setVisible(false);
				addDepartment.setVisible(true);
				viewlectureres.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {
				lblAddDept.setFont(new Font("Bell MT", Font.PLAIN, 16));
				lblAddDept.setForeground(Color.black);
			}

			public void mouseEntered(MouseEvent e) {
				lblAddDept.setFont(new Font("Bell MT", Font.BOLD, 16));
				lblAddDept.setForeground(Color.WHITE);
			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		sideBarPanel.add(lblAddDept);

		lblAddLecturer = new JLabel("Add Lecturer");
		lblAddLecturer.setToolTipText("Add New Lecturers");
		lblAddLecturer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddLecturer.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblAddLecturer.setBounds(10, 143, 177, 23);
		lblAddLecturer.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				homePanel.setVisible(false);
				addDepartment.setVisible(false);
				viewDepartmentsPanel.setVisible(false);
				viewlectureres.setVisible(false);
				addLecturer.setVisible(true);
				String[] departmentTypes = new String[data.size()];
				HashSet<String> uniqueTypes = new HashSet<>();
				for (Department d : data) {
					uniqueTypes.add(d.getType());
				}
				int index = 0;
				Iterator<String> iterate = uniqueTypes.iterator();
				while (index != uniqueTypes.size()) {
					departmentTypes[index] = iterate.next();
					index++;
				}
				departmentOptions.setModel(new DefaultComboBoxModel<String>(departmentTypes));
			}

			public void mouseExited(MouseEvent e) {
				lblAddLecturer.setFont(new Font("Bell MT", Font.PLAIN, 16));
				lblAddLecturer.setForeground(Color.BLACK);
			}

			public void mouseEntered(MouseEvent e) {
				lblAddLecturer.setFont(new Font("Bell MT", Font.BOLD, 16));
				lblAddLecturer.setForeground(Color.WHITE);
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		sideBarPanel.add(lblAddLecturer);

		lblViewLecturer = new JLabel("View Lecturers");
		lblViewLecturer.setToolTipText("View all available lecturers");
		lblViewLecturer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblViewLecturer.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblViewLecturer.setBounds(10, 115, 177, 23);
		lblViewLecturer.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				viewlectureres.setVisible(true);
				viewDepartmentsPanel.setVisible(false);
				addDepartment.setVisible(false);
				homePanel.setVisible(false);
				addLecturer.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {
				lblViewLecturer.setFont(new Font("Bell MT", Font.PLAIN, 16));
				lblViewLecturer.setForeground(Color.black);
			}

			public void mouseEntered(MouseEvent e) {
				lblViewLecturer.setFont(new Font("Bell MT", Font.BOLD, 16));
				lblViewLecturer.setForeground(Color.white);
			}

			public void mouseClicked(MouseEvent e) {

			}
		});
		sideBarPanel.add(lblViewLecturer);

		lblViewDepartment = new JLabel("View Departments");
		lblViewDepartment.setToolTipText("View All available Departments");
		lblViewDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblViewDepartment.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblViewDepartment.setBounds(10, 52, 177, 23);
		lblViewDepartment.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				viewDepartmentsPanel.setVisible(true);
				homePanel.setVisible(false);
				addDepartment.setVisible(false);
				viewlectureres.setVisible(false);
				addLecturer.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {
				lblViewDepartment.setFont(new Font("Bell MT", Font.PLAIN, 16));
				lblViewDepartment.setForeground(Color.BLACK);
			}

			public void mouseEntered(MouseEvent e) {
				lblViewDepartment.setFont(new Font("Bell MT", Font.BOLD, 16));
				lblViewDepartment.setForeground(Color.WHITE);
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		sideBarPanel.add(lblViewDepartment);

		JPanel blockPanel = new JPanel();
		blockPanel.setBounds(195, 0, 790, 587);
		mainPanel.add(blockPanel);
		blockPanel.setLayout(new CardLayout(0, 0));

		Vector<String> title = new Vector<>();
		title.add("Title");
		title.add("Type");
		title.add("Username");

		homePanel = new JPanel();
		blockPanel.add(homePanel);
		homePanel.setVisible(true);
		homePanel.setLayout(null);

		JLabel icon = new JLabel(new ImageIcon(HomePage.class.getResource("/Image/avatar.png")));
		icon.setSize(239, 244);
		icon.setLocation(31, 83);
		homePanel.add(icon);

		JLabel lblWelcome = new JLabel("Human Resource Management System");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(145, 11, 512, 30);
		lblWelcome.setFont(new Font("Bell MT", Font.PLAIN, 30));
		homePanel.add(lblWelcome);

		JLabel lblUsername_2 = new JLabel("Welcome ");
		lblUsername_2.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblUsername_2.setBounds(280, 83, 102, 30);
		homePanel.add(lblUsername_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 52, 739, 8);
		homePanel.add(separator);

		adminUsername = new JLabel("");
		adminUsername.setFont(new Font("Bell MT", Font.PLAIN, 20));
		adminUsername.setBounds(392, 87, 112, 22);
		homePanel.add(adminUsername);
		
		lblThereAreCurrently = new JLabel("There are currently ");
		lblThereAreCurrently.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblThereAreCurrently.setBounds(31, 351, 161, 30);
		homePanel.add(lblThereAreCurrently);
		
		numberOfDepartments = new JLabel("");
		numberOfDepartments.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfDepartments.setFont(new Font("Bell MT", Font.PLAIN, 19));
		numberOfDepartments.setBounds(190, 351, 28, 30);
		homePanel.add(numberOfDepartments);
		
		lblDepartments_1 = new JLabel("department(s)");
		lblDepartments_1.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblDepartments_1.setBounds(216, 351, 130, 30);
		homePanel.add(lblDepartments_1);
		
		JLabel label_1 = new JLabel("There are currently ");
		label_1.setFont(new Font("Bell MT", Font.PLAIN, 19));
		label_1.setBounds(31, 392, 161, 30);
		homePanel.add(label_1);
		
		numberOfLecturer = new JLabel("");
		numberOfLecturer.setHorizontalAlignment(SwingConstants.CENTER);
		numberOfLecturer.setFont(new Font("Bell MT", Font.PLAIN, 19));
		numberOfLecturer.setBounds(190, 392, 28, 30);
		homePanel.add(numberOfLecturer);
		
		JLabel lblLectus = new JLabel("Lecturer(s)");
		lblLectus.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblLectus.setBounds(216, 392, 130, 30);
		homePanel.add(lblLectus);

		viewDepartmentsPanel = new JPanel();
		blockPanel.add(viewDepartmentsPanel, "name_226358336325912");
		viewDepartmentsPanel.setVisible(false);
		viewDepartmentsPanel.setLayout(null);

		JLabel lblDepartments = new JLabel("Departments");
		lblDepartments.setVerticalAlignment(SwingConstants.CENTER);
		lblDepartments.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartments.setFont(new Font("Bell MT", Font.PLAIN, 25));
		lblDepartments.setBounds(208, 11, 170, 39);
		viewDepartmentsPanel.add(lblDepartments);

		addDepartment = new JPanel();
		blockPanel.add(addDepartment, "name_226475817149718");
		addDepartment.setVisible(false);
		addDepartment.setLayout(null);

		JLabel lblAdd = new JLabel("Add Department");
		lblAdd.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdd.setFont(new Font("Bell MT", Font.PLAIN, 30));
		lblAdd.setBounds(10, 11, 275, 33);
		addDepartment.add(lblAdd);

		JLabel lblDepartmentName = new JLabel("Department Name:");
		lblDepartmentName.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblDepartmentName.setBounds(10, 75, 163, 28);
		addDepartment.add(lblDepartmentName);

		txtDepartmentName = new JTextField();
		txtDepartmentName.setBounds(183, 76, 186, 28);
		addDepartment.add(txtDepartmentName);
		txtDepartmentName.setColumns(10);

		JLabel lblDepartmentType = new JLabel("Department Type:");
		lblDepartmentType.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblDepartmentType.setBounds(10, 122, 163, 16);
		addDepartment.add(lblDepartmentType);

		txtDepartmentType = new JTextField();
		txtDepartmentType.setColumns(10);
		txtDepartmentType.setBounds(183, 117, 186, 28);
		addDepartment.add(txtDepartmentType);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblUsername.setBounds(10, 167, 119, 16);
		addDepartment.add(lblUsername);

		txtDepartmentUsername = new JTextField();
		txtDepartmentUsername.setColumns(10);
		txtDepartmentUsername.setBounds(183, 162, 186, 28);
		addDepartment.add(txtDepartmentUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblPassword.setBounds(10, 201, 113, 35);
		addDepartment.add(lblPassword);

		departmentPassword = new JPasswordField();
		departmentPassword.setBounds(183, 205, 186, 28);
		addDepartment.add(departmentPassword);

		btnAddDepartment = new JButton("Add");

		btnAddDepartment.setBounds(10, 247, 72, 33);
		addDepartment.add(btnAddDepartment);

		btnResetDepartment = new JButton("Reset");
		btnResetDepartment.setBounds(92, 247, 72, 33);
		addDepartment.add(btnResetDepartment);

		btnBack = new JButton("Back");

		btnBack.setBounds(10, 303, 72, 33);
		addDepartment.add(btnBack);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 51, 749, 2);
		addDepartment.add(separator_3);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);
				viewDepartmentsPanel.setVisible(false);
				addDepartment.setVisible(false);
				viewlectureres.setVisible(false);
				addLecturer.setVisible(false);
				
			}
		});
		mnFile.add(mntmHome);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
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
		mnFile.add(mntmExit);

		JMenu functions = new JMenu("Options");
		functions.setSize(new Dimension(14, 0));
		menuBar.add(functions);

		JMenuItem addDepartmentMenu = new JMenuItem("Add Department");
		addDepartmentMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewDepartmentsPanel.setVisible(false);
				homePanel.setVisible(false);
				addLecturer.setVisible(false);
				addDepartment.setVisible(true);
				viewlectureres.setVisible(false);
			}
		});
		functions.add(addDepartmentMenu);

		JMenuItem mntmAddLecturer = new JMenuItem("Add Lecturer");
		functions.add(mntmAddLecturer);
		
		menu = new JMenu("                                                                                                                                                                                                                                                                                                                                        ");
		menu.setEnabled(false);
		menuBar.add(menu);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
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
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(btnLogOut);

		table = new JTable();

		// create a table model and set a Column Identifiers to this model
		Object[] columns = { "Id", "Title", "Type", "User" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		// set the model to the table
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("Bell MT", Font.PLAIN, 15);
		table.setFont(font);
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 61, 749, 267);

		viewDepartmentsPanel.add(pane);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(109, 498, 77, 23);
		viewDepartmentsPanel.add(btnDelete);

		JLabel lblDepartmentName_1 = new JLabel("Department Name:");
		lblDepartmentName_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblDepartmentName_1.setBounds(10, 380, 150, 19);
		viewDepartmentsPanel.add(lblDepartmentName_1);

		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setFont(new Font("Bell MT", Font.PLAIN, 23));
		lblUpdate.setBounds(10, 339, 117, 30);
		viewDepartmentsPanel.add(lblUpdate);

		updateDepartmentName = new JTextField();
		updateDepartmentName.setBounds(10, 406, 150, 23);
		viewDepartmentsPanel.add(updateDepartmentName);
		updateDepartmentName.setColumns(10);

		JLabel lblDepartmentType_1 = new JLabel("Department Type:");
		lblDepartmentType_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblDepartmentType_1.setBounds(10, 426, 150, 30);
		viewDepartmentsPanel.add(lblDepartmentType_1);

		updateDepartmentType = new JTextField();
		updateDepartmentType.setColumns(10);
		updateDepartmentType.setBounds(10, 450, 150, 23);
		viewDepartmentsPanel.add(updateDepartmentType);

		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblUsername_1.setBounds(200, 380, 117, 19);
		viewDepartmentsPanel.add(lblUsername_1);

		updateDepartmentUsername = new JTextField();
		updateDepartmentUsername.setColumns(10);
		updateDepartmentUsername.setBounds(200, 407, 131, 23);
		viewDepartmentsPanel.add(updateDepartmentUsername);

		updatePassword = new JPasswordField();
		updatePassword.setBounds(200, 450, 130, 23);
		viewDepartmentsPanel.add(updatePassword);

		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPassword_1.setBounds(200, 432, 117, 19);
		viewDepartmentsPanel.add(lblPassword_1);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 498, 89, 23);
		viewDepartmentsPanel.add(btnUpdate);

		viewlectureres = new JPanel();
		blockPanel.add(viewlectureres, "name_34622803891125");
		viewlectureres.setLayout(null);
		viewlectureres.setVisible(false);

		JLabel lblLecturer = new JLabel("Lecturers");
		lblLecturer.setVerticalAlignment(SwingConstants.CENTER);
		lblLecturer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecturer.setFont(new Font("Bell MT", Font.PLAIN, 25));
		lblLecturer.setBounds(214, 11, 170, 39);
		viewlectureres.add(lblLecturer);

		JLabel lblAll = new JLabel("All");
		lblAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAll.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblAll.setBounds(24, 62, 46, 14);
		lblAll.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mousePressed(MouseEvent e) {
				homePanel.setVisible(false);
				addDepartment.setVisible(false);
				viewDepartmentsPanel.setVisible(false);
				allLecPane.setVisible(true);
				searchPanel.setVisible(false);
				fullTimePane.setVisible(false);
				searchPanel.setVisible(false);
				partTimePanel.setVisible(false);
				contractPanel.setVisible(false);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		viewlectureres.add(lblAll);

		JLabel lblFulltime = new JLabel("FullTime");
		lblFulltime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFulltime.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblFulltime.setBounds(106, 62, 73, 14);
		lblFulltime.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				homePanel.setVisible(false);
				addDepartment.setVisible(false);
				viewDepartmentsPanel.setVisible(false);
				allLecPane.setVisible(false);
				fullTimePane.setVisible(true);
				searchPanel.setVisible(false);
				partTimePanel.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		viewlectureres.add(lblFulltime);

		JLabel lblParttime = new JLabel("PartTime");
		lblParttime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblParttime.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblParttime.setBounds(237, 62, 73, 14);
		lblParttime.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				homePanel.setVisible(false);
				addDepartment.setVisible(false);
				viewDepartmentsPanel.setVisible(false);
				allLecPane.setVisible(false);
				fullTimePane.setVisible(false);
				searchPanel.setVisible(false);
				partTimePanel.setVisible(true);
				contractPanel.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		viewlectureres.add(lblParttime);

		JLabel lblContract = new JLabel("Contract");
		lblContract.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblContract.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblContract.setBounds(369, 62, 73, 14);
		lblContract.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				homePanel.setVisible(false);
				addDepartment.setVisible(false);
				viewDepartmentsPanel.setVisible(false);
				allLecPane.setVisible(false);
				fullTimePane.setVisible(false);
				searchPanel.setVisible(false);
				partTimePanel.setVisible(false);
				contractPanel.setVisible(true);

			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		viewlectureres.add(lblContract);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 87, 770, 1);
		viewlectureres.add(separator_2);

		searchData = new JTextField();
		searchData.setBounds(497, 54, 156, 20);
		viewlectureres.add(searchData);
		searchData.setColumns(10);

		searchItem = new JComboBox();
		searchItem.setModel(new DefaultComboBoxModel<String>(new String[] { "ID", "Name", "Address", "Email" }));
		searchItem.setBounds(653, 54, 78, 20);
		viewlectureres.add(searchItem);

		btnSearch = new JButton(new ImageIcon(HomePage.class.getResource("/Image/Capture.PNG")));
		btnSearch.setBounds(741, 50, 39, 26);
		viewlectureres.add(btnSearch);

		addLecturer = new JPanel();
		blockPanel.add(addLecturer, "name_34917014340911");
		addLecturer.setLayout(null);

		JLabel lblAddLecturers = new JLabel("Add Lecturers:");
		lblAddLecturers.setVerticalAlignment(SwingConstants.CENTER);
		lblAddLecturers.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddLecturers.setFont(new Font("Bell MT", Font.PLAIN, 25));
		lblAddLecturers.setBounds(0, 11, 170, 39);
		addLecturer.add(lblAddLecturers);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(9, 48, 750, 2);
		addLecturer.add(separator_1);

		JLabel lblLecturerId = new JLabel("Lecturer ID:");
		lblLecturerId.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblLecturerId.setBounds(11, 72, 93, 24);
		addLecturer.add(lblLecturerId);

		txtLecturerID = new JTextField();
		txtLecturerID.setBounds(157, 72, 200, 24);
		addLecturer.add(txtLecturerID);
		txtLecturerID.setColumns(10);

		JLabel lblLecturerName = new JLabel("Lecturer Name:");
		lblLecturerName.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblLecturerName.setBounds(11, 107, 117, 24);
		addLecturer.add(lblLecturerName);

		txtLecturerName = new JTextField();
		txtLecturerName.setColumns(10);
		txtLecturerName.setBounds(157, 107, 200, 24);
		addLecturer.add(txtLecturerName);

		JLabel lblLecturerAddress = new JLabel("Lecturer Address:");
		lblLecturerAddress.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblLecturerAddress.setBounds(10, 142, 117, 24);
		addLecturer.add(lblLecturerAddress);

		txtLecturerAddress = new JTextField();
		txtLecturerAddress.setColumns(10);
		txtLecturerAddress.setBounds(156, 142, 200, 24);
		addLecturer.add(txtLecturerAddress);

		JLabel lblLecturerPhone = new JLabel("Lecturer Phone:");
		lblLecturerPhone.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblLecturerPhone.setBounds(9, 177, 117, 24);
		addLecturer.add(lblLecturerPhone);

		txtLecturerPhone = new JTextField();
		txtLecturerPhone.setColumns(10);
		txtLecturerPhone.setBounds(155, 177, 200, 24);
		addLecturer.add(txtLecturerPhone);

		JLabel lblLecturerEmail = new JLabel("Lecturer Email:");
		lblLecturerEmail.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblLecturerEmail.setBounds(10, 212, 117, 24);
		addLecturer.add(lblLecturerEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(156, 212, 200, 24);
		addLecturer.add(txtEmail);

		JLabel lblJoinDate = new JLabel("Join Date:");
		lblJoinDate.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblJoinDate.setBounds(10, 247, 117, 24);
		addLecturer.add(lblJoinDate);

		JLabel lblLecturerType = new JLabel("Lecturer Type:");
		lblLecturerType.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblLecturerType.setBounds(10, 318, 117, 24);
		addLecturer.add(lblLecturerType);

		lecturerType = new JComboBox<String>();
		lecturerType.setFont(new Font("Bell MT", Font.PLAIN, 13));
		lecturerType.setModel(new DefaultComboBoxModel<String>(new String[] { "Full Time", "Part Time", "Contract" }));
		lecturerType.setSelectedIndex(0);
		lecturerType.setBounds(157, 320, 130, 20);
		addLecturer.add(lecturerType);

		btnAddLecturer = new JButton("Create");
		btnAddLecturer.setBounds(15, 353, 87, 23);
		addLecturer.add(btnAddLecturer);

		btnResetLecturer = new JButton("Reset");
		btnResetLecturer.setBounds(112, 353, 81, 23);
		addLecturer.add(btnResetLecturer);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblDepartment.setBounds(9, 283, 117, 24);
		addLecturer.add(lblDepartment);

		departmentOptions = new JComboBox<String>();
		departmentOptions.setMaximumRowCount(5);
		departmentOptions.setBounds(157, 285, 130, 24);
		addLecturer.add(departmentOptions);

		lecturerDate = new JTextField();
		lecturerDate.setBounds(157, 247, 200, 24);
		addLecturer.add(lecturerDate);
		lecturerDate.setColumns(10);
//
//		// create a table model and set a Column Identifiers to this model
		Object[] LecColumns = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department" };
		lecturerModel = new DefaultTableModel();
		lecturerModel.setColumnIdentifiers(LecColumns);

		JPanel lecBody = new JPanel();
		lecBody.setBounds(7, 88, 773, 488);
		viewlectureres.add(lecBody);
		lecBody.setLayout(new CardLayout(0, 0));

		allLecPane = new JPanel();
		lecBody.add(allLecPane, "name_225872879765537");
		allLecPane.setLayout(null);

		allLecturerTable = new JTable();
		allLecturerTable.setModel(lecturerModel);

		allLecturerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		allLecturerTable.setBackground(Color.LIGHT_GRAY);
		allLecturerTable.setForeground(Color.black);
		allLecturerTable.setFont(font);
		allLecturerTable.setRowHeight(30);
		allLecturerTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		allLecturerTable.getColumnModel().getColumn(1).setMinWidth(100);
		allLecturerTable.getColumnModel().getColumn(3).setMinWidth(140);
		allLecturerTable.getColumnModel().getColumn(4).setMinWidth(200);
		allLecturerTable.getColumnModel().getColumn(5).setMinWidth(110);
		allLecturerTable.getColumnModel().getColumn(6).setMinWidth(160);

		JScrollPane lecPane = new JScrollPane(allLecturerTable);
		lecPane.setBounds(5, 11, 758, 314);
		allLecPane.add(lecPane);
		
		JLabel lblUpdate_1 = new JLabel("Update:");
		lblUpdate_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblUpdate_1.setBounds(5, 336, 73, 21);
		allLecPane.add(lblUpdate_1);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblName_1.setBounds(5, 365, 73, 21);
		allLecPane.add(lblName_1);
		
		txtUpdateLecName = new JTextField();
		txtUpdateLecName.setBounds(85, 365, 149, 22);
		allLecPane.add(txtUpdateLecName);
		txtUpdateLecName.setColumns(10);
		
		txtUpdateLecAddress = new JTextField();
		txtUpdateLecAddress.setColumns(10);
		txtUpdateLecAddress.setBounds(85, 397, 149, 22);
		allLecPane.add(txtUpdateLecAddress);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblAddress_1.setBounds(5, 397, 73, 21);
		allLecPane.add(lblAddress_1);
		
		txtUpdateLecEmail = new JTextField();
		txtUpdateLecEmail.setColumns(10);
		txtUpdateLecEmail.setBounds(85, 430, 149, 22);
		allLecPane.add(txtUpdateLecEmail);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblEmail_1.setBounds(5, 430, 73, 21);
		allLecPane.add(lblEmail_1);
		
		txtUpdateLecPhone = new JTextField();
		txtUpdateLecPhone.setColumns(10);
		txtUpdateLecPhone.setBounds(355, 365, 149, 22);
		allLecPane.add(txtUpdateLecPhone);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPhone.setBounds(253, 364, 73, 21);
		allLecPane.add(lblPhone);
		
		txtUpdateDepartmentLec = new JTextField();
		txtUpdateDepartmentLec.setColumns(10);
		txtUpdateDepartmentLec.setBounds(355, 397, 149, 22);
		allLecPane.add(txtUpdateDepartmentLec);
		
		JLabel lblDepartment_1 = new JLabel("Department:");
		lblDepartment_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblDepartment_1.setBounds(253, 397, 114, 21);
		allLecPane.add(lblDepartment_1);
		
		updateLecturer = new JButton("Save");
		updateLecturer.setBounds(253, 430, 89, 23);
		allLecPane.add(updateLecturer);
		
		deleteLecturer = new JButton("Remove");
		deleteLecturer.setBounds(365, 430, 89, 23);
		allLecPane.add(deleteLecturer);

		Object[] fullTimeColumns = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Salary" };
		fullTimeModel = new DefaultTableModel();
		fullTimeModel.setColumnIdentifiers(fullTimeColumns);

		fullTimeTable = new JTable();
		fullTimeTable.setModel(fullTimeModel);
		fullTimeTable.setBackground(Color.LIGHT_GRAY);
		fullTimeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		fullTimeTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		fullTimeTable.setRowHeight(30);
		fullTimeTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		fullTimeTable.getColumnModel().getColumn(3).setMinWidth(140);
		fullTimeTable.getColumnModel().getColumn(4).setMinWidth(200);
		fullTimeTable.getColumnModel().getColumn(5).setMinWidth(110);
		fullTimeTable.getColumnModel().getColumn(6).setMinWidth(120);

		JScrollPane fullTimeLec = new JScrollPane(fullTimeTable);
		fullTimeLec.setSize(758, 314);
		fullTimeLec.setLocation(5, 11);

		fullTimePane = new JPanel();
		lecBody.add(fullTimePane);
		fullTimePane.setLayout(null);
		fullTimePane.add(fullTimeLec);
		
		txtUpdateLecSalary = new JTextField();
		txtUpdateLecSalary.setBounds(5, 367, 193, 20);
		fullTimePane.add(txtUpdateLecSalary);
		txtUpdateLecSalary.setColumns(10);
		
		btnUpdateSalary = new JButton("Update Salary");
		btnUpdateSalary.setBounds(5, 398, 114, 23);
		fullTimePane.add(btnUpdateSalary);
		
		JLabel lblUpdateLecturerSalary = new JLabel("Update Lecturer Salary:");
		lblUpdateLecturerSalary.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblUpdateLecturerSalary.setBounds(5, 336, 193, 20);
		fullTimePane.add(lblUpdateLecturerSalary);

		searchPanel = new JPanel();
		searchPanel.setVisible(false);
		lecBody.add(searchPanel);
		searchPanel.setLayout(null);
		JLabel defaultIcon = new JLabel(new ImageIcon(HomePage.class.getResource("/Image/avatar.png")));
		defaultIcon.setBounds(10, 11, 179, 185);
		searchPanel.add(defaultIcon);

		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblName.setBounds(199, 55, 126, 27);
		searchPanel.add(lblName);

		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblAddress.setBounds(199, 101, 126, 27);
		searchPanel.add(lblAddress);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblEmail.setBounds(199, 149, 126, 27);
		searchPanel.add(lblEmail);

		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(199, 198, 126, 27);
		searchPanel.add(lblPhoneNumber);

		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblType.setBounds(199, 244, 126, 27);
		searchPanel.add(lblType);

		lblStartDate = new JLabel("Start Date:");
		lblStartDate.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblStartDate.setBounds(199, 292, 126, 27);
		searchPanel.add(lblStartDate);

		lblDep = new JLabel("Department:");
		lblDep.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblDep.setBounds(199, 340, 126, 27);
		searchPanel.add(lblDep);

		lblSearchName = new JLabel("New label");
		lblSearchName.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchName.setBounds(335, 63, 196, 19);
		searchPanel.add(lblSearchName);

		lblSearchAddress = new JLabel("New label");
		lblSearchAddress.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchAddress.setBounds(335, 109, 196, 19);
		searchPanel.add(lblSearchAddress);

		lblSearchEmail = new JLabel("New label");
		lblSearchEmail.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchEmail.setBounds(335, 157, 335, 19);
		searchPanel.add(lblSearchEmail);

		lblSearchPhone = new JLabel("New label");
		lblSearchPhone.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchPhone.setBounds(335, 206, 247, 19);
		searchPanel.add(lblSearchPhone);

		lblSearchType = new JLabel("New label");
		lblSearchType.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchType.setBounds(335, 252, 196, 19);
		searchPanel.add(lblSearchType);

		lblSearchDate = new JLabel("New label");
		lblSearchDate.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchDate.setBounds(335, 300, 196, 19);
		searchPanel.add(lblSearchDate);

		lblSearchDepartment = new JLabel("New label");
		lblSearchDepartment.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchDepartment.setBounds(335, 348, 196, 19);
		searchPanel.add(lblSearchDepartment);

		lblSearchID = new JLabel("New label");
		lblSearchID.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSearchID.setBounds(335, 19, 196, 19);
		searchPanel.add(lblSearchID);

		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblId.setBounds(199, 11, 126, 27);
		searchPanel.add(lblId);

		partTimePanel = new JPanel();
		lecBody.add(partTimePanel, "name_367529468901339");
		partTimePanel.setLayout(null);
		partTimePanel.setVisible(false);

		Object[] partTimeColumns = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Pay rate" };
		partTimeModel = new DefaultTableModel();
		partTimeModel.setColumnIdentifiers(partTimeColumns);

		partTimeTable = new JTable();
		partTimeTable.setModel(partTimeModel);
		partTimeTable.setBackground(Color.LIGHT_GRAY);
		partTimeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		partTimeTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		partTimeTable.setRowHeight(30);
		partTimeTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		partTimeTable.getColumnModel().getColumn(3).setMinWidth(140);
		partTimeTable.getColumnModel().getColumn(4).setMinWidth(200);
		partTimeTable.getColumnModel().getColumn(5).setMinWidth(110);
		partTimeTable.getColumnModel().getColumn(6).setMinWidth(120);

		JScrollPane partTimeLec = new JScrollPane(partTimeTable);
		partTimeLec.setSize(758, 314);
		partTimeLec.setLocation(5, 11);

		partTimePanel.add(partTimeLec);
		
		JLabel lblUpdateLecturerPay = new JLabel("Update Lecturer Pay Rate:");
		lblUpdateLecturerPay.setFont(new Font("Bell MT", Font.PLAIN, 19));
		lblUpdateLecturerPay.setBounds(5, 336, 217, 20);
		partTimePanel.add(lblUpdateLecturerPay);
		
		txtUpdateLecPayRate = new JTextField();
		txtUpdateLecPayRate.setBounds(5, 367, 160, 20);
		partTimePanel.add(txtUpdateLecPayRate);
		txtUpdateLecPayRate.setColumns(10);
		
		updatePay = new JButton("Update Pay");
		updatePay.setBounds(5, 398, 103, 23);
		partTimePanel.add(updatePay);

		contractPanel = new JPanel();
		lecBody.add(contractPanel, "name_369208129013586");

		Object[] contractColumn = { "Id", "Name", "Address", "Phone", "Email", "Date", "Department", "Salary",
				"Contract Expiry" };
		contractModel = new DefaultTableModel();
		contractModel.setColumnIdentifiers(contractColumn);

		contractTable = new JTable();
		contractTable.setModel(contractModel);
		contractTable.setBackground(Color.LIGHT_GRAY);
		contractTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		contractTable.setFont(new Font("Bell MT", Font.PLAIN, 15));
		contractTable.setRowHeight(30);
		contractTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		contractTable.getColumnModel().getColumn(3).setMinWidth(140);
		contractTable.getColumnModel().getColumn(4).setMinWidth(150);
		contractTable.getColumnModel().getColumn(5).setMinWidth(110);
		contractTable.getColumnModel().getColumn(6).setMinWidth(100);
		contractTable.getColumnModel().getColumn(7).setMinWidth(120);
		contractTable.getColumnModel().getColumn(8).setMinWidth(130);
		contractPanel.setLayout(null);

		JScrollPane contractScrollPane = new JScrollPane(contractTable);
		contractScrollPane.setSize(758, 314);
		contractScrollPane.setLocation(5, 11);

		contractPanel.add(contractScrollPane);
		
		JLabel label = new JLabel("Update Lecturer Salary:");
		label.setFont(new Font("Bell MT", Font.PLAIN, 19));
		label.setBounds(5, 336, 193, 20);
		contractPanel.add(label);
		
		txtUpdateLecSalaryCon = new JTextField();
		txtUpdateLecSalaryCon.setBounds(5, 367, 165, 20);
		contractPanel.add(txtUpdateLecSalaryCon);
		txtUpdateLecSalaryCon.setColumns(10);
		
		btnContractUpdate = new JButton("Contract Update");
		btnContractUpdate.setBounds(5, 398, 128, 23);
		contractPanel.add(btnContractUpdate);
	}
	public double getContractSalary()
	{
		return Double.parseDouble(txtUpdateLecSalaryCon.getText());
	}
	public void updateContract(ActionListener acl)
	{
		btnContractUpdate.addActionListener(acl);
	}
	public String getLecturerDep() {
		return departmentOptions.getSelectedItem().toString();
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public String getLecturerDate() {
		return lecturerDate.getText();
	}

	public String getLecturerType() {
		return lecturerType.getSelectedItem().toString();
	}

	public int getTxtLecturerID() throws NumberFormatException{
		return Integer.parseInt(txtLecturerID.getText());
	}

	public String getTxtLecturerName() {
		return txtLecturerName.getText();
	}

	public String getTxtLecturerAddress() {
		return txtLecturerAddress.getText();
	}

	public String getTxtLecturerPhone() {
		return txtLecturerPhone.getText();
	}

	public void clearData() {
		txtDepartmentName.setText("");
		txtDepartmentType.setText("");
		txtDepartmentUsername.setText("");
		departmentPassword.setText("");
	}

	public void clearLecturerData() {
		txtLecturerID.setText("");
		txtEmail.setText("");
		txtLecturerAddress.setText("");
		txtLecturerName.setText("");
		txtLecturerPhone.setText("");
		lecturerDate.setText("");

	}

	public String getTxtDepartmentName() {
		return txtDepartmentName.getText();
	}

	public String getTxtDepartmentType() {
		return txtDepartmentType.getText();
	}

	public String getTxtDepartmentUsername() {
		return txtDepartmentUsername.getText();
	}

	public String getDepartmentPassword() {
		return String.valueOf(departmentPassword.getPassword());
	}

	public void actionClearLecturer(ActionListener acl) {
		btnResetLecturer.addActionListener(acl);
	}

	public void addDepartment(ActionListener acl) {
		btnAddDepartment.addActionListener(acl);
	}

	public void backBtton(ActionListener acl) {
		btnBack.addActionListener(acl);
	}

	public void resetButton(ActionListener acl) {
		btnResetDepartment.addActionListener(acl);
	}

	public void setUpdateField(MouseAdapter a) {
		table.addMouseListener(a);
	}

	public void setAllLecUpdateField(MouseAdapter a)
	{
		allLecturerTable.addMouseListener(a);
	}
	
	public void displayRecords(String departmentName, String type, String userName) {
		c = counter;
		model.addRow(new Object[] { c++, departmentName, type, userName });
	}

	public void getRecords() {

		for (Department d : data) {
			model.addRow(new Object[] { counter++, d.getdepartmentName(), d.getType(), d.getUserName() });
		}
	}

	public void setDepartment(ArrayList<Department> d) {
		for (Department dd : d) {
			if (!data.contains(dd)) {
				data.add(dd);
			}
		}

	}

	public void addLecturerRecords(Lecturer lecturer) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		lecturerModel.addRow(
				new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(), lecturer.getPhoneNumber(),
						lecturer.getEmail(), sdf.format(lecturer.getStartDate()), lecturer.getDepartment() });
	}

	public void getLecturerRecords() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		for (Lecturer lecturer : lecturerData) {
			lecturerModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
					lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
					lecturer.getDepartment() });
		}
	}

	public void setLecturer(ArrayList<Lecturer> L) {
		for (Lecturer lec : L) {
			if (!lecturerData.contains(lec)) {
				lecturerData.add(lec);
			}
		}

	}

	// All full time lecturers
	public void getFullTimeRecords() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		for (Lecturer lecturer : lecturerData) {
			if (lecturer instanceof FullTime) {
				fullTimeModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
						lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
						lecturer.getDepartment(), ((FullTime) lecturer).getSalary() });
			} else if (lecturer instanceof PartTime) {
				partTimeModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
						lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
						lecturer.getDepartment(), ((PartTime) lecturer).getPayRate() });
			} else if (lecturer instanceof Contract) {
				contractModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
						lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
						lecturer.getDepartment(), ((Contract) lecturer).getSalary(),
						sdf.format(((Contract) lecturer).getEndDate()) });
			}
		}
	}

	// Add one full time lecturer
	public void addTypeLecturerRecords(Lecturer lecturer) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		if (lecturer instanceof FullTime) {
			fullTimeModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
					lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
					lecturer.getDepartment(), ((FullTime) lecturer).getSalary() });
		} else if (lecturer instanceof PartTime) {
			partTimeModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
					lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
					lecturer.getDepartment(), ((PartTime) lecturer).getPayRate() });
		} else if (lecturer instanceof Contract) {
			contractModel.addRow(new Object[] { lecturer.getID(), lecturer.getName(), lecturer.getAddress(),
					lecturer.getPhoneNumber(), lecturer.getEmail(), sdf.format(lecturer.getStartDate()),
					lecturer.getDepartment(), ((Contract) lecturer).getSalary(),
					sdf.format(((Contract) lecturer).getEndDate()) });
		}
	}

	public void setNumberOfDepartments(int num)
	{
		numberOfDepartments.setText(Integer.toString(num));
	}
	
	public void setNumberOfLecturer(int num) {
		numberOfLecturer.setText(Integer.toString(num));
	}
	
	public void setDelete(ActionListener acl) {
		btnDelete.addActionListener(acl);
	}

	public void update(ActionListener acl) {
		btnUpdate.addActionListener(acl);
	}

	public void setUserNameAdmin(String uName) {
		adminUsername.setText(uName);
	}

	public void addLecturer(ActionListener acl) {
		btnAddLecturer.addActionListener(acl);
	}

	public void setSearchResults(Lecturer lec) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String type = "";
		if (lec instanceof FullTime) {
			type = "Full Time";
		} else if (lec instanceof PartTime) {
			type = "Part Time";
		} else {
			type = "Contract";
		}
		lblSearchID.setText(Integer.toString(lec.getID()));
		lblSearchName.setText(lec.getName());
		lblSearchAddress.setText(lec.getAddress());
		lblSearchEmail.setText(lec.getEmail());
		lblSearchType.setText(type);
		lblSearchDate.setText(sdf.format(lec.getStartDate()));
		lblSearchPhone.setText(lec.getPhoneNumber());
		lblSearchDepartment.setText(lec.getDepartment());

	}

	public double getUpdateSalary() throws NumberFormatException 
	{
		return Double.parseDouble(txtUpdateLecSalary.getText());
	}
	
	public String getSearchData() throws NumberFormatException {
		return searchData.getText();
	}

	public String getSearchItem() {
		return searchItem.getSelectedItem().toString();
	}

	public void searchAction(ActionListener acl) {
		btnSearch.addActionListener(acl);
	}
	
	public void removeLecturerAll(ActionListener acl)
	{
		deleteLecturer.addActionListener(acl);
	}
	public void updateLecAll(ActionListener acl)
	{
		updateLecturer.addActionListener(acl);
	}
	public void updateFullTimeSalary(ActionListener acl)
	{
		btnUpdateSalary.addActionListener(acl);
	}
	public double getUpdatePay() throws NumberFormatException 
	{
		return Double.parseDouble(txtUpdateLecPayRate.getText());
	}
	public void updatePayRate(ActionListener acl)
	{
		updatePay.addActionListener(acl);
	}
}
