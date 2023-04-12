package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.RegisterManager;
import model.Employee;

public class Page2 extends JPanel implements VisualComponent {

	private RegisterManager manager;
	private JTable table;
	private JButton btok;

	public Page2() {
		setLayouts();
		setComponents();
		setEvents();
		
	}

	public void setLayouts() {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setSize(800, 600);
		setVisible(true);

	}

	public void setComponents() {
		manager = new RegisterManager();
		btok = new JButton("-- ok --");
		// Create a table with 10 rows and 5 columns
		table = new JTable(10, 3);
      
		// Make the table vertically scrollable
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		add(btok, BorderLayout.SOUTH);

	}

	public void setEvents() {
		btok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showEmployeeList();
				
			}
		});

	}

	private void showEmployeeList() {
		List<Employee> employees = manager.getListEmployees();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.getName());
		}
		
		
		//Object[] row = { employees.get(1).getName(), employees.get(1).getAge(), employees.get(1).getRole() };

	    //DefaultTableModel model = (DefaultTableModel) table.getModel();

	    //model.addRow(row);

	}

}
