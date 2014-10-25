package br.edu.fcsl.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import br.edu.fcsl.controller.Utils;
import br.edu.fcsl.entidade.Subrede;

@SuppressWarnings({ "serial", "unused" })
public class CalcularSubrede extends JFrame implements ActionListener {

	private static final String SERIAL = "serial";
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenu mnEditar;
	private JMenu mnOpcoes;
	private JLabel lblIpRede;
	private JButton btnVerificarConn;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblMscaraRede;
	private JLabel lblNumSubredes;
	private JButton btnCalcularSubrede;
	private JPanel panelEntrada;
	private JPanel panelSaida;
	private JTable table1;
	private JScrollPane scrollPane;
	private JTable table;
	private JMenuItem mntmSair;
	private JMenu mnAjuda;
	private JMenuItem mntmLerTutorial;
	private JMenuItem mntmLimparTela;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmImportar;
	private JMenuItem mntmExportar;
	private JMenuItem mntmLocalizar;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textIpRede2;
	private JTextField textIpRede3;
	private JTextField textIpRede4;
	private JList list;
	private JComboBox comboBoxMascaraRede;
	private JComboBox comboBoxNumSubredes;
	private JPanel panelClasseDeRede;
	private JRadioButton rdbtnClasseA;
	private JRadioButton rdbtnClasseB;
	private JRadioButton rdbtnClasseC;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JComboBox comboBoxIpRede;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcularSubrede frame = new CalcularSubrede();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings(SERIAL)
	public CalcularSubrede() {
		SubstanceLookAndFeel.setSkin(new MeuSkin());
		setTitle("SubRede's System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 743);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmSalvar = new JMenuItem("Salvar");
		mnArquivo.add(mntmSalvar);
		
		mntmImportar = new JMenuItem("Importar");
		mnArquivo.add(mntmImportar);
		
		mntmExportar = new JMenuItem("Exportar");
		mntmExportar.addActionListener(this);
		mnArquivo.add(mntmExportar);
		
		mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		mntmSair.addActionListener(this);
		
		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		mntmLimparTela = new JMenuItem("Limpar tela");
		mnEditar.add(mntmLimparTela);
		
		mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		mntmLocalizar = new JMenuItem("Localizar");
		mnOpcoes.add(mntmLocalizar);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmLerTutorial = new JMenuItem("Ler tutorial");
		mnAjuda.add(mntmLerTutorial);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelEntrada = new JPanel();
		panelEntrada.setBorder(new TitledBorder(null, "Entrada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblIpRede = new JLabel("IP de Rede:");
		
		lblMscaraRede = new JLabel("Máscara de Rede:");
		
		lblNumSubredes = new JLabel("Nº de sub redes:");
		
		btnCalcularSubrede = new JButton("Calcular sub rede IPv4");
		btnCalcularSubrede.addActionListener(this);
		
		textIpRede2 = new JTextField();
		textIpRede2.setColumns(3);
		
		textIpRede3 = new JTextField();
		textIpRede3.setColumns(3);
		
		textIpRede4 = new JTextField();
		textIpRede4.setColumns(3);
		
		list = new JList();
		
		comboBoxMascaraRede = new JComboBox();
		
		comboBoxNumSubredes = new JComboBox();
		
		btnVerificarConn = new JButton("Checar Conexões");
		btnVerificarConn.addActionListener(this);
		buttonGroup.add(btnVerificarConn);
		
		comboBoxIpRede = new JComboBox();
		GroupLayout gl_panelEntrada = new GroupLayout(panelEntrada);
		gl_panelEntrada.setHorizontalGroup(
			gl_panelEntrada.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEntrada.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEntrada.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNumSubredes)
						.addComponent(lblIpRede)
						.addComponent(lblMscaraRede))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEntrada.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEntrada.createSequentialGroup()
							.addComponent(comboBoxMascaraRede, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(btnCalcularSubrede, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelEntrada.createSequentialGroup()
							.addGroup(gl_panelEntrada.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBoxNumSubredes, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxIpRede, 0, 84, Short.MAX_VALUE))
							.addGroup(gl_panelEntrada.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelEntrada.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textIpRede2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textIpRede3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textIpRede4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
									.addComponent(btnVerificarConn))
								.addGroup(Alignment.TRAILING, gl_panelEntrada.createSequentialGroup()
									.addGap(107)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panelEntrada.setVerticalGroup(
			gl_panelEntrada.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEntrada.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEntrada.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelEntrada.createSequentialGroup()
							.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIpRede)
								.addComponent(btnVerificarConn)
								.addComponent(comboBoxIpRede, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textIpRede2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textIpRede3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textIpRede4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxNumSubredes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumSubredes))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxMascaraRede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCalcularSubrede)
								.addComponent(lblMscaraRede)))
						.addGroup(gl_panelEntrada.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(38)))
					.addGap(31))
		);
		panelEntrada.setLayout(gl_panelEntrada);
		
		panelSaida = new JPanel();
		panelSaida.setBorder(new TitledBorder(null, "Sa\u00EDda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		scrollPane = new JScrollPane();
		
				table1 = new JTable();
				scrollPane.setViewportView(table1);
				table1.setModel(new DefaultTableModel(
					new Object[][] {
						{" Sub rede", "        IP Inicial                  IP Final", "  IP Sub Rede              IP Broadcast", "        IP Inicial                  IP Final"},
					},
					new String[] {
						"", "Faixas de IPs", "IPs especiais da subrede", "Faixas de IPs utiliz\u00E1veis"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table1.getColumnModel().getColumn(0).setPreferredWidth(80);
				table1.getColumnModel().getColumn(1).setPreferredWidth(250);
				table1.getColumnModel().getColumn(2).setPreferredWidth(250);
				table1.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Sub rede", "IP Inicial", "IP Final", "IP sub rede", "IP Broadcast", "IP Inicial", "IP Final"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		GroupLayout gl_panelSaida = new GroupLayout(panelSaida);
		gl_panelSaida.setHorizontalGroup(
			gl_panelSaida.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSaida.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSaida.createParallelGroup(Alignment.TRAILING)
						.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSaida.setVerticalGroup(
			gl_panelSaida.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSaida.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(415, Short.MAX_VALUE))
		);
		panelSaida.setLayout(gl_panelSaida);
		
		panelClasseDeRede = new JPanel();
		panelClasseDeRede.setBorder(new TitledBorder(null, "Classe de Rede", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelSaida, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelClasseDeRede, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelEntrada, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)))
					.addGap(202))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelClasseDeRede, 0, 0, Short.MAX_VALUE)
						.addComponent(panelEntrada, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelSaida, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		rdbtnClasseA = new JRadioButton("Classe A (1.0.0.0 - 126.255.255.255) ");
		buttonGroup_2.add(rdbtnClasseA);
		
		rdbtnClasseB = new JRadioButton("Classe B (128.0.0.0 - 191.255.255.255) ");
		buttonGroup_2.add(rdbtnClasseB);
		
		rdbtnClasseC = new JRadioButton("Classe C (192.0.0.0 - 223.255.255.255)");
		rdbtnClasseC.setSelected(true);
		buttonGroup_2.add(rdbtnClasseC);
		GroupLayout gl_panelClasseDeRede = new GroupLayout(panelClasseDeRede);
		gl_panelClasseDeRede.setHorizontalGroup(
			gl_panelClasseDeRede.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClasseDeRede.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelClasseDeRede.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnClasseA)
						.addComponent(rdbtnClasseB)
						.addComponent(rdbtnClasseC))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_panelClasseDeRede.setVerticalGroup(
			gl_panelClasseDeRede.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelClasseDeRede.createSequentialGroup()
					.addComponent(rdbtnClasseA)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnClasseB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnClasseC)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panelClasseDeRede.setLayout(gl_panelClasseDeRede);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmExportar) {
			do_mntmExportar_actionPerformed(e);
		}
		if (e.getSource() == mntmSair) {
			do_mntmSair_actionPerformed(e);
		}
		if (e.getSource() == btnCalcularSubrede) {
			do_btnCalcularSubrede_actionPerformed(e);
		}
		if (e.getSource() == btnVerificarConn) {
			try {
				do_btnVerificarConn_actionPerformed(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	protected void do_btnVerificarConn_actionPerformed(ActionEvent e) throws UnknownHostException,
																			 IOException {
		
		VerificaComunicacao vc = new VerificaComunicacao();
		vc.setLocationRelativeTo(null);
		vc.setVisible(true);
		
	}

	protected void do_btnCalcularSubrede_actionPerformed(ActionEvent e) {
		String ip = String.valueOf(comboBoxIpRede.getSelectedIndex());
		String mask = String.valueOf(comboBoxMascaraRede.getSelectedIndex());
		int numSubredes = comboBoxNumSubredes.getSelectedIndex();

		if (ip.length() < 4) {
			JOptionPane.showMessageDialog(null, "Informe um IP válido!");
		} else if (mask.length() < 4) {
			JOptionPane.showMessageDialog(null, "Informe uma Máscara de Rede válida!");
		} else {
			Utils utils = new Utils();
			utils.calcularSubrede(ip, mask, numSubredes);

			Subrede sr = new Subrede();
			String subrede = null;
			String faixaIpInicial = sr.getFaixaIpInicial();
			String faixaIpFinal = sr.getFaixaIpFinal();
			String ipSubrede = sr.getIpSubrede();
			String ipBroadcast = sr.getIpBroadcast();
			String ipInicialUtil = sr.getIpInicialUtil();
			String ipFinalUtil = sr.getIpFinalUtil();

			table.setModel(new DefaultTableModel(new Object[][] { { subrede,
					faixaIpInicial, faixaIpFinal, ipSubrede, ipBroadcast,
					ipInicialUtil, ipFinalUtil }, }, new String[] { "Sub rede",
					"IP Inicial", "IP Final", "IP sub rede", "IP Broadcast",
					"IP Inicial", "IP Final" }));

			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(75);
			table.getColumnModel().getColumn(2).setPreferredWidth(75);
			table.getColumnModel().getColumn(3).setPreferredWidth(75);
			table.getColumnModel().getColumn(4).setPreferredWidth(75);
			table.getColumnModel().getColumn(5).setPreferredWidth(75);
			table.getColumnModel().getColumn(6).setPreferredWidth(75);
		}

	}
	
	protected void do_mntmSair_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_mntmExportar_actionPerformed(ActionEvent e) {
		JFileChooser jfile = new JFileChooser();
		
//		if (jfile.showSaveDialog(salvar) != JFileChooser.APPROVE_OPTION) {
//			return;
//		}

		FileWriter fr;
		try {
			fr = new FileWriter(jfile.getSelectedFile().getPath()
					+ ".txt");
		} catch (IOException e1) {
			
			e1.printStackTrace();
			return;
		}
		PrintWriter pw = new PrintWriter(fr);
		
	}
}
