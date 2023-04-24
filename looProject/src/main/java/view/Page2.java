package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.RegisterManager;
import model.Employee;



public class Page2 extends JPanel implements VisualComponent {

	JLabel lbName;
	JTextField tfName;
	JButton btNameOK, btRemove;
	JPanel panelInternoSouth, panelInternoNorth;
	Vector<Vector<Object>> clients = new Vector<Vector<Object>>();
	Vector<String> columns;
	DefaultTableModel dtm;
    FrameBase frame;
	
	JTable table;


	public Page2(FrameBase frame) {
		this.frame = frame;

		setLayouts();
		setComponents();
		setEvents();

	}

	@Override
	public void setLayouts() {
		setBackground(Color.green);
		setLayout(new BorderLayout());
		setVisible(true);

	}

	@Override
	public void setComponents() {

		panelInternoNorth = new JPanel(null);
		panelInternoNorth.setBackground(Color.gray);
		panelInternoNorth.setSize(800, 300);
		panelInternoNorth.setVisible(true);
		lbName = new JLabel(" NOME ");
		lbName.setBounds(100, 100, 150, 30);
		panelInternoNorth.add(lbName);

		tfName = new JTextField(300);
		tfName.setBounds(250, 100, 200, 30);
		panelInternoNorth.add(tfName);

		btNameOK = new JButton("Lista Todos");
		btNameOK.setBounds(150, 140, 100, 30);
		panelInternoNorth.add(btNameOK);
		panelInternoNorth.setBounds(0, 40, 800, 200);
		
		btRemove = new JButton("Remove");
		btRemove.setBounds(300, 140, 100, 30);
		panelInternoNorth.add(btRemove);
		

		panelInternoSouth = new JPanel(null);


		columns = new Vector<>();
		columns.add("Id");
		columns.add("Nome");
		columns.add("Idade");
		dtm = new DefaultTableModel(clients, columns);

		table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 300, 800, 300);
		panelInternoSouth.add(scroll);
		add(panelInternoNorth);
		add(panelInternoSouth);

	}

	public void setupTable(int width, int height) {

//		dataClient = new Object[width][height];
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				dataClient[i][j] = "";
//			}
//		}

	}

	@Override
	public void setEvents() {

		btNameOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				addClient();

			}
		});
		
		btRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				
				removeClient();

			}
		});

	

	}

	private void addClient() {

		Employee c = frame.manager.getNewEmployee();
		c.setName(tfName.getText());
		c.setAge(12);
		c.setId(344332);
		
		
		//verifica se o register conseguiu armazenar o cliente no banco
		
			Vector<Object> newClient = new Vector<>();
			newClient.add(c.getId());
			newClient.add(c.getName());
			newClient.add(c.getAge());
			clients.add(newClient);
			tfName.setText("");
			dtm.fireTableDataChanged();
		

	}

	private void removeClient() {
       int row = table.getSelectedRow();
       System.out.println("linha selecionada "+row);
       
       
       
       
	}

	



	

}
