package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Page2 extends JPanel implements VisualComponent{

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
		 // Create a table with 10 rows and 5 columns
	    JTable table = new JTable(10, 5);

	    // Make the table vertically scrollable
	    JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane, BorderLayout.CENTER);
		
	}

	public void setEvents() {
		// TODO Auto-generated method stub
		
	}

}
