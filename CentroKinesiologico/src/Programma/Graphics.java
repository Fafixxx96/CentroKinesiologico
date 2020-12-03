package Programma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.DisplayMode;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Window.Type;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.ScrollPane;
import javax.swing.JMenu;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;

public class Graphics {

	//Componenti grafici____________________________
	private JFrame frmCentroKinesiologico;
	private JTextField txtNomeCliente, txtCognomeCliente, txtNomeEsercizio, textField_2;
	private JButton plsSalvaCliente;
	private Panel panel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7;
	private TextArea textAreaClienti;
	private JLabel lblScheda1, lblScheda2, lblEsercizioNuovo;
	private JComboBox cmbSCliente, cmbOra, cmbMinuti, cmbGruppo;
	
	
	//Codice________________________________________
	public Codice c;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphics window = new Graphics();
					window.frmCentroKinesiologico.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws AWTException 
	 */
	public Graphics() throws IOException, AWTException {
		c = new Codice();
		initialize();
		

	
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws AWTException 
	 */
	private void initialize() throws IOException, AWTException {
		
		
		frmCentroKinesiologico = new JFrame();
		frmCentroKinesiologico.setResizable(false);
		frmCentroKinesiologico.getContentPane().setFont(new Font("Calibri Light", Font.PLAIN, 16));
		frmCentroKinesiologico.getContentPane().setBackground(SystemColor.text);
	
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.inactiveCaption);
		frmCentroKinesiologico.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1200 , 30);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cliente");
		mnNewMenu.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		//NUOVO CLIENTE_____________________________________________________________________________________________________________________________________
		JMenuItem mntmNuovoCliente = new JMenuItem("Nuovo cliente");
		mntmNuovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_2.setEnabled(true);
				plsSalvaCliente.setEnabled(true);
				txtNomeCliente.setEnabled(true);
				txtCognomeCliente.setEnabled(true);
				
				
			
			}
		});
		mntmNuovoCliente.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu.add(mntmNuovoCliente);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modifica cliente");
		mntmNewMenuItem_1.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Visualizza lista clienti");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_1.setEnabled(true);
				textAreaClienti.setEnabled(true);
				textAreaClienti.setText("");
				for(Cliente cl: c.clienti) {
					textAreaClienti.append(cl.nome + " " + cl.cognome + "\n");
				
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		
		JMenu mnNewMenu_1 = new JMenu("Schede");
		mnNewMenu_1.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nuova scheda");
		mntmNewMenuItem_4.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		//MODIFICA SCHEDA CLICK_____________________________________________________________________________________________________________________________
		JMenuItem mntmModificaScheda = new JMenuItem("Modifica scheda");
		mntmModificaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmModificaScheda = new JFrame("Modifica Scheda");
				frmModificaScheda.setResizable(false);
				frmModificaScheda.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
				frmModificaScheda.getContentPane().setBackground(SystemColor.text);
				frmModificaScheda.setForeground(Color.WHITE);
				frmModificaScheda.setTitle("MODIFICA SCHEDA");
				frmModificaScheda.setBounds(450, 150, 300, 200);
				frmModificaScheda.setVisible(true);
				
				JLabel lbl1 = new JLabel("Seleziona Cliente"), lbl2 = new JLabel("Seleziona Scheda");
				JComboBox cmb1 = new JComboBox(), cmb2 = new JComboBox(); 
				
				Panel panel_modS = new Panel();
				panel_modS.setBackground(SystemColor.menu);
				panel_modS.setForeground(SystemColor.menu);
				panel_modS.setBounds(0, 0, 300, 200);
				frmModificaScheda.getContentPane().add(panel_modS);
				panel_modS.setLayout(null);
				panel_modS.add(lbl1);
				panel_modS.add(lbl2);
				panel_modS.add(cmb1);
				panel_modS.add(cmb2);
				
				lbl1.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lbl1.setBounds(35, 15, 100, 20);
				
				lbl2.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lbl2.setBounds(165, 15, 100, 20);
				
				cmb1.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cmb2.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cmb1.setBounds(25, 50, 110, 20);
				cmb2.setBounds(155, 50, 110, 20);
				
				for(Cliente cl: c.clienti)cmb1.addItem(cl.nome + " " + cl.cognome);
				
				
				
				
				
				
				
				
			}
		});
		mntmModificaScheda.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmModificaScheda);
		
		JMenuItem mntmVisualizzaScheda = new JMenuItem("Visualizza scheda");
		mntmVisualizzaScheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser ();
				int response = fc.showOpenDialog(null);
				String stringa = null;
				if(response==JFileChooser.APPROVE_OPTION) 
				  {stringa = fc.getSelectedFile().getPath();
				 }
				if(stringa != null) {
					JFrame frmVisualizzaScheda = new JFrame("Visualizza Scheda");
					frmVisualizzaScheda.setResizable(false);
					frmVisualizzaScheda.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
					frmVisualizzaScheda.getContentPane().setBackground(SystemColor.text);
					frmVisualizzaScheda.setForeground(Color.WHITE);
					frmVisualizzaScheda.setTitle("VISUALIZZA SCHEDA");
					frmVisualizzaScheda.setBounds(200, 200, 795, 410);
					frmVisualizzaScheda.setVisible(true);
					Panel panel_viewS = new Panel();
					panel_viewS.setBackground(SystemColor.menu);
					panel_viewS.setForeground(SystemColor.menu);
					panel_viewS.setBounds(0, 0, 795, 410);
					frmVisualizzaScheda.getContentPane().add(panel_viewS);
					panel_viewS.setLayout(null);
					JLabel lbl = new JLabel();
					panel_viewS.add(lbl);
					lbl.setBounds(0, 0, 795, 410);
					lbl.setIcon(new ImageIcon(stringa));
					
					
				}
				
			}});
		mntmVisualizzaScheda.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmVisualizzaScheda);
		
		JMenu mnNewMenu_2 = new JMenu("Esercizi");
		mnNewMenu_2.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Nuovo esercizio");
		mntmNewMenuItem_3.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnGruppiMuscolari = new JMenu("Gruppi muscolari");
		mnGruppiMuscolari.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnNewMenu_2.add(mnGruppiMuscolari);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Petto");
		mntmNewMenuItem_2.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Dorsali");
		mntmNewMenuItem_5.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Spalle");
		mntmNewMenuItem_6.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmNewMenuItem_6);
		
		JMenuItem mntmGambe = new JMenuItem("Bicipiti");
		mntmGambe.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmGambe);
		
		JMenuItem mntmTricitpiti = new JMenuItem("Tricitpiti");
		mntmTricitpiti.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmTricitpiti);
		
		JMenuItem mntmGambe_1 = new JMenuItem("Gambe");
		mntmGambe_1.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmGambe_1);
		
		JMenuItem mntmAddomeFianchiE = new JMenuItem("Addome, fianchi e lombari");
		mntmAddomeFianchiE.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmAddomeFianchiE);
		
		JMenuItem mntmCorrettiva = new JMenuItem("Correttiva");
		mntmCorrettiva.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmCorrettiva);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Stretching");
		mntmNewMenuItem_8.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Cardio fitness");
		mntmNewMenuItem_7.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnGruppiMuscolari.add(mntmNewMenuItem_7);
		
		JMenu mnOpzioni = new JMenu("Opzioni");
		mnOpzioni.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		menuBar.add(mnOpzioni);
		
		JMenuItem mntmInserisciPercorso = new JMenuItem("Inserisci percorso");
		mntmInserisciPercorso.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		mnOpzioni.add(mntmInserisciPercorso);
		
		panel_2 = new Panel();
		panel_2.setEnabled(false);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setForeground(SystemColor.menu);
		panel_2.setBounds(5, 40, 170, 115);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(10, 60, 60, 20);
		txtNomeCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_2.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblNuovoCliente = new JLabel("            Nuovo cliente");
		lblNuovoCliente.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNuovoCliente.setBounds(10, 11, 213, 14);
		panel_2.add(lblNuovoCliente);
		
		txtCognomeCliente = new JTextField();
		txtCognomeCliente.setEnabled(false);
		txtCognomeCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCognomeCliente.setColumns(10);
		txtCognomeCliente.setBounds(100, 60, 60, 20);
		panel_2.add(txtCognomeCliente);
		
	//SALVA NUOVO CIENTE_____________________________________________________________________________________________________________________________________
		plsSalvaCliente = new JButton("Salva");
		plsSalvaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNomeCliente.getText();
				String cognome = txtCognomeCliente.getText();
				
				if(nome.equals("") || cognome.equals(""))JOptionPane.showMessageDialog(null, "Campi vuoti", "Errore!",  JOptionPane.ERROR_MESSAGE);
				else
					try {c.NuovoCliente(nome, cognome);} 
					catch (IOException e) {e.printStackTrace();}
				panel_1.setEnabled(true);
				textAreaClienti.setEnabled(true);
				textAreaClienti.setText("");
				for(Cliente cl: c.clienti) {
					textAreaClienti.append(cl.nome + " " + cl.cognome + '\n');
				}
			}
		});
		plsSalvaCliente.setEnabled(false);
		plsSalvaCliente.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		plsSalvaCliente.setBounds(40, 90, 90, 20);
		panel_2.add(plsSalvaCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNome.setBounds(20, 36, 52, 14);
		panel_2.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblCognome.setBounds(105, 35, 70, 14);
		panel_2.add(lblCognome);
		
		panel_1 = new Panel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setForeground(SystemColor.controlText);
		panel_1.setEnabled(false);
		panel_1.setBounds(5, 160, 170, 424);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textAreaClienti = new TextArea();
		textAreaClienti.setBounds(0, 30, 170, 394);
		panel_1.add(textAreaClienti);
		
		JLabel lblListaClienti = new JLabel("Lista clienti");
		lblListaClienti.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblListaClienti.setBounds(39, 0, 101, 25);
		panel_1.add(lblListaClienti);
		
		panel_3 = new Panel();
		panel_3.setForeground(SystemColor.controlText);
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(995, 40, 195, 172);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(29, 36, 39, 20);
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel_3.add(label_1);
		
		txtNomeEsercizio = new JTextField();
		txtNomeEsercizio.setToolTipText("");
		txtNomeEsercizio.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtNomeEsercizio.setBounds(10, 58, 80, 20);
		txtNomeEsercizio.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNomeEsercizio.setColumns(10);
		panel_3.add(txtNomeEsercizio);
		
		JLabel lblSelezionaImmagine = new JLabel("Seleziona immagine");
		lblSelezionaImmagine.setBounds(10, 89, 102, 20);
		panel_3.add(lblSelezionaImmagine);
		lblSelezionaImmagine.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		
		JLabel lblNuovoEsercizio = new JLabel("Nuovo esercizio");
		lblNuovoEsercizio.setBounds(54, 5, 102, 20);
		lblNuovoEsercizio.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel_3.add(lblNuovoEsercizio);
		
		//SCEGLI FILE________________________________________________________________________________________________________________________________________________________________________________________________
		JButton btnScegliFile = new JButton("Scegli file ...");
		btnScegliFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser ();

				//creo un int per verificare la risposta della finestra di scelta
				int response = fc.showOpenDialog(null);

				//se è stato selezionato un file ed il pulsante ok
				if(response==JFileChooser.APPROVE_OPTION) 
				{
				//inserisco nella stringa la path del file scelto
				   String stringa = fc.getSelectedFile().getPath();
				   lblEsercizioNuovo.setText(stringa);
				   
				}
			}
		});
		btnScegliFile.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		btnScegliFile.setBounds(10, 109, 90, 20);
		panel_3.add(btnScegliFile);
		
		lblEsercizioNuovo = new JLabel("");
		lblEsercizioNuovo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblEsercizioNuovo.setBounds(110, 107, 76, 22);
		panel_3.add(lblEsercizioNuovo);
		
		//SALVA ESERCIZIO_________________________________________________________________________________________________________________________________________________________________________________________
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {c.AddEsercizio(txtNomeEsercizio.getText(), lblEsercizioNuovo.getText(), cmbGruppo.getSelectedItem().toString());} 
				catch (IOException e1) { e1.printStackTrace();}
			}
		});
		btnSalva.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		btnSalva.setBounds(53, 141, 80, 20);
		panel_3.add(btnSalva);
		
		cmbGruppo = new JComboBox();
		cmbGruppo.setModel(new DefaultComboBoxModel(new String[] {"(default)", "Petto", "Dorsali", "Spalel", "Tricipiti", "Bicipiti", "Gambe", "Addome", "Correttiva", "Stretching", "Cardio Fitness"}));
		cmbGruppo.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		cmbGruppo.setBackground(SystemColor.text);
		cmbGruppo.setBounds(106, 58, 80, 20);
		panel_3.add(cmbGruppo);
		
		JLabel lblGruppoMuscolare = new JLabel("Gruppo muscolare");
		lblGruppoMuscolare.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblGruppoMuscolare.setBounds(98, 37, 97, 20);
		panel_3.add(lblGruppoMuscolare);
		
		panel_4 = new Panel();
		panel_4.setBackground(SystemColor.menu);
		panel_4.setForeground(SystemColor.controlText);
		panel_4.setBounds(995, 214, 195, 370);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblListaEsercizi = new JLabel("Lista esercizi");
		lblListaEsercizi.setBounds(61, 11, 83, 20);
		lblListaEsercizi.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		panel_4.add(lblListaEsercizi);
		
		JButton btnSelezionaEsercizio = new JButton("Seleziona esercizio");
		btnSelezionaEsercizio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSelezionaEsercizio.setBounds(26, 336, 142, 23);
		panel_4.add(btnSelezionaEsercizio);
		
		panel_5 = new Panel();
		panel_5.setForeground(SystemColor.controlText);
		panel_5.setBackground(SystemColor.menu);
		panel_5.setBounds(181, 40, 808, 544);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(SystemColor.text);
		panel_6.setBounds(10, 122, 785, 180);
		
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblE_1_1 = new JLabel("Esercizio 1");
		lblE_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
	
		lblE_1_1.setEnabled(false);
		//lblE_1_1.setIcon(new ImageIcon(c.gruppiMuscolari[2].esercizi.getFirst().img));
		lblE_1_1.setForeground(Color.RED);
		lblE_1_1.setBackground(Color.RED);
		lblE_1_1.setBounds(5, 5, 50, 50);
		panel_6.add(lblE_1_1);
		
		JLabel lblE_1_2 = new JLabel("Esercizio 2");
		lblE_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_2.setForeground(Color.BLACK);
		lblE_1_2.setEnabled(false);
		lblE_1_2.setBackground(Color.BLACK);
		lblE_1_2.setBounds(70, 5, 50, 50);
		panel_6.add(lblE_1_2);
		
		JLabel lblE_1_3 = new JLabel("Esercizio 3");
		lblE_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_3.setForeground(Color.BLACK);
		lblE_1_3.setEnabled(false);
		lblE_1_3.setBackground(Color.BLACK);
		lblE_1_3.setBounds(135, 5, 50, 50);
		panel_6.add(lblE_1_3);
		
		JLabel lblE_1_4 = new JLabel("Esercizio 4");
		lblE_1_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_4.setForeground(Color.BLACK);
		lblE_1_4.setEnabled(false);
		lblE_1_4.setBackground(Color.BLACK);
		lblE_1_4.setBounds(200, 5, 50, 50);
		panel_6.add(lblE_1_4);
		
		JLabel lblE_1_5 = new JLabel("Esercizio 5");
		lblE_1_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_5.setForeground(Color.BLACK);
		lblE_1_5.setEnabled(false);
		lblE_1_5.setBackground(Color.BLACK);
		lblE_1_5.setBounds(265, 5, 50, 50);
		panel_6.add(lblE_1_5);
		
		JLabel lblE_1_6 = new JLabel("Esercizio 6");
		lblE_1_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_6.setForeground(Color.BLACK);
		lblE_1_6.setEnabled(false);
		lblE_1_6.setBackground(Color.BLACK);
		lblE_1_6.setBounds(330, 5, 50, 50);
		panel_6.add(lblE_1_6);
		
		JLabel lblE_1_7 = new JLabel("Esercizio 7");
		lblE_1_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_7.setForeground(Color.BLACK);
		lblE_1_7.setEnabled(false);
		lblE_1_7.setBackground(Color.BLACK);
		lblE_1_7.setBounds(395, 5, 50, 50);
		panel_6.add(lblE_1_7);
		
		JLabel lblE_1_8 = new JLabel("Esercizio 8");
		lblE_1_8.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_8.setForeground(Color.BLACK);
		lblE_1_8.setEnabled(false);
		lblE_1_8.setBackground(Color.BLACK);
		lblE_1_8.setBounds(460, 5, 50, 50);
		panel_6.add(lblE_1_8);
		
		JLabel lblE_1_9 = new JLabel("Esercizio 9");
		lblE_1_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_9.setForeground(Color.BLACK);
		lblE_1_9.setEnabled(false);
		lblE_1_9.setBackground(Color.BLACK);
		lblE_1_9.setBounds(525, 5, 50, 50);
		panel_6.add(lblE_1_9);
		
		JLabel lblE_1_10 = new JLabel("Esercizio 10");
		lblE_1_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_10.setForeground(Color.BLACK);
		lblE_1_10.setEnabled(false);
		lblE_1_10.setBackground(Color.BLACK);
		lblE_1_10.setBounds(590, 5, 50, 50);
		panel_6.add(lblE_1_10);
		
		JLabel lblE_1_11 = new JLabel("Esercizio 11");
		lblE_1_11.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_11.setForeground(Color.BLACK);
		lblE_1_11.setEnabled(false);
		lblE_1_11.setBackground(Color.BLACK);
		lblE_1_11.setBounds(655, 5, 50, 50);
		panel_6.add(lblE_1_11);
		
		JLabel lblE_1_12 = new JLabel("Esercizio 12");
		lblE_1_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_12.setForeground(Color.BLACK);
		lblE_1_12.setEnabled(false);
		lblE_1_12.setBackground(Color.BLACK);
		lblE_1_12.setBounds(720, 5, 50, 50);
		panel_6.add(lblE_1_12);
		
		JLabel lblE_1_13 = new JLabel("Esercizio 13");
		lblE_1_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_13.setForeground(Color.BLACK);
		lblE_1_13.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_13.setEnabled(false);
		lblE_1_13.setBackground(Color.BLACK);
		lblE_1_13.setBounds(5, 90, 50, 50);
		panel_6.add(lblE_1_13);
		
		JLabel lblE_1_14 = new JLabel("Esercizio 14");
		lblE_1_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_14.setForeground(Color.BLACK);
		lblE_1_14.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_14.setEnabled(false);
		lblE_1_14.setBackground(Color.BLACK);
		lblE_1_14.setBounds(70, 90, 50, 50);
		panel_6.add(lblE_1_14);
		
		JLabel lblE_1_15 = new JLabel("Esercizio 15");
		lblE_1_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_15.setForeground(Color.BLACK);
		lblE_1_15.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_15.setEnabled(false);
		lblE_1_15.setBackground(Color.BLACK);
		lblE_1_15.setBounds(135, 90, 50, 50);
		panel_6.add(lblE_1_15);
		
		JLabel lblE_1_16 = new JLabel("Esercizio 16");
		lblE_1_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_16.setForeground(Color.BLACK);
		lblE_1_16.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_16.setEnabled(false);
		lblE_1_16.setBackground(Color.BLACK);
		lblE_1_16.setBounds(200, 90, 50, 50);
		panel_6.add(lblE_1_16);
		
		JLabel lblE_1_17 = new JLabel("Esercizio 17");
		lblE_1_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_17.setForeground(Color.BLACK);
		lblE_1_17.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_17.setEnabled(false);
		lblE_1_17.setBackground(Color.BLACK);
		lblE_1_17.setBounds(265, 90, 50, 50);
		panel_6.add(lblE_1_17);
		
		JLabel lblE_1_18 = new JLabel("Esercizio 18");
		lblE_1_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_18.setForeground(Color.BLACK);
		lblE_1_18.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_18.setEnabled(false);
		lblE_1_18.setBackground(Color.BLACK);
		lblE_1_18.setBounds(330, 90, 50, 50);
		panel_6.add(lblE_1_18);
		
		JLabel lblE_1_19 = new JLabel("Esercizio 19");
		lblE_1_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_19.setForeground(Color.BLACK);
		lblE_1_19.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_19.setEnabled(false);
		lblE_1_19.setBackground(Color.BLACK);
		lblE_1_19.setBounds(395, 90, 50, 50);
		panel_6.add(lblE_1_19);
		
		JLabel lblE_1_20 = new JLabel("Esercizio 20");
		lblE_1_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_20.setForeground(Color.BLACK);
		lblE_1_20.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_20.setEnabled(false);
		lblE_1_20.setBackground(Color.BLACK);
		lblE_1_20.setBounds(460, 90, 50, 50);
		panel_6.add(lblE_1_20);
		
		JLabel lblE_1_21 = new JLabel("Esercizio 21");
		lblE_1_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_21.setForeground(Color.BLACK);
		lblE_1_21.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_21.setEnabled(false);
		lblE_1_21.setBackground(Color.BLACK);
		lblE_1_21.setBounds(525, 90, 50, 50);
		panel_6.add(lblE_1_21);
		
		JLabel lblE_1_22 = new JLabel("Esercizio 22");
		lblE_1_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_22.setForeground(Color.BLACK);
		lblE_1_22.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_22.setEnabled(false);
		lblE_1_22.setBackground(Color.BLACK);
		lblE_1_22.setBounds(590, 90, 50, 50);
		panel_6.add(lblE_1_22);
		
		JLabel lblE_1_23 = new JLabel("Esercizio 23");
		lblE_1_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_23.setForeground(Color.BLACK);
		lblE_1_23.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_23.setEnabled(false);
		lblE_1_23.setBackground(Color.BLACK);
		lblE_1_23.setBounds(655, 90, 50, 50);
		panel_6.add(lblE_1_23);
		
		JLabel lblE_1_24 = new JLabel("Esercizio 24");
		lblE_1_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1_24.setForeground(Color.BLACK);
		lblE_1_24.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblE_1_24.setEnabled(false);
		lblE_1_24.setBackground(Color.BLACK);
		lblE_1_24.setBounds(720, 90, 50, 50);
		panel_6.add(lblE_1_24);
		
		JLabel lblGiorno = new JLabel("Giorno:");
		lblGiorno.setBounds(10, 102, 207, 14);
		panel_5.add(lblGiorno);
		
		JLabel lblOre = new JLabel("Ore:");
		lblOre.setBounds(227, 102, 97, 14);
		panel_5.add(lblOre);
		
		lblScheda2 = new JLabel("Scheda allenamento di:");
		lblScheda2.setBounds(368, 308, 430, 14);
		panel_5.add(lblScheda2);
		
		JLabel lblGiorno_2 = new JLabel("Giorno:");
		lblGiorno_2.setBounds(10, 308, 207, 14);
		panel_5.add(lblGiorno_2);
		
		JLabel lblOre_2 = new JLabel("Ore:");
		lblOre_2.setBounds(227, 308, 97, 14);
		panel_5.add(lblOre_2);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 328, 785, 180);
		panel_5.add(panel_7);
		
		JLabel label_5 = new JLabel("Esercizio 1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_5.setEnabled(false);
		label_5.setBackground(Color.RED);
		label_5.setBounds(5, 5, 50, 50);
		panel_7.add(label_5);
		
		JLabel label_6 = new JLabel("Esercizio 2");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_6.setEnabled(false);
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(70, 5, 50, 50);
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("Esercizio 3");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_7.setEnabled(false);
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(135, 5, 50, 50);
		panel_7.add(label_7);
		
		JLabel label_8 = new JLabel("Esercizio 4");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_8.setEnabled(false);
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(200, 5, 50, 50);
		panel_7.add(label_8);
		
		JLabel label_9 = new JLabel("Esercizio 5");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_9.setEnabled(false);
		label_9.setBackground(Color.BLACK);
		label_9.setBounds(265, 5, 50, 50);
		panel_7.add(label_9);
		
		JLabel label_10 = new JLabel("Esercizio 6");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_10.setEnabled(false);
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(330, 5, 50, 50);
		panel_7.add(label_10);
		
		JLabel label_11 = new JLabel("Esercizio 7");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_11.setEnabled(false);
		label_11.setBackground(Color.BLACK);
		label_11.setBounds(395, 5, 50, 50);
		panel_7.add(label_11);
		
		JLabel label_12 = new JLabel("Esercizio 8");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_12.setEnabled(false);
		label_12.setBackground(Color.BLACK);
		label_12.setBounds(460, 5, 50, 50);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("Esercizio 9");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_13.setEnabled(false);
		label_13.setBackground(Color.BLACK);
		label_13.setBounds(525, 5, 50, 50);
		panel_7.add(label_13);
		
		JLabel label_14 = new JLabel("Esercizio 10");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_14.setEnabled(false);
		label_14.setBackground(Color.BLACK);
		label_14.setBounds(590, 5, 50, 50);
		panel_7.add(label_14);
		
		JLabel label_15 = new JLabel("Esercizio 11");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_15.setEnabled(false);
		label_15.setBackground(Color.BLACK);
		label_15.setBounds(655, 5, 50, 50);
		panel_7.add(label_15);
		
		JLabel label_16 = new JLabel("Esercizio 12");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_16.setEnabled(false);
		label_16.setBackground(Color.BLACK);
		label_16.setBounds(720, 5, 50, 50);
		panel_7.add(label_16);
		
		JLabel label_17 = new JLabel("Esercizio 13");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_17.setEnabled(false);
		label_17.setBackground(Color.BLACK);
		label_17.setBounds(5, 90, 50, 50);
		panel_7.add(label_17);
		
		JLabel label_18 = new JLabel("Esercizio 14");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_18.setEnabled(false);
		label_18.setBackground(Color.BLACK);
		label_18.setBounds(70, 90, 50, 50);
		panel_7.add(label_18);
		
		JLabel label_19 = new JLabel("Esercizio 15");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.BLACK);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_19.setEnabled(false);
		label_19.setBackground(Color.BLACK);
		label_19.setBounds(135, 90, 50, 50);
		panel_7.add(label_19);
		
		JLabel label_20 = new JLabel("Esercizio 16");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.BLACK);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_20.setEnabled(false);
		label_20.setBackground(Color.BLACK);
		label_20.setBounds(200, 90, 50, 50);
		panel_7.add(label_20);
		
		JLabel label_21 = new JLabel("Esercizio 17");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.BLACK);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_21.setEnabled(false);
		label_21.setBackground(Color.BLACK);
		label_21.setBounds(265, 90, 50, 50);
		panel_7.add(label_21);
		
		JLabel label_22 = new JLabel("Esercizio 18");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.BLACK);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_22.setEnabled(false);
		label_22.setBackground(Color.BLACK);
		label_22.setBounds(330, 90, 50, 50);
		panel_7.add(label_22);
		
		JLabel label_23 = new JLabel("Esercizio 19");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.BLACK);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_23.setEnabled(false);
		label_23.setBackground(Color.BLACK);
		label_23.setBounds(395, 90, 50, 50);
		panel_7.add(label_23);
		
		JLabel label_24 = new JLabel("Esercizio 20");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(Color.BLACK);
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_24.setEnabled(false);
		label_24.setBackground(Color.BLACK);
		label_24.setBounds(460, 90, 50, 50);
		panel_7.add(label_24);
		
		JLabel label_25 = new JLabel("Esercizio 21");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.BLACK);
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_25.setEnabled(false);
		label_25.setBackground(Color.BLACK);
		label_25.setBounds(525, 90, 50, 50);
		panel_7.add(label_25);
		
		JLabel label_26 = new JLabel("Esercizio 22");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(Color.BLACK);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_26.setEnabled(false);
		label_26.setBackground(Color.BLACK);
		label_26.setBounds(590, 90, 50, 50);
		panel_7.add(label_26);
		
		JLabel label_27 = new JLabel("Esercizio 23");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setForeground(Color.BLACK);
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_27.setEnabled(false);
		label_27.setBackground(Color.BLACK);
		label_27.setBounds(655, 90, 50, 50);
		panel_7.add(label_27);
		
		JLabel label_28 = new JLabel("Esercizio 24");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setForeground(Color.BLACK);
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_28.setEnabled(false);
		label_28.setBackground(Color.BLACK);
		label_28.setBounds(720, 90, 50, 50);
		panel_7.add(label_28);
		
		Panel panel_8 = new Panel();
		panel_8.setBackground(SystemColor.inactiveCaption);
		panel_8.setBounds(10, 10, 785, 86);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		JComboBox cmbGiorno = new JComboBox();
		JComboBox cmbAnno = new JComboBox();
		cmbAnno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cmbAnno.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cmbAnno.setBounds(131, 51, 50, 20);
		panel_8.add(cmbAnno);
		
		//COMBO MESE____________________________________________________________________________________________________________________________________________________________________________
		JComboBox cmbMese = new JComboBox();
		cmbMese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch((String) cmbMese.getSelectedItem()) {
				case "2": if( (Integer.parseInt((String) cmbAnno.getSelectedItem()) % 4 == 0 && Integer.parseInt((String) cmbAnno.getSelectedItem()) % 100 !=0)  || ((Integer.parseInt((String) cmbAnno.getSelectedItem())) %400 ==0)) 
							cmbGiorno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
						  else cmbGiorno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"})); 
						  break;
				case "4": case "6": case "9": case "11": cmbGiorno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"})); break;
				default: cmbGiorno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"})); break;
				}
			}
		});
		cmbMese.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbMese.setBounds(192, 13, 50, 20);
		panel_8.add(cmbMese);
		
		
		cmbGiorno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbGiorno.setBounds(131, 13, 50, 20);
		panel_8.add(cmbGiorno);
		
		//SelezionaCliente_________________________________________________________________________________________________________________________________________
		JButton btnSelezionaCliente = new JButton("Seleziona cliente");
		btnSelezionaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblScheda1.setText("Scheda allenamento di:" + "   " + cmbSCliente.getSelectedItem().toString().toUpperCase());
				lblScheda2.setText("Scheda allenamento di:" + "   " + cmbSCliente.getSelectedItem().toString().toUpperCase());
				
				
			}
		});
		btnSelezionaCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSelezionaCliente.setBounds(10, 50, 111, 23);
		panel_8.add(btnSelezionaCliente);
		
		JLabel lblGiorno_1 = new JLabel("Giorno");
		lblGiorno_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGiorno_1.setBounds(140, 0, 46, 14);
		panel_8.add(lblGiorno_1);
		
		JLabel lblMese = new JLabel("Mese");
		lblMese.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMese.setBounds(206, 0, 46, 14);
		panel_8.add(lblMese);
		
		JLabel lblAnno = new JLabel("Anno");
		lblAnno.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAnno.setBounds(141, 39, 46, 14);
		panel_8.add(lblAnno);
		
		JButton btnInserisciDataPrima = new JButton("Inserisci data  I");
		btnInserisciDataPrima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar cal = Calendar.getInstance();
				cal.set(Integer.parseInt(cmbAnno.getSelectedItem().toString()), Integer.parseInt(cmbMese.getSelectedItem().toString()), Integer.parseInt(cmbGiorno.getSelectedItem().toString()));
				lblGiorno.setText("Giorno:  " + giorno(cal.getTime().getDay()) +  " " + cal.getTime().getDate()+  "/" + cal.getTime().getMonth() +  "/" + (Integer)(cal.getTime().getYear()+1900));
				lblOre.setText("Ore:  " + cmbOra.getSelectedItem().toString() +"."+ cmbMinuti.getSelectedItem().toString());
				
				
			}
		});
		btnInserisciDataPrima.setBounds(280, 11, 120, 25);
		panel_8.add(btnInserisciDataPrima);
		
		JButton btnInserisciDataSecondascheda = new JButton("Inserisci data II\r\n");
		btnInserisciDataSecondascheda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				//System.out.println(cal.getInstance());
				cal.set(Integer.parseInt(cmbAnno.getSelectedItem().toString()), Integer.parseInt(cmbMese.getSelectedItem().toString()), Integer.parseInt(cmbGiorno.getSelectedItem().toString()));
				lblGiorno_2.setText("Giorno:  " + giorno(cal.getTime().getDay()) +  " " + cal.getTime().getDate()+  "/" + cal.getTime().getMonth() +  "/" + (Integer) (cal.getTime().getYear()+1900));
				lblOre.setText("Ore:  " + cmbOra.getSelectedItem().toString() +"."+ cmbMinuti.getSelectedItem().toString());
			}
		});
		btnInserisciDataSecondascheda.setBounds(280, 51, 120, 25);
		panel_8.add(btnInserisciDataSecondascheda);
		
		cmbSCliente = new JComboBox();
		ArrayList<String> l = new ArrayList<String>();
		for(Cliente cl: c.clienti) l.add(cl.toString()); 
		
		cmbSCliente.setModel(new DefaultComboBoxModel(l.toArray()));
		cmbSCliente.setBounds(10, 19, 111, 20);
		panel_8.add(cmbSCliente);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"", "Esercizio 1", "Esercizio 2", "Esercizio 3", "Esercizio 4", "Esercizio 5", "Esercizio 6", "Esercizio 7", "Esercizio 8", "Esercizio 9", "Esercizio 10", "Esercizio 11", "Esercizio 12", "Esercizio 13", "Esercizio 14", "Esercizio 15", "Esercizio 16", "Esercizio 17", "Esercizio 18", "Esercizio 19", "Esercizio 20", "Esercizio 21", "Esercizio 22", "Esercizio 23", "Esercizio 24"}));
		comboBox_5.setBounds(454, 8, 84, 20);
		panel_8.add(comboBox_5);
		
		JLabel lblNEsercizio = new JLabel("Esercizio");
		lblNEsercizio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNEsercizio.setBounds(410, 11, 61, 14);
		panel_8.add(lblNEsercizio);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(618, 8, 50, 20);
		panel_8.add(spinner);
		
		JLabel lblSerie = new JLabel("Serie");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSerie.setBounds(570, 11, 61, 14);
		panel_8.add(lblSerie);
		
		JLabel lblRipetizioni = new JLabel("Ripetizioni");
		lblRipetizioni.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblRipetizioni.setBounds(678, 11, 61, 14);
		panel_8.add(lblRipetizioni);
		
		JLabel lblMinuti = new JLabel("Velocit\u00E0");
		lblMinuti.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMinuti.setBounds(570, 39, 72, 14);
		panel_8.add(lblMinuti);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(730, 8, 50, 20);
		panel_8.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(510, 36, 50, 20);
		panel_8.add(spinner_2);
		
		JLabel label_30 = new JLabel("Minuti");
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_30.setBounds(464, 39, 61, 14);
		panel_8.add(label_30);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(618, 36, 50, 20);
		panel_8.add(spinner_3);
		
		JLabel lblEsercizio = new JLabel("Esercizio ");
		lblEsercizio.setIcon(new ImageIcon("C:\\Users\\fafic\\Desktop\\Gianpiero\\Gruppi Muscolari\\Spalle\\Spalle001.jpg"));
		lblEsercizio.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsercizio.setForeground(SystemColor.controlText);
		lblEsercizio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEsercizio.setBackground(SystemColor.controlText);
		lblEsercizio.setBounds(410, 33, 50, 50);
		panel_8.add(lblEsercizio);
		
		JLabel lblResistenza = new JLabel("Resistenza");
		lblResistenza.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblResistenza.setBounds(678, 39, 61, 14);
		panel_8.add(lblResistenza);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(730, 36, 50, 20);
		panel_8.add(spinner_4);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNote.setBounds(464, 67, 46, 14);
		panel_8.add(lblNote);
		
		textField_2 = new JTextField();
		textField_2.setBounds(510, 64, 80, 20);
		panel_8.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(618, 60, 162, 20);
		panel_8.add(btnAggiungi);
		
		JLabel lblOraEMiunuti = new JLabel("Ora e Miunuti");
		lblOraEMiunuti.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblOraEMiunuti.setBounds(198, 39, 72, 14);
		panel_8.add(lblOraEMiunuti);
		
		cmbOra = new JComboBox();
		cmbOra.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cmbOra.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cmbOra.setBounds(191, 51, 35, 20);
		panel_8.add(cmbOra);
		
		cmbMinuti = new JComboBox();
		cmbMinuti.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		cmbMinuti.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cmbMinuti.setBounds(237, 51, 35, 20);
		panel_8.add(cmbMinuti);
		
		lblScheda1 = new JLabel("Scheda allenamento di:");
		lblScheda1.setBounds(368, 102, 427, 14);
		panel_5.add(lblScheda1);
		
		JButton btnSalvaSchede = new JButton("Salva schede");
		btnSalvaSchede.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvaSchede.setBounds(653, 514, 142, 23);
		panel_5.add(btnSalvaSchede);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnNewMenu, mntmNuovoCliente, mntmNewMenuItem_1, mntmNewMenuItem, mnNewMenu_1, mntmNewMenuItem_4, mntmModificaScheda, mntmVisualizzaScheda, mnNewMenu_2, mntmNewMenuItem_3, mnGruppiMuscolari, mntmNewMenuItem_2, mntmNewMenuItem_5, mntmNewMenuItem_6, mntmGambe, mntmTricitpiti, mntmGambe_1, mntmAddomeFianchiE, mntmCorrettiva, mntmNewMenuItem_8, mntmNewMenuItem_7, panel_2, txtNomeCliente, lblNuovoCliente, txtCognomeCliente, plsSalvaCliente, lblNome, lblCognome, panel_1, textAreaClienti, lblListaClienti, panel_3, label_1, txtNomeEsercizio, lblSelezionaImmagine, lblNuovoEsercizio, btnScegliFile, lblEsercizioNuovo, btnSalva, cmbGruppo, lblGruppoMuscolare, panel_4, lblListaEsercizi}));
		frmCentroKinesiologico.setForeground(Color.WHITE);
		frmCentroKinesiologico.setTitle("CENTRO KINESIOLOGICO");
		frmCentroKinesiologico.setBounds(100, 100, 1204, 623);
		frmCentroKinesiologico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private String giorno(int gg) {
		String giorno = "";
		switch(gg) {
		case 1: giorno =  "Lunedì"; break;
		case 2: giorno = "Martedì"; break;
		case 3: giorno = "Mercoledì"; break;
		case 4: giorno = "Giovedì"; break;
		case 5: giorno = "Venerdì"; break;
		case 6: giorno = "Sabato"; break;
		case 7: giorno = "Domenica"; break;
		}
		return giorno.toUpperCase();
	}
}
