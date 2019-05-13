package user.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import user.exception.EmptyException;
import user.login.authorised.Department;
import user.login.lecturer.Contract;
import user.login.lecturer.FullTime;
import user.login.lecturer.Lecturer;
import user.login.lecturer.PartTime;
import user.login.model.HomeModel;
import user.login.model.LoginModel;
import user.login.success.HomePage;

public class HomeController {
	HomePage view;
	HomeModel model;
	ArrayList<Department> department = new ArrayList<>(100);
	ArrayList<Lecturer> lecturer = new ArrayList<>(100);

	public HomeController(HomePage view, HomeModel model) {
		this.view = view;
		this.model = model;
		try {
			view.setUserNameAdmin(new LoginModel().getUser().get(0).getUserName());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		view.addDepartment(new HomeFunctions());
		view.backBtton(new HomeFunctions());
		view.actionClearLecturer(new HomeFunctions());
		view.resetButton(new HomeFunctions());
		view.setDelete(new HomeFunctions());
		view.addLecturer(new HomeFunctions());
		try {
			view.setDepartment(model.getDepartment());
			view.setLecturer(model.getLecturer());
			view.setNumberOfDepartments(model.getDepartment().size());
			view.setNumberOfLecturer(model.getLecturer().size());
		} catch (IOException e) {
		}
		view.setUpdateField(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int record = view.table.getSelectedRow();
				ArrayList<Department> dep = new ArrayList<>();
				try {
					dep = model.getDepartment();
				} catch (Exception e1) {
				}
				view.updateDepartmentName.setText(view.model.getValueAt(record, 1).toString());
				view.updateDepartmentType.setText(view.model.getValueAt(record, 2).toString());
				view.updateDepartmentUsername.setText(view.model.getValueAt(record, 3).toString());
				view.updatePassword.setText(dep.get(record).getPassword());
			}
		});
		view.setAllLecUpdateField(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = view.allLecturerTable.getSelectedRow();
				view.txtUpdateLecName.setText(view.lecturerModel.getValueAt(index, 1).toString());
				view.txtUpdateLecAddress.setText(view.lecturerModel.getValueAt(index, 2).toString());
				view.txtUpdateLecPhone.setText(view.lecturerModel.getValueAt(index, 3).toString());
				view.txtUpdateLecEmail.setText(view.lecturerModel.getValueAt(index, 4).toString());
				view.txtUpdateDepartmentLec.setText(view.lecturerModel.getValueAt(index, 6).toString());
			}
		});
		view.update(new HomeFunctions());
		view.getRecords();
		view.getLecturerRecords();
		view.getFullTimeRecords();
		view.searchAction(new SearchItem());
		view.updateLecAll(new HomeFunctions());
		view.updateFullTimeSalary(new HomeFunctions());
		view.updatePayRate(new HomeFunctions());
		view.updateContract(new HomeFunctions());
		view.removeLecturerAll(new HomeFunctions());

	}

	class HomeFunctions implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Add") {
				try {
					department.clear();
					department.addAll(model.getDepartment());
				} catch (FileNotFoundException e1) {
				} catch (IOException e1) {
				}
				if (!model.checkField(new Department(view.getTxtDepartmentName(), view.getTxtDepartmentType(),
						view.getTxtDepartmentUsername(), view.getDepartmentPassword()))) {
					department.add(new Department(view.getTxtDepartmentName(), view.getTxtDepartmentType(),
							view.getTxtDepartmentUsername(), view.getDepartmentPassword()));
					try {
						model.addDepartment(department, "department.bin");
						view.displayRecords(view.getTxtDepartmentName(), view.getTxtDepartmentType(),
								view.getTxtDepartmentUsername());
						JOptionPane.showMessageDialog(view, "Department Successfully added", "Department Created",
								JOptionPane.INFORMATION_MESSAGE);
						view.clearData();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(view, "Please Enter all the fields", "Empty Fields",
							JOptionPane.ERROR_MESSAGE);
				}

				view.setNumberOfDepartments(department.size());
				view.setDepartment(department);

			} else if (e.getActionCommand() == "Back") {
				view.viewDepartmentsPanel.setVisible(true);
				view.addDepartment.setVisible(false);
			} else if (e.getActionCommand() == "Reset") {
				view.clearData();
				view.clearLecturerData();
			} else if (e.getActionCommand() == "Delete") {
				int i = view.table.getSelectedRow();
				if (i >= 0) {
					int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record?",
							"Exit Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
					if (option == 0) {
						try {
							department = model.getDepartment();
							department.remove(i);
							model.addDepartment(department, "department.bin");
							view.setNumberOfDepartments(department.size());
							view.model.removeRow(i);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(view, "Please Select a record to delete", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			} else if (e.getActionCommand() == "Update") {
				if (view.table.getSelectedRow() >= 0) {
					department.clear();
					try {
						department.addAll(model.getDepartment());
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					int index = view.table.getSelectedRow();
					if (!model.checkField(new Department(view.updateDepartmentName.getText(),
							view.updateDepartmentType.getText(), view.updateDepartmentUsername.getText(),
							String.valueOf(view.updatePassword.getPassword())))) {
						department.get(index).setDepartmentName(view.updateDepartmentName.getText());
						department.get(index).setType(view.updateDepartmentType.getText());
						department.get(index).setUserName(view.updateDepartmentUsername.getText());
						department.get(index).setPassword(String.valueOf(view.updatePassword.getPassword()));
						try {
							model.addDepartment(department, "department.bin");
							view.model.setValueAt(view.updateDepartmentName.getText(), index, 1);
							view.model.setValueAt(view.updateDepartmentType.getText(), index, 2);
							view.model.setValueAt(view.updateDepartmentUsername.getText(), index, 3);
							JOptionPane.showMessageDialog(view, "Update Complete", "Update", JOptionPane.OK_OPTION);
							view.updateDepartmentName.setText("");
							view.updateDepartmentType.setText("");
							view.updateDepartmentUsername.setText("");
							view.updatePassword.setText("");
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(view, "Please Fill all the fields", "Empty Fields",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(view, "Select a record to update", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			} else if (e.getActionCommand() == "Create") {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				Date date;
				try {
					date = sdf.parse(view.getLecturerDate());
					if (!lecturer.isEmpty()) {
						lecturer.clear();
					}
					try {
						lecturer.addAll(model.getLecturer());
						if (view.getLecturerType().equals("Full Time")) {
							String decoy = "";
							decoy =  JOptionPane.showInputDialog(view, "Enter the salary",
									"Salary", JOptionPane.QUESTION_MESSAGE);
							if(decoy == null)
							{
								throw new EmptyException("Fields empty");
							}
							double salary = Double.parseDouble(decoy);
							if (!model.checkField(new FullTime(view.getTxtLecturerID(), view.getTxtLecturerName(),
									view.getTxtLecturerAddress(), view.getTxtLecturerPhone(), view.getTxtEmail(), date,
									view.getLecturerDep(), salary))) {
								if (lecturer.isEmpty()) {
									FullTime ft = new FullTime(view.getTxtLecturerID(), view.getTxtLecturerName(),
											view.getTxtLecturerAddress(), view.getTxtLecturerPhone(),
											view.getTxtEmail(), date, view.getLecturerDep(), salary);
									lecturer.add(ft);
									view.addLecturerRecords(ft);
									view.addTypeLecturerRecords(ft);
									view.clearLecturerData();
									model.addDepartment(lecturer, "lecturer.bin");
									JOptionPane.showMessageDialog(view, "Insert Complete", "Created",
											JOptionPane.OK_OPTION);
								} else {
									if (model.checkID(view.getTxtLecturerID(), lecturer) == false) {
										FullTime ft = new FullTime(view.getTxtLecturerID(), view.getTxtLecturerName(),
												view.getTxtLecturerAddress(), view.getTxtLecturerPhone(),
												view.getTxtEmail(), date, view.getLecturerDep(), salary);
										lecturer.add(ft);
										view.addLecturerRecords(ft);
										view.addTypeLecturerRecords(ft);
										model.addDepartment(lecturer, "lecturer.bin");
										view.clearLecturerData();
										JOptionPane.showMessageDialog(view, "Insert Complete", "Created",
												JOptionPane.OK_OPTION);
									} else {
										JOptionPane.showMessageDialog(view, "The ID already exits", "ID TAKEN",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							} else {
								JOptionPane.showMessageDialog(view, "Please Enter all the fields", "Empty Field",
										JOptionPane.ERROR_MESSAGE);
							}
						} else if (view.getLecturerType().equals("Part Time")) {
							double payrate = Double.parseDouble(JOptionPane.showInputDialog(view, "Enter the pay rate",
									"payrate", JOptionPane.QUESTION_MESSAGE));

							if (!model.checkField(new PartTime(view.getTxtLecturerID(), view.getTxtLecturerName(),
									view.getTxtLecturerAddress(), view.getTxtLecturerPhone(), view.getTxtEmail(), date,
									view.getLecturerDep(), payrate))) {
								if (lecturer.isEmpty()) {
									PartTime pt = new PartTime(view.getTxtLecturerID(), view.getTxtLecturerName(),
											view.getTxtLecturerAddress(), view.getTxtLecturerPhone(),
											view.getTxtEmail(), date, view.getLecturerDep(), payrate);
									lecturer.add(pt);
									view.addTypeLecturerRecords(pt);
									model.addDepartment(lecturer, "lecturer.bin");
									view.addLecturerRecords(pt);
									view.clearLecturerData();

									JOptionPane.showMessageDialog(view, "Insert Complete", "Created",
											JOptionPane.OK_OPTION);
								} else {
									if (model.checkID(view.getTxtLecturerID(), lecturer) == false) {
										PartTime pt = new PartTime(view.getTxtLecturerID(), view.getTxtLecturerName(),
												view.getTxtLecturerAddress(), view.getTxtLecturerPhone(),
												view.getTxtEmail(), date, view.getLecturerDep(), payrate);
										lecturer.add(pt);
										view.addTypeLecturerRecords(pt);
										model.addDepartment(lecturer, "lecturer.bin");
										view.addLecturerRecords(pt);
										view.clearLecturerData();
										JOptionPane.showMessageDialog(view, "Insert Complete", "Created",
												JOptionPane.OK_OPTION);
									} else {
										JOptionPane.showMessageDialog(view, "The ID already exits", "ID TAKEN",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							} else {
								JOptionPane.showMessageDialog(view, "Please Enter all the fields", "Empty Field",
										JOptionPane.ERROR_MESSAGE);
							}
						} else if (view.getLecturerType().equals("Contract")) {
							double salary = Double.parseDouble(JOptionPane.showInputDialog(view, "Enter the salary",
									"Salary", JOptionPane.QUESTION_MESSAGE));
							String end = JOptionPane.showInputDialog(view, "Enter the end Date", "End Date",
									JOptionPane.INFORMATION_MESSAGE);
							Date endDate = sdf.parse(end);
							if (!model.checkField(new Contract(view.getTxtLecturerID(), view.getTxtLecturerName(),
									view.getTxtLecturerAddress(), view.getTxtLecturerPhone(), view.getTxtEmail(), date,
									view.getLecturerDep(), salary, endDate))) {
								if (lecturer.isEmpty()) {
									Contract ct = new Contract(view.getTxtLecturerID(), view.getTxtLecturerName(),
											view.getTxtLecturerAddress(), view.getTxtLecturerPhone(),
											view.getTxtEmail(), date, view.getLecturerDep(), salary, endDate);
									lecturer.add(ct);
									model.addDepartment(lecturer, "lecturer.bin");
									view.addTypeLecturerRecords(ct);
									view.addLecturerRecords(ct);
									view.clearLecturerData();
									JOptionPane.showMessageDialog(view, "Insert Complete", "Created",
											JOptionPane.OK_OPTION);
								} else {
									if (model.checkID(view.getTxtLecturerID(), lecturer) == false) {
										Contract ct = new Contract(view.getTxtLecturerID(), view.getTxtLecturerName(),
												view.getTxtLecturerAddress(), view.getTxtLecturerPhone(),
												view.getTxtEmail(), date, view.getLecturerDep(), salary, endDate);
										lecturer.add(ct);
										model.addDepartment(lecturer, "lecturer.bin");
										view.addTypeLecturerRecords(ct);
										view.addLecturerRecords(ct);
										view.clearLecturerData();
										JOptionPane.showMessageDialog(view, "Insert Complete", "Created",
												JOptionPane.OK_OPTION);
									} else {
										JOptionPane.showMessageDialog(view, "The ID already exits", "ID TAKEN",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							} else {
								JOptionPane.showMessageDialog(view, "Please Enter all the fields", "Empty Fields",
										JOptionPane.ERROR_MESSAGE);
							}
						}

					} catch (IOException e1) {
					} catch (NumberFormatException e121) {
						JOptionPane.showMessageDialog(view, "ID must be an Integer", "ERROR", 0);
					}catch (NullPointerException e11) {
						JOptionPane.showMessageDialog(view, "You must specify the salary/date/payrate", "ERROR", 0);
					}
				} catch (ParseException e2) {
					JOptionPane.showMessageDialog(view, "The date you entered was incorrect. Use (MM/dd/yyyy) format",
							"ERR", JOptionPane.ERROR_MESSAGE);
				}
			} else if (e.getActionCommand().equals("Remove")) {
				if (view.allLecturerTable.getSelectedRow() >= 0) {
					int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record?",
							"Exit Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
					if (option == 0) {
						int i = view.allLecturerTable.getSelectedRow();
						int id = (int) view.lecturerModel.getValueAt(i, 0);
						try {
							lecturer = model.getLecturer();
							int index = -1;
							for (int j = 0; j < lecturer.size(); j++) {
								if (lecturer.get(j).getID() == id) {
									index = j;
									break;
								}
							}
							lecturer.remove(index);
							model.addDepartment(lecturer, "lecturer.bin");
							view.lecturerModel.removeRow(i);
							for (int j = view.fullTimeModel.getRowCount() - 1; j > -1; j--) {
								if (id == (int) view.fullTimeModel.getValueAt(j, 0)) {
									view.fullTimeModel.removeRow(j);
									break;
								}
							}
							for (int j = view.partTimeModel.getRowCount() - 1; j > -1; j--) {
								if (id == (int) view.partTimeModel.getValueAt(j, 0)) {
									view.partTimeModel.removeRow(j);
									break;
								}
							}
							for (int j = view.contractModel.getRowCount() - 1; j > -1; j--) {
								if (id == (int) view.contractModel.getValueAt(j, 0)) {
									view.contractModel.removeRow(j);
									break;
								}
							}
							JOptionPane.showMessageDialog(view, "Record Deleted", "Delete", 1);
						} catch (IOException e1) {
						}
					}
				} else {
					JOptionPane.showMessageDialog(view, "Please Select a row to delete", "ERR", 0);
				}
			} else if (e.getActionCommand().equals("Save")) {
				if (view.allLecturerTable.getSelectedRow() >= 0) {
					lecturer.clear();
					try {
						lecturer.addAll(model.getLecturer());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					int row = view.allLecturerTable.getSelectedRow();
					int id = (int) view.allLecturerTable.getValueAt(row, 0);
					int index = -1;
					for (int j = 0; j < lecturer.size(); j++) {
						if (id == lecturer.get(j).getID()) {
							index = j;
							break;
						}
					}
					if (!model.checkField(new Lecturer(id, view.txtUpdateLecName.getText(),
							view.txtUpdateLecAddress.getText(), view.txtUpdateLecPhone.getText(),
							view.txtUpdateLecAddress.getText(), new Date(), view.txtUpdateDepartmentLec.getText()))) {
						lecturer.get(index).setName(view.txtUpdateLecName.getText());
						lecturer.get(index).setAddress(view.txtUpdateLecAddress.getText());
						lecturer.get(index).setEmail(view.txtUpdateLecEmail.getText());
						lecturer.get(index).setPhoneNumber(view.txtUpdateLecPhone.getText());
						lecturer.get(index).setDepartment(view.txtUpdateDepartmentLec.getText());
						try {
							model.addDepartment(lecturer, "lecturer.bin");
							view.lecturerModel.setValueAt(view.txtUpdateLecName.getText(), row, 1);
							view.lecturerModel.setValueAt(view.txtUpdateLecAddress.getText(), row, 2);
							view.lecturerModel.setValueAt(view.txtUpdateLecPhone.getText(), row, 3);
							view.lecturerModel.setValueAt(view.txtUpdateLecEmail.getText(), row, 4);
							view.lecturerModel.setValueAt(view.txtUpdateDepartmentLec.getText(), row, 6);
							int ftRow = -1;
							for (int j = 0; j < view.fullTimeModel.getRowCount(); j++) {
								if (id == (int) view.fullTimeModel.getValueAt(j, 0)) {
									ftRow = j;
									break;
								}
							}
							if (ftRow != -1) {
								view.fullTimeModel.setValueAt(view.txtUpdateLecName.getText(), ftRow, 1);
								view.fullTimeModel.setValueAt(view.txtUpdateLecAddress.getText(), ftRow, 2);
								view.fullTimeModel.setValueAt(view.txtUpdateLecPhone.getText(), ftRow, 3);
								view.fullTimeModel.setValueAt(view.txtUpdateLecEmail.getText(), ftRow, 4);
								view.fullTimeModel.setValueAt(view.txtUpdateDepartmentLec.getText(), ftRow, 6);
							}
							int ptRow = -1;
							for (int j = 0; j < view.partTimeModel.getRowCount(); j++) {
								if (id == (int) view.partTimeModel.getValueAt(j, 0)) {
									ptRow = j;
									break;
								}
							}
							if (ptRow != -1) {
								view.partTimeModel.setValueAt(view.txtUpdateLecName.getText(), ptRow, 1);
								view.partTimeModel.setValueAt(view.txtUpdateLecAddress.getText(), ptRow, 2);
								view.partTimeModel.setValueAt(view.txtUpdateLecPhone.getText(), ptRow, 3);
								view.partTimeModel.setValueAt(view.txtUpdateLecEmail.getText(), ptRow, 4);
								view.partTimeModel.setValueAt(view.txtUpdateDepartmentLec.getText(), ptRow, 6);
							}
							int ctRow = -1;
							for (int j = 0; j < view.contractModel.getRowCount(); j++) {
								if (id == (int) view.contractModel.getValueAt(j, 0)) {
									ctRow = j;
									break;
								}
							}
							if (ctRow != -1) {
								view.contractModel.setValueAt(view.txtUpdateLecName.getText(), ctRow, 1);
								view.contractModel.setValueAt(view.txtUpdateLecAddress.getText(), ctRow, 2);
								view.contractModel.setValueAt(view.txtUpdateLecPhone.getText(), ctRow, 3);
								view.contractModel.setValueAt(view.txtUpdateLecEmail.getText(), ctRow, 4);
								view.contractModel.setValueAt(view.txtUpdateDepartmentLec.getText(), ctRow, 6);
							}
							JOptionPane.showMessageDialog(view, "Records Updated", "Update", 0);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(view, "Please Enter all the fields", "Empty fields", 0);
					}
				} else {
					JOptionPane.showMessageDialog(view, "Select the record you want to edit", "Err", 0);
				}

			} else if (e.getActionCommand().equals("Update Salary")) {
				lecturer.clear();
				try {
					lecturer.addAll(model.getLecturer());
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (view.fullTimeTable.getSelectedRow() >= 0) {
					int i = view.fullTimeTable.getSelectedRow();
					double salary = 0.0;
					try {
						salary = view.getUpdateSalary();
						int id = (int) view.fullTimeModel.getValueAt(i, 0);
						int index = -1;
						for (int j = 0; j < lecturer.size(); j++) {
							if (id == lecturer.get(j).getID()) {
								index = j;
								break;
							}
						}
						((FullTime) lecturer.get(index)).setSalary(salary);
						view.fullTimeModel.setValueAt(salary, i, 7);
						try {
							model.addDepartment(lecturer, "lecturer.bin");
							JOptionPane.showMessageDialog(view, "Update Complete", "Update", 1);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(view, "Enter a double value", "Format Mismatch", 0);
					}
				} else {
					JOptionPane.showMessageDialog(view, "Please Select a record to Update", "ERR", 0);
				}
			} else if (e.getActionCommand().equals("Update Pay")) {
				lecturer.clear();
				try {
					lecturer.addAll(model.getLecturer());
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (view.partTimeTable.getSelectedRow() >= 0) {
					int i = view.partTimeTable.getSelectedRow();
					try {
						double payRate = view.getUpdatePay();
						int id = (int) view.partTimeTable.getValueAt(i, 0);
						int index = -1;
						for (int j = 0; j < lecturer.size(); j++) {
							if (id == lecturer.get(j).getID()) {
								index = j;
								break;
							}
						}
						((PartTime) lecturer.get(index)).setPayRate(payRate);
						view.partTimeModel.setValueAt(payRate, i, 7);
						try {
							model.addDepartment(lecturer, "lecturer.bin");
							JOptionPane.showMessageDialog(view, "Update Complete", "Update", 1);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(view, "Enter a double value", "Format Mismatch", 0);
					}

				} else {
					JOptionPane.showMessageDialog(view, "Please Select a record to Update", "ERR", 0);
				}
			} else if (e.getActionCommand().equals("Contract Update")) {
				lecturer.clear();
				try {
					lecturer.addAll(model.getLecturer());
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (view.contractTable.getSelectedRow() >= 0) {
					int i = view.contractTable.getSelectedRow();
					try {
					double salary = view.getContractSalary();
					int id = (int) view.contractModel.getValueAt(i, 0);
					int index = -1;
					for (int j = 0; j < lecturer.size(); j++) {
						if (id == lecturer.get(j).getID()) {
							index = j;
							break;
						}
					}
					((Contract) lecturer.get(index)).setSalary(salary);
					view.contractModel.setValueAt(salary, i, 7);
					int option = JOptionPane.showConfirmDialog(view, "Do you want to update the expiry date?",
							"Update Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
					if (option == 0) {
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						String date = JOptionPane.showInputDialog(view, "Enter the expiry date", "Update Date", 1);
						try {
							Date d = sdf.parse(date);
							((Contract) lecturer.get(index)).setEndDate(d);
							view.contractModel.setValueAt(sdf.format(((Contract) lecturer.get(index)).getEndDate()), i,
									8);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
					try {
						model.addDepartment(lecturer, "lecturer.bin");
						JOptionPane.showMessageDialog(view, "Update Complete", "Update", 1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(view, "Enter a double value", "Format Mismatch", 0);
					}
				} else {
					JOptionPane.showMessageDialog(view, "Please Select a record to Update", "ERR", 0);
				}
			}

		}
	}

	// search Lecturer class
	class SearchItem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String itemToSearch = view.getSearchData();
			String field = view.getSearchItem();
			ArrayList<Lecturer> data = new ArrayList<>();
			boolean found = false;
			if (itemToSearch.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Please enter an item to search", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					data = model.getLecturer();
					for (Lecturer l : data) {
						if (field.equals("ID")) {
							int id = Integer.parseInt(itemToSearch);
							if (l.getID() == id) {
								found = true;
								view.setSearchResults(l);
							}
						} else if (field.equals("Name")) {
							if (l.getName().contains(itemToSearch)) {
								found = true;
								view.setSearchResults(l);
							}
						} else if (field.contains("Address")) {
							if (l.getAddress().equalsIgnoreCase(itemToSearch)) {
								found = true;
								view.setSearchResults(l);
							}
						} else if (field.equals("Email")) {
							if (l.getEmail().equals(itemToSearch)) {
								found = true;
								view.setSearchResults(l);
							}
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(view, "No records Found", "ERR", JOptionPane.ERROR_MESSAGE);
					} else {
						view.searchPanel.setVisible(true);
						view.viewDepartmentsPanel.setVisible(false);
						view.homePanel.setVisible(false);
						view.addDepartment.setVisible(false);
						view.allLecPane.setVisible(false);
						view.fullTimePane.setVisible(false);
						view.partTimePanel.setVisible(false);
						view.contractPanel.setVisible(false);
					}
				} catch (IOException e1) {
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(view, "Enter an Integer Value", "Error", 0);
				}

			}
		}

	}

}
