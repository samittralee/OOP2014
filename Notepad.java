import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Notepad extends JFrame implements ActionListener{
	JMenu menu;
	JTextArea area;

    public Notepad() {
    	Container cPane;
    	
    	setTitle     ("Notepad");
        setSize      (500,300);
        setResizable (false);
        setLocation  (250,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        createFileMenu();
        menuBar.add(menu);
        createEditMenu();
        menuBar.add(menu);
        menuBar.setBackground(Color.yellow);
        setJMenuBar(menuBar);
        
        area = new JTextArea();
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(area,BorderLayout.CENTER);
        
    	setContentPane(content);
    	
    }
    
    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName = event.getActionCommand();
        switch(menuName){
        	case "Copy":
        		area.copy();
        		break;
        	case "Cut":
				area.cut();
        		break;
        	case "Paste":
				area.paste();
        		break;
        	case "Clear":
        		area.setText("");
        		break;
        	case "Select All":
        		area.selectAll();
        		break;
        	case "Quit":
        		System.exit(0);
        		break;
        	
        }
    }
    
    public static void main(String[] args){
    	Notepad pad = new Notepad();
    	pad.setVisible(true);
    }
    
    private void createFileMenu() {
    	JMenuItem item;
        menu = new JMenu("File");
        
        item = new JMenuItem("Quit");
        item.addActionListener( this );
        menu.add( item );
    }
    
    private void createEditMenu() {
    	JMenuItem item;
        menu = new JMenu("Edit");
        
        item = new JMenuItem("Copy");
        item.addActionListener( this );
        menu.add( item );
        
        item = new JMenuItem("Cut");
        item.addActionListener( this );
        menu.add( item );
        
        item = new JMenuItem("Paste");
        item.addActionListener( this );
        menu.add( item );
        
        item = new JMenuItem("Clear");
        item.addActionListener( this );
        menu.add( item );
        
        item = new JMenuItem("Select All");
        item.addActionListener( this );
        menu.add( item );
    }
    
    
}