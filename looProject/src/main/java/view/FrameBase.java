package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import control.RegisterManager;

public class FrameBase extends JFrame implements VisualComponent{

	private PanelBase base; 
	private JMenuBar menubar;
	private JMenu menuAction;
	private JMenuItem itemGravar;
	private CardLayout cl;
	public RegisterManager manager;
	
	
	public FrameBase() {
		setLayouts();
		setComponents();
		setEvents();
	    validate();
	}
	
	public JPanel getBase() {
		return this.base;
	}
	
	
	public void setLayouts() {
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
	}

	public void setComponents() {
	    base = new PanelBase(this);
	    cl = (CardLayout) base.getLayout();
		add(base, BorderLayout.CENTER);
		
		 // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu fileMenu = new JMenu("Arquivo");
        JMenu editMenu = new JMenu("Editar");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
		
        // Cria e adiciona um item simples para o menu
        JMenuItem saveAction = new JMenuItem("Salvar");
        JMenuItem exitAction = new JMenuItem("Sair");
        JMenuItem listAction = new JMenuItem("Listar");
        JMenuItem clearAction = new JMenuItem("Limpar");
        
        fileMenu.add(saveAction);
        fileMenu.add(listAction);
        fileMenu.add(exitAction);
        fileMenu.addSeparator();
        editMenu.add(clearAction);
        
		manager = new RegisterManager();
	}

	public void setEvents() {
		   
   
		
	}
	
	public void showPanels(int panelBaseConstants) {
		switch (panelBaseConstants) {
		case 1:
			cl.show(base, "register");
			break;
		case 2:
			cl.show(base, "list");
			break;
		default:
			break;
		}
	}

     
	
}
