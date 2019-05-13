package user.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import user.login.authorised.Department;
import user.login.lecturer.Lecturer;
import user.login.model.DepartmentModel;
import user.login.success.DepartmentHome;

public class DepartmentController {
	DepartmentHome view;
	DepartmentModel model;
	Department user = null;
	ArrayList<Lecturer> lecturers = new ArrayList<>();
	private int toggle = 0;

	public DepartmentController(DepartmentHome view, DepartmentModel model) {
		this.model = model;
		this.view = view;
		user = model.userInfo(view.getUserName());
		view.setDepName(user.getdepartmentName());
		view.setDepType(user.getType());
		try {
			lecturers = model.getAllLecturer();
		} catch (IOException e) {
		}
		view.setAllRecords(lecturers);
		view.addSearch(new Search());
	}

	class Search implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!view.getSearchItem().isEmpty()) {
				try {
					if (!model.searchRecord(view.getSearchCriteria(), view.getSearchItem()).isEmpty()) {
						if (view.getSearchRow() == 0) {
							view.setSearchResults(model.searchRecord(view.getSearchCriteria(), view.getSearchItem()));
						} else {
							view.searchModel.setRowCount(0);
							view.setSearchResults(model.searchRecord(view.getSearchCriteria(), view.getSearchItem()));
						}
					} else {
						JOptionPane.showMessageDialog(view, "No Records found", "ERR", 0);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(view, "Please enter an Integer value", "ERR", 0);
				}
			} else {
				JOptionPane.showMessageDialog(view, "Please enter the search text", "ERR", 0);
			}
		}

	}
}
