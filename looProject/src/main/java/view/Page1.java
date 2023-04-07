package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.RegisterManager;
import model.Employee;

public class Page1 extends JPanel implements VisualComponent{

	
	JLabel lbTitle, lbName, lbAge, lbFunction;
	JTextField jtfName, jtfAge, jtfFunction;
	JButton btName;
    RegisterManager registerM;
	
	public Page1() {
		setLayouts();
		setComponents();
		setEvents();
	}
	
	
	public void setLayouts() {
		setLayout(null);
		setBackground(Color.GREEN);
		setSize(800, 600);
		setVisible(true);
		
	}

	public void setComponents() {
		lbTitle = new JLabel("Cadastro de Empregados");
		//setbounds(horizontal, vertical, comprimento, altura)
		lbTitle.setBounds(300, 10, 300, 50);
		
		lbName = new JLabel("Nome");
		lbName.setBounds(80, 80, 80, 40);
		jtfName = new JTextField();
		jtfName.setBounds(170, 80, 300, 40);
		
		
		lbAge = new JLabel("Idade");
		lbAge.setBounds(510, 80, 60, 40);
		jtfAge = new JTextField();
		jtfAge.setBounds(590, 80, 80, 40);
		
		
		lbFunction = new JLabel("Funcão");
		lbFunction.setBounds(80, 150, 80, 40);
		jtfFunction = new JTextField();
		jtfFunction.setBounds(140, 150, 180, 40);
		
		btName = new JButton("-- CADASTRAR --");
	   // btName.setBounds(400, 10, 100, 50);
	    // adicionando os componentes no Jpanel (Page1)
		add(lbTitle);
		add(lbName);
		add(jtfName);
		add(lbAge);
		add(jtfAge);
	    add(lbFunction);
	    add(jtfFunction);
	    
	    registerM = new RegisterManager();
	    
	}

	public void setEvents() {
		btName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Employee employee = registerM.getNewEmployee();
				employee.setName(jtfName.getText());
				registerM.saveEmployee(employee);
			}
		});
		
	}

}
