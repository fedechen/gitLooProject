package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import control.RegisterManager;

public class PanelBase extends JPanel implements VisualComponent{

	
	private Page1 page1;
	private Page2 page2;
    private FrameBase frame;
    private RegisterManager manager;
    	
	
	public PanelBase(FrameBase frame) {
		this.frame = frame;
		setLayouts();
		setComponents();
		setEvents();
	}
	
	
	public void setLayouts() {
		setSize(800, 600);
		setVisible(true);
		setBackground(Color.BLUE);
		setLayout(new CardLayout());
		
	}
	
	public void setComponents() {
		page1 = new Page1(frame);
		page2 = new Page2(frame);
		
		
		
		
		add(page1, "register");
		add(page2, "list");
		
	}

	public void setEvents() {
		// TODO Auto-generated method stub
		
	}

}
