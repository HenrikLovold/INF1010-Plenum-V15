import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Oppgave91();
			}
		});
	}
}

class Oppgave91 extends JFrame {

	JPanel panel;
	JButton button;
	JTextField tekstFelt;
	JTextArea tekstVindu;
	JScrollPane rulleVindu;

	Oppgave91() {
		panel = new JPanel();
		button = new JButton("ILoveGUI");
		tekstFelt = new JTextField();
		tekstVindu = new JTextArea();
		rulleVindu = new JScrollPane();
		
		panel.setLayout(new GridLayout(2,0));
		
		button.addActionListener(new ButtonListener());
		tekstFelt.setPreferredSize(new Dimension(100,40));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.CYAN);
		
		rulleVindu.setViewportView(tekstVindu);

		topPanel.add(button);
		topPanel.add(tekstFelt);
		panel.add(topPanel);
		panel.add(rulleVindu);
		this.setSize(500,500);
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	



	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			String filnavn = tekstFelt.getText();
			
			try {
				Scanner s = new Scanner(new File(filnavn));
				String tekst = "";
				while (s.hasNext()) {
					tekst += s.nextLine() + "\n";
				}
				tekstVindu.setText(tekst);
			} catch (FileNotFoundException e) {
				// Opprettet JFileChooser og funnet filen manuelt.
				e.printStackTrace();
			}
		}

	}
}