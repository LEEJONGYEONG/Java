package mini.java.ordergui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class OrderGUI extends JFrame{
	
	public OrderGUI() {
		init();
		
	}
	void init() {
		this.setTitle("OrderGUI");
		this.setBounds(0,0,800,800);
		this.setLayout(new BorderLayout());
		
		JScrollPane jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy
			(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel menu = new JPanel();
		this.add(menu, BorderLayout.NORTH);
		
		JButton btn = new JButton("Soda");
		JButton btn2 = new JButton("Juice");
		JButton btn3 = new JButton("Milk");
		JButton btn4  = new JButton("Coffee");
		
		menu.add(btn);
		menu.add(btn2);
		menu.add(btn3);
		menu.add(btn4);
		
		JPanel list = new JPanel(new GridLayout(1,3,10,10));
		this.add(list, BorderLayout.CENTER);
		
		JButton soda = new JButton("Coke");
		JButton soda2 = new JButton("Cider");
		JButton soda3 = new JButton("Dr.Pepper");
		
		list.add(soda);
		list.add(soda2);
		list.add(soda3);
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new OrderGUI();
	}

}
