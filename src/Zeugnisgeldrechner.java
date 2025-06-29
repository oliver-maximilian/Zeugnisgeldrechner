import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Zeugnisgeldrechner extends JFrame {
	
	// Generelle Variablen
	private JPanel contentPane;
	
	public static int durchgang = 1;
	
	public static JButton btnWeiter, btnZurueck, btnReset;
	
	public static JLabel lblZeugnissgeld;
	
	public static int ergebnis;
	
	public static Color background = Color.GRAY, backgroundPane = Color.DARK_GRAY, foreground = Color.WHITE, foregroundLbl = Color.WHITE;
	
	// Noten Variablen
	private JPanel notenPanel;
	
	public static String[] nNoten = {"Sehr Gut (1): ", "Gut (2): ", "Befriedigend (3): ", "Ausreichend (4): ", "Mangelhaft (5): ", "Ungenügend (6): "};
	
	public static JButton[] btnNoten = new JButton [6];
	
	public static int jBtnBreite = 200, jBtnHoehe = 80, jBtnX = 50, jBtnY = 75;
	
	public static int notenGeld;
	
	public static int[] notenMenge = new int[6];
	
	public static boolean ungenuegendDa = false;
	
	// Fach auswahl Variablen
	private JPanel fachAuswahlPanel;
	
	public static int faZaehler = 0;
	
	public static JButton[] btnFa = new JButton[11];
	public static JTextField teFiFAWF;
	
	public static String[] faFach = {"Hauswirtschaft", "Technik", "Wirtschaft", "Informatik", 
									"Naturwissenschaften", "Chemie", "Physik", "Biologie", "Werkstatt 1", "Werkstatt 2", "Werkstatt 3"};
	
	public static int fAuswahl;
	
	public static int btnFaX = 20, btnFaY = 120;
	
	public static int[] faZaehlerButton = new int[11];
	
	public static String[] fAusWeiFae = new String[3];
	
	// Vergleichs Variablen
	private JPanel vergleichPanel;
	
	public static JLabel lblTitle;
	
	public static int jLabelBreite = 200, jLabelHoehe = 40;
	public static int rdbtnBreite = 125, rdbtnHoehe = 25;
	public static int rdbtnX = 230;
	
	public static int[] vZaehlerButton = new int[12];
	
	public static boolean aktZeugnis = false;
	public static int[] vorherigesZeugnis = new int[12];
	public static int[] aktuellesZeugnis = new int[12];
	
	public static JLabel[] lblFach = new JLabel[5];
	public static int lblFachY = 470;
	
	public static String[] vNoten = {"Sehr Gut (1) ", "Gut (2) ", "Befriedigend (3) ", "Ausreichend (4) ", "Mangelhaft (5) ", "Ungenügend (6) "};
	
	public static JRadioButton[] rdbtnDeutsch = new JRadioButton[6];
	public static JRadioButton[] rdbtnMathe = new JRadioButton[6];
	public static JRadioButton[] rdbtnEnglisch = new JRadioButton[6];
	public static JRadioButton[] rdbtnSport = new JRadioButton[6];
	public static JRadioButton[] rdbtnWP = new JRadioButton[6];
	public static JRadioButton[] rdbtnGL = new JRadioButton[6];
	public static JRadioButton[] rdbtnKunst = new JRadioButton[6];
	public static JRadioButton[] rdbtnReli = new JRadioButton[6];
	public static JRadioButton[] rdbtnFach1 = new JRadioButton[6];
	public static JRadioButton[] rdbtnFach2 = new JRadioButton[6];
	public static JRadioButton[] rdbtnFach3 = new JRadioButton[6];
	public static JRadioButton[] rdbtnFach4 = new JRadioButton[6];
	
	public static int vergleichGeld;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zeugnisgeldrechner frame = new Zeugnisgeldrechner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Zeugnisgeldrechner() {
		setTitle("Zeugnisgeldrechner");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(backgroundPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblZeugnissgeld = new JLabel("Zeugnisgeld: ");
		lblZeugnissgeld.setBounds(10, 60, 225, 50);
		contentPane.add(lblZeugnissgeld);
		lblZeugnissgeld.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblZeugnissgeld.setForeground(foregroundLbl);
		lblZeugnissgeld.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnEinstellungen = new JButton("Einstellungen");
		btnEinstellungen.setBounds(10, 670, 200, 80);
		contentPane.add(btnEinstellungen);
		
		btnWeiter = new JButton("Weiter");
		btnWeiter.setBackground(background);
		btnWeiter.setForeground(foreground);
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Weiter();
			}
		});
		btnWeiter.setBounds(1125, 710, 150, 40);
		contentPane.add(btnWeiter);
		
		btnZurueck = new JButton("Zurück");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zurueck();	
			}
		});
		btnZurueck.setBounds(965, 710, 150, 40);
		contentPane.add(btnZurueck);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();	
			}
		});
		btnReset.setBounds(805, 710, 150, 40);
		contentPane.add(btnReset);
		
		
		notenPanel = new JPanel();
		notenPanel.setBounds(250, 10, 600, 700);
		notenPanel.setBackground(backgroundPane);
		contentPane.add(notenPanel);
		notenPanel.setLayout(null);		
		
		JLabel lblNoten = new JLabel("Noten");
		lblNoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoten.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoten.setBounds(50, 0, 200, 80);
		lblNoten.setForeground(foregroundLbl);
		notenPanel.add(lblNoten);
		
		for (int i = 0; i < 6; i++) {			
			btnNoten[i] = new JButton(nNoten[i]);
			btnNoten[i].setHorizontalAlignment(SwingConstants.CENTER);
			btnNoten[i].setBounds(jBtnX, jBtnY ,jBtnBreite, jBtnHoehe);
			btnNoten[i].setForeground(foreground);
			btnNoten[i].setBackground(background);
			notenPanel.add(btnNoten[i]);
			jBtnY = jBtnY + 100;
		}
		
		btnNoten[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				notenGeld = notenGeld + 5;
				notenMenge[0]++;
				btnNoten[0].setText(nNoten[0] + notenMenge[0]);
			}
		});	
		
		btnNoten[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notenGeld = notenGeld + 2;
				notenMenge[1]++;
				btnNoten[1].setText(nNoten[1] + notenMenge[1]);
			}
		});		
		
		btnNoten[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notenGeld = notenGeld + 1;
				notenMenge[2]++;
				btnNoten[2].setText(nNoten[2] + notenMenge[2]);
			}
		});				
		
		btnNoten[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notenGeld = notenGeld - 2;
				notenMenge[3]++;
				btnNoten[3].setText(nNoten[3] + notenMenge[3]);
			}
		});
		
		btnNoten[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notenGeld = notenGeld - 5;
				notenMenge[4]++;
				btnNoten[4].setText(nNoten[4] + notenMenge[4]);
			}
		});
		
		btnNoten[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ungenuegendDa = true;
				notenMenge[5]++;
				btnNoten[5].setText(nNoten[5] + notenMenge[5]);
			}
		});
		
		
		fachAuswahlPanel = new JPanel();
		fachAuswahlPanel.setBounds(250, 10, 1000, 700);
		contentPane.add(fachAuswahlPanel);
		fachAuswahlPanel.setBackground(backgroundPane);
		fachAuswahlPanel.setLayout(null);
		fachAuswahlPanel.setVisible(false);
		
		JLabel lblFATitle = new JLabel("Fachauswahl");
		lblFATitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblFATitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFATitle.setBounds(400, 10, jLabelBreite, jLabelHoehe);
		lblFATitle.setForeground(foregroundLbl);
		fachAuswahlPanel.add(lblFATitle);
		
		JLabel lblFAAl = new JLabel("Arbeitslehre");
		lblFAAl.setHorizontalAlignment(SwingConstants.CENTER);
		lblFAAl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFAAl.setBounds(20, 70, jLabelBreite, jLabelHoehe);
		lblFAAl.setForeground(foregroundLbl);
		fachAuswahlPanel.add(lblFAAl);
		
		JLabel lblFANW = new JLabel("Naturwissenschaften");
		lblFANW.setHorizontalAlignment(SwingConstants.CENTER);
		lblFANW.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFANW.setBounds(270, 70, jLabelBreite, jLabelHoehe);
		lblFANW.setForeground(foregroundLbl);
		fachAuswahlPanel.add(lblFANW);	
		
		JLabel lblFAWA = new JLabel("Werkstatt");
		lblFAWA.setHorizontalAlignment(SwingConstants.CENTER);
		lblFAWA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFAWA.setBounds(520, 70, jLabelBreite, jLabelHoehe);
		lblFAWA.setForeground(foregroundLbl);
		fachAuswahlPanel.add(lblFAWA);
		
		JLabel lblFAWF = new JLabel("Weitere Fächer");
		lblFAWF.setHorizontalAlignment(SwingConstants.CENTER);
		lblFAWF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFAWF.setBounds(770, 70, jLabelBreite, jLabelHoehe);
		lblFAWF.setForeground(foregroundLbl);
		fachAuswahlPanel.add(lblFAWF);
		
		teFiFAWF = new JTextField();
		teFiFAWF.setBounds(770, 120, 200, 80);
		fachAuswahlPanel.add(teFiFAWF);
		teFiFAWF.setColumns(17);
		teFiFAWF.getText();
		
		for (int i = 0; i < 11; i++) {
			btnFa[i] = new JButton(faFach[i]);
			btnFa[i].setBounds(btnFaX, btnFaY, 200, 80);
			btnFa[i].setForeground(foreground);
			btnFa[i].setBackground(background);
			fachAuswahlPanel.add(btnFa[i]);
			btnFaY = btnFaY + 100;
			switch (i) {
			case 3:
				btnFaX = btnFaX + 250;
				btnFaY = 120;
				break;
			case 7:
				btnFaX = btnFaX + 250;
				btnFaY = 120;
				break;
			}
		}
		
		btnFa[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 0;
				FachAuswahl();
			}
		});
		
		btnFa[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 1;
				FachAuswahl();
			}
		});
		
		btnFa[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 2;
				FachAuswahl();
			}
		});
		
		btnFa[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 3;
				FachAuswahl();
			}
		});
		
		btnFa[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 4;
				FachAuswahl();
			}
		});
		
		btnFa[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 5;
				FachAuswahl();
			}
		});
		
		btnFa[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 6;
				FachAuswahl();
			}
		});
		
		btnFa[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 7;
				FachAuswahl();
			}
		});
		
		btnFa[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 8;
				FachAuswahl();
			}
		});
		
		btnFa[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 9;
				FachAuswahl();
			}
		});
		
		btnFa[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fAuswahl = 10;
				FachAuswahl();
			}
		});
		
		
		vergleichPanel = new JPanel();
		vergleichPanel.setBounds(250, 10, 1000, 700);
		contentPane.add(vergleichPanel);
		vergleichPanel.setBackground(backgroundPane);
		vergleichPanel.setLayout(null);
		vergleichPanel.setVisible(false);	
		
		lblTitle = new JLabel("Vorherigis Zeugnis");		
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		lblTitle.setBounds(480, 10, jLabelBreite, jLabelHoehe);
		vergleichPanel.add(lblTitle);
		
		JLabel lblDeutsch = new JLabel("Deutsch");
		lblDeutsch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeutsch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeutsch.setBounds(20, 70, jLabelBreite, jLabelHoehe);	
		vergleichPanel.add(lblDeutsch);
		
		for (int i = 0; i < 6; i++) {
			rdbtnDeutsch[i] = new JRadioButton(vNoten[i]);
			rdbtnDeutsch[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnDeutsch[i].setBounds(rdbtnX, 80, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnDeutsch[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnDeutsch[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[0]++;				
				switch (vZaehlerButton[0]) {
				case 1:
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 1;						
					}	else {
						vorherigesZeugnis[0] = 1;
						}					
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnDeutsch[i].setEnabled(false);
						}
					}
					break;
				case 2:
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 0;						
					}	else {
						vorherigesZeugnis[0] = 0;
						}					
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnDeutsch[i].setEnabled(true);
						}
					}
					vZaehlerButton[0] = 0;
					break;					
				}
			}
		});
		
		rdbtnDeutsch[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[0]++;
				switch (vZaehlerButton[0]) {
				case 1:
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 2;						
					}	else {
						vorherigesZeugnis[0] = 2;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnDeutsch[i].setEnabled(false);
						}
					}
					break;
				case 2:
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 0;						
					}	else {
						vorherigesZeugnis[0] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnDeutsch[i].setEnabled(true);
						}
					}
					vZaehlerButton[0] = 0;
					break;
				}
			}
		});
		
		rdbtnDeutsch[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[0]++;
				switch (vZaehlerButton[0]) {
				case 1:
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 3;						
					}	else {
						vorherigesZeugnis[0] = 3;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnDeutsch[i].setEnabled(false);
						}
					}
					break;
				case 2:
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 0;						
					}	else {
						vorherigesZeugnis[0] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnDeutsch[i].setEnabled(true);
						}
					}
					vZaehlerButton[0] = 0;
					break;					
				}
			}
		});
		
		rdbtnDeutsch[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[0]++;
				switch (vZaehlerButton[0]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 4;						
					}	else {
						vorherigesZeugnis[0] = 4;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnDeutsch[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 0;						
					}	else {
						vorherigesZeugnis[0] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnDeutsch[i].setEnabled(true);
						}
					}
					vZaehlerButton[0] = 0;
					break;					
				}
			}
		});
		
		rdbtnDeutsch[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[0]++;
				switch (vZaehlerButton[0]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 5;						
					}	else {
						vorherigesZeugnis[0] = 5;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnDeutsch[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 0;						
					}	else {
						vorherigesZeugnis[0] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnDeutsch[i].setEnabled(true);
						}
					}
					vZaehlerButton[0] = 0;
					break;					
				}
			}
		});
		
		rdbtnDeutsch[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[0]++;
				switch (vZaehlerButton[0]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 6;						
					}	else {
						vorherigesZeugnis[0] = 6;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnDeutsch[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[0] = 0;						
					}	else {
						vorherigesZeugnis[0] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnDeutsch[i].setEnabled(true);
						}
					}
					vZaehlerButton[0] = 0;
					break;					
				}
			}
		});
		
		JLabel lblMathe = new JLabel("Mathe");
		lblMathe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMathe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMathe.setBounds(20, 120, jLabelBreite, jLabelHoehe);
		vergleichPanel.add(lblMathe);
		
		for (int i = 0; i < 6; i++) {			
			rdbtnMathe[i] = new JRadioButton(vNoten[i]);
			rdbtnMathe[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnMathe[i].setBounds(rdbtnX, 130, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnMathe[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnMathe[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[1]++;
				switch (vZaehlerButton[1]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 1;						
					}	else {
						vorherigesZeugnis[1] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnMathe[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 0;						
					}	else {
						vorherigesZeugnis[1] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnMathe[i].setEnabled(true);
						}
					}
					vZaehlerButton[1] = 0;
					break;					
				}
			}
		});
		
		rdbtnMathe[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[1]++;
				switch (vZaehlerButton[1]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 2;						
					}	else {
						vorherigesZeugnis[1] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnMathe[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					vorherigesZeugnis[1] = 0;
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnMathe[i].setEnabled(true);
						}
					}
					vZaehlerButton[1] = 0;
					break;					
				}
			}
		});
		
		rdbtnMathe[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[1]++;
				switch (vZaehlerButton[1]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 3;						
					}	else {
						vorherigesZeugnis[1] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnMathe[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 0;						
					}	else {
						vorherigesZeugnis[1] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnMathe[i].setEnabled(true);
						}
					}
					vZaehlerButton[1] = 0;
					break;					
				}
			}
		});
		
		rdbtnMathe[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[1]++;
				switch (vZaehlerButton[1]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 4;						
					}	else {
						vorherigesZeugnis[1] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnMathe[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 0;						
					}	else {
						vorherigesZeugnis[1] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnMathe[i].setEnabled(true);
						}
					}
					vZaehlerButton[1] = 0;
					break;					
				}
			}
		});
		
		rdbtnMathe[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[1]++;
				switch (vZaehlerButton[1]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 5;						
					}	else {
						vorherigesZeugnis[1] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnMathe[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 0;						
					}	else {
						vorherigesZeugnis[1] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnMathe[i].setEnabled(true);
						}
					}
					vZaehlerButton[1] = 0;
					break;					
				}
			}
		});
		
		rdbtnMathe[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[1]++;
				switch (vZaehlerButton[1]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 6;						
					}	else {
						vorherigesZeugnis[1] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnMathe[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[1] = 0;						
					}	else {
						vorherigesZeugnis[1] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnMathe[i].setEnabled(true);
						}
					}
					vZaehlerButton[1] = 0;
					break;					
				}
			}
		});
		
		JLabel lblEnglisch = new JLabel("Englisch");
		lblEnglisch.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglisch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnglisch.setBounds(20, 170, jLabelBreite, jLabelHoehe);
		vergleichPanel.add(lblEnglisch);		
		
		for (int i = 0; i < 6; i++) {			
			rdbtnEnglisch[i] = new JRadioButton(vNoten[i]);				
			rdbtnEnglisch[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnEnglisch[i].setBounds(rdbtnX, 180, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnEnglisch[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnEnglisch[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[2]++;				
				switch (vZaehlerButton[2]) {
				case 1:
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 1;						
					}	else {
						vorherigesZeugnis[2] = 1;
						}					
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnEnglisch[i].setEnabled(false);
						}
					}
					break;
				case 2:
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 0;						
					}	else {
						vorherigesZeugnis[2] = 0;
						}					
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnEnglisch[2].setEnabled(true);
						}
					}
					vZaehlerButton[2] = 0;
					break;					
				}
			}
		});
		
		rdbtnEnglisch[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[2]++;
				switch (vZaehlerButton[2]) {
				case 1:
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 2;						
					}	else {
						vorherigesZeugnis[2] = 2;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnEnglisch[i].setEnabled(false);
						}
					}
					break;
				case 2:
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 0;						
					}	else {
						vorherigesZeugnis[2] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnEnglisch[i].setEnabled(true);
						}
					}
					vZaehlerButton[2] = 0;
					break;					
				}
			}
		});
		
		rdbtnEnglisch[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[2]++;
				switch (vZaehlerButton[2]) {
				case 1:
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 3;						
					}	else {
						vorherigesZeugnis[2] = 3;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnEnglisch[i].setEnabled(false);
						}
					}
					break;
				case 2:
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 0;						
					}	else {
						vorherigesZeugnis[2] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnEnglisch[i].setEnabled(true);
						}
					}
					vZaehlerButton[2] = 0;
					break;					
				}
			}
		});
		
		rdbtnEnglisch[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[2]++;
				switch (vZaehlerButton[2]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 4;						
					}	else {
						vorherigesZeugnis[2] = 4;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnEnglisch[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 0;						
					}	else {
						vorherigesZeugnis[2] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnEnglisch[i].setEnabled(true);
						}
					}
					vZaehlerButton[2] = 0;
					break;					
				}
			}
		});
		
		rdbtnEnglisch[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[2]++;
				switch (vZaehlerButton[2]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 5;						
					}	else {
						vorherigesZeugnis[2] = 5;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnEnglisch[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 0;						
					}	else {
						vorherigesZeugnis[2] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnEnglisch[i].setEnabled(true);
						}
					}
					vZaehlerButton[2] = 0;
					break;					
				}
			}
		});
		
		rdbtnEnglisch[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[2]++;
				switch (vZaehlerButton[2]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 6;						
					}	else {
						vorherigesZeugnis[2] = 6;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnEnglisch[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[2] = 0;						
					}	else {
						vorherigesZeugnis[2] = 0;
						}	
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnEnglisch[i].setEnabled(true);
						}
					}
					vZaehlerButton[2] = 0;
					break;					
				}
			}
		});	
		
		JLabel lblWP = new JLabel("Wahlpflicht");
		lblWP.setHorizontalAlignment(SwingConstants.CENTER);
		lblWP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWP.setBounds(20, 220, 200, 40);
		vergleichPanel.add(lblWP);
		
		for (int i = 0; i < 6; i++) {			
			rdbtnWP[i] = new JRadioButton(vNoten[i]);
			rdbtnWP[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnWP[i].setBounds(rdbtnX, 230, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnWP[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnWP[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[3]++;
				switch (vZaehlerButton[3]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 1;						
					}	else {
						vorherigesZeugnis[3] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnWP[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 0;						
					}	else {
						vorherigesZeugnis[3] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnWP[i].setEnabled(true);
						}
					}
					vZaehlerButton[3] = 0;
					break;					
				}
			}
		});		
		
		rdbtnWP[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[3]++;
				switch (vZaehlerButton[3]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 2;						
					}	else {
						vorherigesZeugnis[3] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnWP[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 0;						
					}	else {
						vorherigesZeugnis[3] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnWP[i].setEnabled(true);
						}
					}
					vZaehlerButton[3] = 0;
					break;					
				}
			}
		});
		
		rdbtnWP[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[3]++;
				switch (vZaehlerButton[3]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 3;						
					}	else {
						vorherigesZeugnis[3] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnWP[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 0;						
					}	else {
						vorherigesZeugnis[3] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnWP[i].setEnabled(true);
						}
					}
					vZaehlerButton[3] = 0;
					break;					
				}
			}
		});
		
		rdbtnWP[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[3]++;
				switch (vZaehlerButton[3]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 4;						
					}	else {
						vorherigesZeugnis[3] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnWP[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 0;						
					}	else {
						vorherigesZeugnis[3] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnWP[i].setEnabled(true);
						}
					}
					vZaehlerButton[3] = 0;
					break;					
				}
			}
		});
		
		rdbtnWP[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[3]++;
				switch (vZaehlerButton[3]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 5;						
					}	else {
						vorherigesZeugnis[3] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnWP[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 0;						
					}	else {
						vorherigesZeugnis[3] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnWP[i].setEnabled(true);
						}
					}
					vZaehlerButton[3] = 0;
					break;					
				}
			}
		});
		
		rdbtnWP[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[3]++;
				switch (vZaehlerButton[3]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 6;						
					}	else {
						vorherigesZeugnis[3] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnWP[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[3] = 0;						
					}	else {
						vorherigesZeugnis[3] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnWP[i].setEnabled(true);
						}
					}
					vZaehlerButton[3] = 0;
					break;					
				}
			}
		});
		
		JLabel lblSport = new JLabel("Sport");
		lblSport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSport.setBounds(30, 270, jLabelBreite, jLabelHoehe);
		vergleichPanel.add(lblSport);		
		
		for (int i = 0; i < 6; i++) {			
			rdbtnSport[i] = new JRadioButton(vNoten[i]);
			rdbtnSport[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnSport[i].setBounds(rdbtnX, 280, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnSport[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnSport[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[4]++;
				switch (vZaehlerButton[4]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 1;						
					}	else {
						vorherigesZeugnis[4] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnSport[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 0;						
					}	else {
						vorherigesZeugnis[4] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnSport[i].setEnabled(true);
						}
					}
					vZaehlerButton[4] = 0;
					break;					
				}
			}
		});
		
		rdbtnSport[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[4]++;
				switch (vZaehlerButton[4]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 2;						
					}	else {
						vorherigesZeugnis[4] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnSport[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 0;						
					}	else {
						vorherigesZeugnis[4] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnSport[i].setEnabled(true);
						}
					}
					vZaehlerButton[4] = 0;
					break;					
				}
			}
		});
		
		rdbtnSport[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[4]++;
				switch (vZaehlerButton[4]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 3;						
					}	else {
						vorherigesZeugnis[4] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnSport[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 0;						
					}	else {
						vorherigesZeugnis[4] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnSport[i].setEnabled(true);
						}
					}
					vZaehlerButton[4] = 0;
					break;					
				}
			}
		});
		
		rdbtnSport[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[4]++;
				switch (vZaehlerButton[4]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 4;						
					}	else {
						vorherigesZeugnis[4] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnSport[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 0;						
					}	else {
						vorherigesZeugnis[4] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnSport[i].setEnabled(true);
						}
					}
					vZaehlerButton[4] = 0;
					break;					
				}
			}
		});
		
		rdbtnSport[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[4]++;
				switch (vZaehlerButton[4]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 5;						
					}	else {
						vorherigesZeugnis[4] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnSport[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 0;						
					}	else {
						vorherigesZeugnis[4] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnSport[i].setEnabled(true);
						}
					}
					vZaehlerButton[4] = 0;
					break;					
				}
			}
		});
		
		rdbtnSport[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[4]++;
				switch (vZaehlerButton[4]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 6;						
					}	else {
						vorherigesZeugnis[4] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnSport[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[4] = 0;						
					}	else {
						vorherigesZeugnis[4] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnSport[i].setEnabled(true);
						}
					}
					vZaehlerButton[4] = 0;
					break;					
				}
			}
		});
		
		JLabel lblGL = new JLabel("Gesellschaftslehre");
		lblGL.setHorizontalAlignment(SwingConstants.CENTER);
		lblGL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGL.setBounds(20, 320, 200, 40);
		vergleichPanel.add(lblGL);		
		
		for (int i = 0; i < 6; i++) {			
			rdbtnGL[i] = new JRadioButton(vNoten[i]);
			rdbtnGL[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnGL[i].setBounds(rdbtnX, 330, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnGL[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnGL[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[5]++;
				switch (vZaehlerButton[5]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 1;						
					}	else {
						vorherigesZeugnis[5] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnGL[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 0;						
					}	else {
						vorherigesZeugnis[5] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnGL[i].setEnabled(true);
						}
					}
					vZaehlerButton[5] = 0;
					break;					
				}
			}
		});
		
		rdbtnGL[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[5]++;
				switch (vZaehlerButton[5]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 2;						
					}	else {
						vorherigesZeugnis[5] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnGL[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 0;						
					}	else {
						vorherigesZeugnis[5] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnGL[i].setEnabled(true);
						}
					}
					vZaehlerButton[5] = 0;
					break;					
				}
			}
		});
		
		rdbtnGL[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[5]++;
				switch (vZaehlerButton[5]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 3;						
					}	else {
						vorherigesZeugnis[5] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnGL[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 0;						
					}	else {
						vorherigesZeugnis[5] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnGL[i].setEnabled(true);
						}
					}
					vZaehlerButton[5] = 0;
					break;					
				}
			}
		});
		
		rdbtnGL[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[5]++;
				switch (vZaehlerButton[5]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 4;						
					}	else {
						vorherigesZeugnis[5] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnGL[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 0;						
					}	else {
						vorherigesZeugnis[5] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnGL[i].setEnabled(true);
						}
					}
					vZaehlerButton[5] = 0;
					break;					
				}
			}
		});
		
		rdbtnGL[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[5]++;
				switch (vZaehlerButton[5]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 5;						
					}	else {
						vorherigesZeugnis[5] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnGL[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 0;						
					}	else {
						vorherigesZeugnis[5] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnGL[i].setEnabled(true);
						}
					}
					vZaehlerButton[5] = 0;
					break;					
				}
			}
		});
		
		rdbtnGL[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[5]++;
				switch (vZaehlerButton[5]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 6;						
					}	else {
						vorherigesZeugnis[5] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnGL[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[5] = 0;						
					}	else {
						vorherigesZeugnis[5] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnGL[i].setEnabled(true);
						}
					}
					vZaehlerButton[5] = 0;
					break;					
				}
			}
		});
		
		JLabel lblKunst = new JLabel("Kunst");
		lblKunst.setHorizontalAlignment(SwingConstants.CENTER);
		lblKunst.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKunst.setBounds(20, 370, jLabelBreite, jLabelHoehe);
		vergleichPanel.add(lblKunst);	
		
		for (int i = 0; i < 6; i++) {			
			rdbtnKunst[i] = new JRadioButton(vNoten[i]);
			rdbtnKunst[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnKunst[i].setBounds(rdbtnX, 380, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnKunst[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnKunst[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[6]++;
				switch (vZaehlerButton[6]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 1;						
					}	else {
						vorherigesZeugnis[6] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnKunst[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 0;						
					}	else {
						vorherigesZeugnis[6] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnKunst[i].setEnabled(true);
						}
					}
					vZaehlerButton[6] = 0;
					break;					
				}
			}
		});
		
		rdbtnKunst[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[6]++;
				switch (vZaehlerButton[6]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 2;						
					}	else {
						vorherigesZeugnis[6] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnKunst[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 0;						
					}	else {
						vorherigesZeugnis[6] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnKunst[i].setEnabled(true);
						}
					}
					vZaehlerButton[6] = 0;
					break;					
				}
			}
		});
		
		rdbtnKunst[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[6]++;
				switch (vZaehlerButton[6]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 3;						
					}	else {
						vorherigesZeugnis[6] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnKunst[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 0;						
					}	else {
						vorherigesZeugnis[6] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnKunst[i].setEnabled(true);
						}
					}
					vZaehlerButton[6] = 0;
					break;					
				}
			}
		});
		
		rdbtnKunst[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[6]++;
				switch (vZaehlerButton[6]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 4;						
					}	else {
						vorherigesZeugnis[6] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnKunst[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 0;						
					}	else {
						vorherigesZeugnis[6] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnKunst[i].setEnabled(true);
						}
					}
					vZaehlerButton[6] = 0;
					break;					
				}
			}
		});
		
		rdbtnKunst[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[6]++;
				switch (vZaehlerButton[6]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 5;						
					}	else {
						vorherigesZeugnis[6] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnKunst[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 0;						
					}	else {
						vorherigesZeugnis[6] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnKunst[i].setEnabled(true);
						}
					}
					vZaehlerButton[6] = 0;
					break;					
				}
			}
		});
		
		rdbtnKunst[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[6]++;
				switch (vZaehlerButton[6]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 6;						
					}	else {
						vorherigesZeugnis[6] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnKunst[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[6] = 0;						
					}	else {
						vorherigesZeugnis[6] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnKunst[i].setEnabled(true);
						}
					}
					vZaehlerButton[6] = 0;
					break;					
				}
			}
		});
		
		JLabel lblReli = new JLabel("Religionslehre");
		lblReli.setHorizontalAlignment(SwingConstants.CENTER);
		lblReli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReli.setBounds(20, 420, jLabelBreite, jLabelHoehe);
		vergleichPanel.add(lblReli);
		
		for (int i = 0; i < 6; i++) {
			rdbtnReli[i] = new JRadioButton(vNoten[i]);
			rdbtnReli[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnReli[i].setBounds(rdbtnX, 430, rdbtnBreite, rdbtnHoehe);
			vergleichPanel.add(rdbtnReli[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnReli[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[7]++;
				switch (vZaehlerButton[7]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 1;						
					}	else {
						vorherigesZeugnis[7] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnReli[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 0;						
					}	else {
						vorherigesZeugnis[7] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnReli[i].setEnabled(true);
						}
					}
					vZaehlerButton[7] = 0;
					break;					
				}
			}
		});
		
		rdbtnReli[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[7]++;
				switch (vZaehlerButton[7]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 2;						
					}	else {
						vorherigesZeugnis[7] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnReli[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 0;						
					}	else {
						vorherigesZeugnis[7] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnReli[i].setEnabled(true);
						}
					}
					vZaehlerButton[7] = 0;
					break;					
				}
			}
		});
		
		rdbtnReli[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[7]++;
				switch (vZaehlerButton[7]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 3;						
					}	else {
						vorherigesZeugnis[7] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnReli[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 0;						
					}	else {
						vorherigesZeugnis[7] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnReli[i].setEnabled(true);
						}
					}
					vZaehlerButton[7] = 0;
					break;					
				}
			}
		});
		
		rdbtnReli[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[7]++;
				switch (vZaehlerButton[7]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 4;						
					}	else {
						vorherigesZeugnis[7] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnReli[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 0;						
					}	else {
						vorherigesZeugnis[7] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnReli[i].setEnabled(true);
						}
					}
					vZaehlerButton[7] = 0;
					break;					
				}
			}
		});
		
		rdbtnReli[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[7]++;
				switch (vZaehlerButton[7]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 5;						
					}	else {
						vorherigesZeugnis[7] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnReli[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 0;						
					}	else {
						vorherigesZeugnis[7] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnReli[i].setEnabled(true);
						}
					}
					vZaehlerButton[7] = 0;
					break;					
				}
			}
		});
		
		rdbtnReli[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[7]++;
				switch (vZaehlerButton[7]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 6;						
					}	else {
						vorherigesZeugnis[7] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnReli[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[7] = 0;						
					}	else {
						vorherigesZeugnis[7] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnReli[i].setEnabled(true);
						}
					}
					vZaehlerButton[7] = 0;
					break;
				}
			}
		});		
		
		for (int i = 0; i < 4; i++) {
			lblFach[i] = new JLabel("");
			lblFach[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblFach[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblFach[i].setBounds(20, lblFachY, jLabelBreite, jLabelHoehe);
			vergleichPanel.add(lblFach[i]);
			lblFachY = lblFachY + 50;
		}
		
		for (int i = 0; i < 6; i++) {
			rdbtnFach1[i] = new JRadioButton(vNoten[i]);
			rdbtnFach1[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnFach1[i].setBounds(rdbtnX, 480, rdbtnBreite, rdbtnHoehe);
			rdbtnFach1[i].setVisible(false);
			vergleichPanel.add(rdbtnFach1[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnFach1[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[8]++;
				switch (vZaehlerButton[8]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 1;						
					}	else {
						vorherigesZeugnis[8] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach1[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 0;						
					}	else {
						vorherigesZeugnis[8] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach1[i].setEnabled(true);
						}
					}
					vZaehlerButton[8] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach1[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[8]++;
				switch (vZaehlerButton[8]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 2;						
					}	else {
						vorherigesZeugnis[8] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach1[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 0;						
					}	else {
						vorherigesZeugnis[8] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach1[i].setEnabled(true);
						}
					}
					vZaehlerButton[8] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach1[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[8]++;
				switch (vZaehlerButton[8]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 3;						
					}	else {
						vorherigesZeugnis[8] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach1[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 0;						
					}	else {
						vorherigesZeugnis[8] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach1[i].setEnabled(true);
						}
					}
					vZaehlerButton[8] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach1[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[8]++;
				switch (vZaehlerButton[8]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 4;						
					}	else {
						vorherigesZeugnis[8] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach1[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 0;						
					}	else {
						vorherigesZeugnis[8] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach1[i].setEnabled(true);
						}
					}
					vZaehlerButton[8] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach1[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[8]++;
				switch (vZaehlerButton[8]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 5;						
					}	else {
						vorherigesZeugnis[8] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach1[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 0;						
					}	else {
						vorherigesZeugnis[8] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach1[i].setEnabled(true);
						}
					}
					vZaehlerButton[8] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach1[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[8]++;
				switch (vZaehlerButton[8]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 6;						
					}	else {
						vorherigesZeugnis[8] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach1[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[8] = 0;						
					}	else {
						vorherigesZeugnis[8] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach1[i].setEnabled(true);
						}
					}
					vZaehlerButton[8] = 0;
					break;
				}
			}
		});
				
		for (int i = 0; i < 6; i++) {
			rdbtnFach2[i] = new JRadioButton(vNoten[i]);
			rdbtnFach2[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnFach2[i].setBounds(rdbtnX, 530, rdbtnBreite, rdbtnHoehe);
			rdbtnFach2[i].setVisible(false);
			vergleichPanel.add(rdbtnFach2[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnFach2[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[9]++;
				switch (vZaehlerButton[9]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 1;						
					}	else {
						vorherigesZeugnis[9] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach2[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 0;						
					}	else {
						vorherigesZeugnis[9] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach2[i].setEnabled(true);
						}
					}
					vZaehlerButton[9] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach2[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[9]++;
				switch (vZaehlerButton[9]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 2;						
					}	else {
						vorherigesZeugnis[9] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach2[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 0;						
					}	else {
						vorherigesZeugnis[9] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach2[i].setEnabled(true);
						}
					}
					vZaehlerButton[9] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach2[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[9]++;
				switch (vZaehlerButton[9]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 3;						
					}	else {
						vorherigesZeugnis[9] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach2[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 0;						
					}	else {
						vorherigesZeugnis[9] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach2[i].setEnabled(true);
						}
					}
					vZaehlerButton[9] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach2[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[9]++;
				switch (vZaehlerButton[9]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 4;						
					}	else {
						vorherigesZeugnis[9] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach2[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 0;						
					}	else {
						vorherigesZeugnis[9] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach2[i].setEnabled(true);
						}
					}
					vZaehlerButton[9] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach2[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[9]++;
				switch (vZaehlerButton[9]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 5;						
					}	else {
						vorherigesZeugnis[9] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach2[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 0;						
					}	else {
						vorherigesZeugnis[9] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach2[i].setEnabled(true);
						}
					}
					vZaehlerButton[9] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach2[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[9]++;
				switch (vZaehlerButton[9]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 6;						
					}	else {
						vorherigesZeugnis[9] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach2[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[9] = 0;						
					}	else {
						vorherigesZeugnis[9] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach2[i].setEnabled(true);
						}
					}
					vZaehlerButton[9] = 0;
					break;
				}
			}
		});		
		
		for (int i = 0; i < 6; i++) {
			rdbtnFach3[i] = new JRadioButton(vNoten[i]);
			rdbtnFach3[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnFach3[i].setBounds(rdbtnX, 580, rdbtnBreite, rdbtnHoehe);
			rdbtnFach3[i].setVisible(false);
			vergleichPanel.add(rdbtnFach3[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnFach3[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[10]++;
				switch (vZaehlerButton[10]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 1;						
					}	else {
						vorherigesZeugnis[10] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach3[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 0;						
					}	else {
						vorherigesZeugnis[10] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach3[i].setEnabled(true);
						}
					}
					vZaehlerButton[10] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach3[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[10]++;
				switch (vZaehlerButton[10]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 2;						
					}	else {
						vorherigesZeugnis[10] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach3[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 0;						
					}	else {
						vorherigesZeugnis[10] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach3[i].setEnabled(true);
						}
					}
					vZaehlerButton[10] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach3[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[10]++;
				switch (vZaehlerButton[10]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 3;						
					}	else {
						vorherigesZeugnis[10] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach3[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 0;						
					}	else {
						vorherigesZeugnis[10] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach3[i].setEnabled(true);
						}
					}
					vZaehlerButton[10] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach3[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[10]++;
				switch (vZaehlerButton[10]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 4;						
					}	else {
						vorherigesZeugnis[10] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach3[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 0;						
					}	else {
						vorherigesZeugnis[10] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach3[i].setEnabled(true);
						}
					}
					vZaehlerButton[10] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach3[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[10]++;
				switch (vZaehlerButton[10]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 5;						
					}	else {
						vorherigesZeugnis[10] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach3[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 0;						
					}	else {
						vorherigesZeugnis[10] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach3[i].setEnabled(true);
						}
					}
					vZaehlerButton[10] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach3[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[10]++;
				switch (vZaehlerButton[10]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 6;						
					}	else {
						vorherigesZeugnis[10] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach3[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[10] = 0;						
					}	else {
						vorherigesZeugnis[10] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach3[i].setEnabled(true);
						}
					}
					vZaehlerButton[10] = 0;
					break;
				}
			}
		});		
		
		for (int i = 0; i < 6; i++) {
			rdbtnFach4[i] = new JRadioButton(vNoten[i]);
			rdbtnFach4[i].setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnFach4[i].setBounds(rdbtnX, 630, rdbtnBreite, rdbtnHoehe);
			rdbtnFach4[i].setVisible(false);
			vergleichPanel.add(rdbtnFach4[i]);
			rdbtnX = rdbtnX + 130;
		}
		rdbtnX = 230;
		
		rdbtnFach4[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[11]++;
				switch (vZaehlerButton[11]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 1;						
					}	else {
						vorherigesZeugnis[11] = 1;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach4[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 0;						
					}	else {
						vorherigesZeugnis[11] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 0) {
							rdbtnFach4[i].setEnabled(true);
						}
					}
					vZaehlerButton[11] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach4[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[11]++;
				switch (vZaehlerButton[11]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 2;						
					}	else {
						vorherigesZeugnis[11] = 2;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach4[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 0;						
					}	else {
						vorherigesZeugnis[11] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 1) {
							rdbtnFach4[i].setEnabled(true);
						}
					}
					vZaehlerButton[11] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach4[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[11]++;
				switch (vZaehlerButton[11]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 3;						
					}	else {
						vorherigesZeugnis[11] = 3;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach4[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 0;						
					}	else {
						vorherigesZeugnis[11] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 2) {
							rdbtnFach4[i].setEnabled(true);
						}
					}
					vZaehlerButton[11] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach4[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[11]++;
				switch (vZaehlerButton[11]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 4;						
					}	else {
						vorherigesZeugnis[11] = 4;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach4[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 0;						
					}	else {
						vorherigesZeugnis[11] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 3) {
							rdbtnFach4[i].setEnabled(true);
						}
					}
					vZaehlerButton[11] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach4[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[11]++;
				switch (vZaehlerButton[11]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 5;						
					}	else {
						vorherigesZeugnis[11] = 5;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach4[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 0;						
					}	else {
						vorherigesZeugnis[11] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 4) {
							rdbtnFach4[i].setEnabled(true);
						}
					}
					vZaehlerButton[11] = 0;
					break;					
				}
			}
		});
		
		rdbtnFach4[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vZaehlerButton[11]++;
				switch (vZaehlerButton[11]) {
				case 1: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 6;						
					}	else {
						vorherigesZeugnis[11] = 6;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach4[i].setEnabled(false);
						}
					}
					break;
				case 2: 
					if (aktZeugnis) {
						aktuellesZeugnis[11] = 0;						
					}	else {
						vorherigesZeugnis[11] = 0;
						}
					for (int i = 0; i < 6; i++) {
						if (i != 5) {
							rdbtnFach4[i].setEnabled(true);
						}
					}
					vZaehlerButton[11] = 0;
					break;
				}
			}
		});
		
	}
	
	public void Weiter() {
		switch (durchgang) {
		case 1:
			NotenBtnDisable();
			AusgabeRefresh();
			durchgang++;
			break;
		case 2:
			notenPanel.setVisible(false);			
			fachAuswahlPanel.setVisible(true);
			durchgang++;
			break;
		case 3:
			fachAuswahlPanel.setVisible(false);
			vergleichPanel.setVisible(true);
			lblTitle.setText("Vorheriges Zeugnis");
			durchgang++;
			break;
		case 4:
			VergleichWechsel();
			durchgang++;
			break;
		case 5:
			VergleichRechner();
			AusgabeRefresh();
			durchgang++;
			break;
		case 6:
			vergleichPanel.setVisible(false);
			lblZeugnissgeld.setBounds(400, 300, 500, 100);
			lblZeugnissgeld.setFont(new Font("Tahoma", Font.PLAIN, 40));
			btnWeiter.setText("Beenden");
			durchgang++;
			break;
		case 7:
			System.exit(0);
			break;			
		}		
	}
	
	public void Zurueck() {
		switch (durchgang) {
		case 2:
			AusgabeRefresh();
			durchgang--;
			break;
		case 3:
			notenPanel.setVisible(true);
			fachAuswahlPanel.setVisible(false);		
			durchgang--;
			break;
		case 4:
			fachAuswahlPanel.setVisible(true);
			vergleichPanel.setVisible(false);
			durchgang--;
			break;
		case 5:
			fachAuswahlPanel.setVisible(true);
			vergleichPanel.setVisible(false);
			durchgang--;
			break;
		case 6:
			AusgabeRefresh();
			VergleichAktivieren();
			durchgang--;
			break;
		case 7:
			vergleichPanel.setVisible(true);
			btnWeiter.setText("Weiter");
			lblZeugnissgeld.setBounds(10, 60, 225, 50);
			lblZeugnissgeld.setFont(new Font("Tahoma", Font.PLAIN, 25));
			durchgang--;
			break;
		}
	}
	
	public void Reset() {
		switch (durchgang) {
		case 1:
			NotenReset();			
			break;
		case 2:
			NotenReset();			
			break;
		case 3:
			FachAuswahlReset();			
			break;
		case 4:
			VergleichReset();
			break;
		case 5:
			VergleichReset();
			break;
		case 6:
			VergleichReset();			
			break;		
		}
	}
	
	public void AusgabeRefresh() {
		if (ungenuegendDa) {
			ergebnis = ergebnis * 0;
		}
		ergebnis = 0;
		ergebnis = notenGeld + vergleichGeld;
		lblZeugnissgeld.setText("Zeugnissgeld: " + ergebnis + "");
	}
	
	public void NotenBtnDisable() {		
		for (int i = 0; i < 6; i++) {
			btnNoten[i].setEnabled(false);			
		}
	}
	
	public void NotenReset() {
		notenGeld = 0;
		
		for (int i = 0; i < 6; i++) {
			notenMenge[i] = 0;
		}
		
		ungenuegendDa = false;		

		for (int i = 0; i < 6; i++) {			
			btnNoten[i].setText(nNoten[i]);
			btnNoten[i].setEnabled(true);
		}
	}
	
	public void VergleichReset() {
		vergleichGeld = 0;
		lblTitle.setText("Vorheriges Zeugnis");
		for (int i = 0; i < 10; i++) {
			vZaehlerButton[i] = 0;
		}
		for (int i = 0; i < 6; i++) {
			rdbtnDeutsch[i].setEnabled(true);					
			rdbtnMathe[i].setEnabled(true);
			rdbtnEnglisch[i].setEnabled(true);
			rdbtnSport[i].setEnabled(true);					
			rdbtnWP[i].setEnabled(true);
			rdbtnGL[i].setEnabled(true);
			rdbtnKunst[i].setEnabled(true);
			rdbtnReli[i].setEnabled(true);
			rdbtnFach1[i].setEnabled(true);
			rdbtnFach2[i].setEnabled(true);
			rdbtnFach3[i].setEnabled(true);
			rdbtnFach4[i].setEnabled(true);
			
			rdbtnDeutsch[i].setSelected(false);
			rdbtnMathe[i].setSelected(false);		
			rdbtnEnglisch[i].setSelected(false);
			rdbtnSport[i].setSelected(false);					
			rdbtnWP[i].setSelected(false);
			rdbtnGL[i].setSelected(false);
			rdbtnKunst[i].setSelected(false);
			rdbtnReli[i].setSelected(false);
			rdbtnFach1[i].setSelected(false);
			rdbtnFach2[i].setSelected(false);
			rdbtnFach3[i].setSelected(false);
			rdbtnFach4[i].setSelected(false);
		}
		aktZeugnis = false;
	}
	
	public void VergleichWechsel() {
		lblTitle.setText("Aktuelles Zeugnis");		
		for (int i = 0; i < 10; i++) {
			vZaehlerButton[i] = 0;			
		}
		for (int i = 0; i < 6; i++) {
			rdbtnDeutsch[i].setEnabled(true);					
			rdbtnMathe[i].setEnabled(true);
			rdbtnEnglisch[i].setEnabled(true);
			rdbtnSport[i].setEnabled(true);					
			rdbtnWP[i].setEnabled(true);
			rdbtnGL[i].setEnabled(true);
			rdbtnKunst[i].setEnabled(true);
			rdbtnReli[i].setEnabled(true);
			rdbtnFach1[i].setEnabled(true);
			rdbtnFach2[i].setEnabled(true);
			rdbtnFach3[i].setEnabled(true);
			rdbtnFach4[i].setEnabled(true);
			
			rdbtnDeutsch[i].setSelected(false);
			rdbtnMathe[i].setSelected(false);		
			rdbtnEnglisch[i].setSelected(false);
			rdbtnSport[i].setSelected(false);					
			rdbtnWP[i].setSelected(false);
			rdbtnGL[i].setSelected(false);
			rdbtnKunst[i].setSelected(false);
			rdbtnReli[i].setSelected(false);
			rdbtnFach1[i].setSelected(false);
			rdbtnFach2[i].setSelected(false);
			rdbtnFach3[i].setSelected(false);
			rdbtnFach4[i].setSelected(false);
		}
		aktZeugnis = true;
	}
	
	public void VergleichAktivieren() {		
		for (int i = 0; i < 6; i++) {
			rdbtnDeutsch[i].setEnabled(true);					
			rdbtnMathe[i].setEnabled(true);
			rdbtnEnglisch[i].setEnabled(true);
			rdbtnSport[i].setEnabled(true);					
			rdbtnWP[i].setEnabled(true);
			rdbtnGL[i].setEnabled(true);
			rdbtnKunst[i].setEnabled(true);
			rdbtnReli[i].setEnabled(true);
			rdbtnFach1[i].setEnabled(true);
			rdbtnFach2[i].setEnabled(true);
			rdbtnFach3[i].setEnabled(true);
			rdbtnFach4[i].setEnabled(true);			
		}	
	}
	
	public void VergleichRechner() {
		if (aktZeugnis) {
			for (int i = 0; i < 6; i++) {
				if ((aktuellesZeugnis[i] < vorherigesZeugnis[i]) && (aktuellesZeugnis[i] <= 3)) {
					vergleichGeld = vergleichGeld + 5;
				}	else if (aktuellesZeugnis[i] > vorherigesZeugnis[i]){
					vergleichGeld = vergleichGeld - 3;
					}
			}			
		}
		for (int i = 0; i < 6; i++) {
			rdbtnDeutsch[i].setEnabled(false);
			rdbtnMathe[i].setEnabled(false);
			rdbtnEnglisch[i].setEnabled(false);
			rdbtnSport[i].setEnabled(false);
			rdbtnWP[i].setEnabled(false);
			rdbtnGL[i].setEnabled(false);
			rdbtnKunst[i].setEnabled(false);
			rdbtnReli[i].setEnabled(false);
			rdbtnFach1[i].setEnabled(false);
			rdbtnFach2[i].setEnabled(false);
			rdbtnFach3[i].setEnabled(false);
			rdbtnFach4[i].setEnabled(false);
		}
	}
	
	public void FachAuswahl() {		
		faZaehlerButton[fAuswahl]++;
		if (faZaehler < 0) {
			faZaehler = 0;
		}
		switch (faZaehlerButton[fAuswahl]) {
		case 1:
			if (faZaehler < 4) {	
				lblFach[faZaehler].setText(faFach[fAuswahl]);
				btnFa[fAuswahl].setBackground(Color.GREEN);
				switch (faZaehler) {
				case 0:
					for (int i = 0; i < 6; i++) {
						rdbtnFach1[i].setVisible(true);
					}
					break;
				case 1:
					for (int i = 0; i < 6; i++) {
						rdbtnFach2[i].setVisible(true);
					}
					break;
				case 2:
					for (int i = 0; i < 6; i++) {
						rdbtnFach3[i].setVisible(true);
					}
					break;
				case 3:
					for (int i = 0; i < 6; i++) {
						rdbtnFach4[i].setVisible(true);
					}
					break;
				}
				faZaehler++;
			}
			break;
		case 2:
			if (faZaehler <= 4) {
				faZaehler--;
				lblFach[faZaehler].setText("");
				switch (faZaehler) {
				case 0:
					for (int i = 0; i < 6; i++) {
						rdbtnFach1[i].setVisible(false);
					}
					break;
				case 1:
					for (int i = 0; i < 6; i++) {
						rdbtnFach2[i].setVisible(false);
					}
					break;
				case 2:
					for (int i = 0; i < 6; i++) {
						rdbtnFach3[i].setVisible(false);
					}
					break;
				case 3:
					for (int i = 0; i < 6; i++) {
						rdbtnFach4[i].setVisible(false);
					}
					break;
				}				
				btnFa[fAuswahl].setBackground(background);
			}
			faZaehlerButton[fAuswahl] = 0;
			break;
		}
	}
	
	public void FachAuswahlReset() {
		faZaehler = 0;
		fAuswahl = 0;
		for (int i = 0; i < 11; i++) {
			faZaehlerButton[i] = 0;
			btnFa[i].setBackground(background);			
		}		
		for (int i = 0; i < 4; i++) {
			lblFach[i].setText("");			
		}		
		for (int i = 0; i < 6; i++) {
			rdbtnFach1[i].setVisible(false);
			rdbtnFach2[i].setVisible(false);
			rdbtnFach3[i].setVisible(false);
			rdbtnFach4[i].setVisible(false);			
		}
	}
}