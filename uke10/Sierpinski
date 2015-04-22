
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class GUI {
	
	JFrame ramme = new JFrame("Vindatabase");
	JPanel panel = new JPanel();
	JLabel[] lapper = new JLabel[5];
	JTextField[] felt = new JTextField[5];
	JButton lagreKnapp = new JButton();
	JButton nullstillKnapp = new JButton();
	
	public GUI () {
		
		for (int i = 0; i < lapper.length; i++) {
			lapper[i] = new JLabel();
			felt[i] = new JTextField();
		}
		
		lapper[0].setText("Navn");
		lapper[1].setText("Aargang");
		lapper[2].setText("Farge");
		lapper[3].setText("Lukt");
		lapper[4].setText("Smak");
		
		lagreKnapp.setText("Lagre");
		nullstillKnapp.setText("Nullstill");
		
		lagreKnapp.addActionListener(new KnappeLytter());
		nullstillKnapp.addActionListener(new KnappeLytter());
		
		panel.setLayout(new GridLayout(6, 2));
		
		for(int i = 0; i < 5; i++) {
			panel.add(lapper[i]);
			panel.add(felt[i]);
		}
		
		panel.add(lagreKnapp);
		panel.add(nullstillKnapp);
		
		ramme.add(panel);
		ramme.setSize(300, 300);
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);
	}
	
	
	private class KnappeLytter implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == nullstillKnapp) {
				for(int i = 0; i < felt.length; i++) {
					felt[i].setText("");
				}
			}
			
			if(e.getSource() == lagreKnapp) {
				try {
					lagrePaaFil();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
			}
			
		}
	}
	
	public void lagrePaaFil() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("vin.txt"));
		
		for(int i = 0; i < 5; i++) {
			pw.println(lapper[i].getText() + ": " + felt[i].getText());
		}
		
		pw.close();
		
	}
	
}




