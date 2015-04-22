import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI {
	
	JFrame ramme;
	JPanel tekstpanel;
	JPanel knappepanel;
	JTextArea tekstomraade;
	JTextField filnavn;
	JButton lagreknapp;
	JButton aapneknapp;	
	
	public GUI() {
		ramme = new JFrame("IFIclipse");
		tekstpanel = new JPanel();
		knappepanel = new JPanel();
		tekstomraade = new JTextArea();
		filnavn = new JTextField();
		lagreknapp = new JButton("Lagre");
		aapneknapp = new JButton("Aapne");	
		
		this.byggGUI();
		
	}
	
	public void byggGUI() {
		// Ordner knapper
		Knappelytter lytter = new Knappelytter();
		aapneknapp.addActionListener(lytter);
		lagreknapp.addActionListener(lytter);
		
		// Ordner oevre panel
		tekstpanel.setLayout(new GridLayout(1,1));
		tekstpanel.add(tekstomraade);
		
		// Ordner nedre panel
		knappepanel.setLayout(new GridLayout(1, 3));
		knappepanel.add(filnavn);
		knappepanel.add(lagreknapp);
		knappepanel.add(aapneknapp);
		
		// Setter opp ramme
		ramme.setLayout(new BorderLayout());
		ramme.add(tekstpanel, BorderLayout.NORTH);
		ramme.add(knappepanel, BorderLayout.SOUTH);
		
		ramme.setSize(500, 500);
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);
	}
	
	private class Knappelytter implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == lagreknapp) {
				if(!filnavn.getText().equals("")) {
					Kontroll.lagre(filnavn.getText(), tekstomraade.getText());
				} else {
					System.err.println("Du har ikke tastet inn filnavn");
				}
			} else if (e.getSource() == aapneknapp) {
				JFileChooser jfc = new JFileChooser(".");
				int returverdi = jfc.showOpenDialog(ramme);
				
				if(returverdi == JFileChooser.APPROVE_OPTION) {
					String fil = jfc.getSelectedFile().getAbsolutePath();
					Dokument aapnet = Kontroll.hentDokument(fil);
					
					tekstomraade.setText(aapnet.hentInnhold());
				} else if (returverdi == JFileChooser.CANCEL_OPTION) {
					System.out.println("Du var ikke så lur denne gangen");
				}
			}
		}
		
	}

}
