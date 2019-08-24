package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	FileWriter fw = null;
	String mes;
	ArrayList<String> as = new ArrayList<String>();
	JFrame f = new JFrame();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	String fn;
	
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.set();
	}
	
	public void set() {
		f.add(p);
		p.add(b1);
		p.add(b2);
		p.add(b3); 
		p.add(b4);
		p.add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b1.setText("add task");
		b2.setText("load task");
		b3.setText("remove task");
		b4.setText("save list");
		b5.setText("load list");
		f.setVisible(true);
		f.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bp = (JButton) e.getSource();
		if (bp==b1) {
			
			String mes = JOptionPane.showInputDialog("Write something in your to do list");
			as.add(mes);
			
		}
		if(bp==b2) {
			System.out.println(as);
		}
if(bp==b3) {
	String rmes = JOptionPane.showInputDialog("Write something in your to do list");
		for (int i = 0; i < as.size(); i++) {
		
			if(as.get(i).equals(rmes)) {
				as.remove(i);
				break;
			}
			
			
		}	
		}
if(bp==b4) {
	 
	String f =	JOptionPane.showInputDialog("What do you want to call the file");

		
		try {
			fw = new FileWriter("src/_03_To_Do_List/"+fn+".txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e1.printStackTrace();
		}
		
		for (int i = 0; i < as.size(); i++) {
			try {
				fw.write(as.get(i));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
}
if(bp==b5) {
	BufferedReader br = null;
	ArrayList<String> nas = new ArrayList<String>();
	try {
		JOptionPane.showInputDialog("Where do you want to load the list from");
		 br = new BufferedReader(new FileReader("src/_03_To_Do_List/"+fn+".txt"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}


	String rl= null;

		try {
			rl = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		// TODO Auto-generated catch block
	

while(rl!= null) {
	


	nas.add(rl);
	try {
		rl = br.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}


}	
	as = nas;
}
		
		
		
		
		
	}
	
	
	

	
	
	
	
}