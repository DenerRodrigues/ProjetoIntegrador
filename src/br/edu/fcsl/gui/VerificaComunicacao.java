package br.edu.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import br.edu.fcsl.controller.Utils;

public class VerificaComunicacao extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JPanel abaPing;
	private JLabel lblIpRede;
	private JTextField textIpRede;
	private JButton btnVerificaComunicacao;
	private JLabel lblExIp;
	private JRadioButton rdbtnPingIlimitado;
	private JRadioButton rdbtnPingLimitado;
	private JTextField textQtdPing;
	private JLabel lblQtdPing;
	private JPanel panel;
	private JPanel panelTerminal;
	private JTextArea textTerminal;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerificaComunicacao dialog = new VerificaComunicacao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerificaComunicacao() {
		setTitle("SubRede's System");
		setModal(true);
		setBounds(100, 100, 785, 551);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 557, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
		);
		
		abaPing = new JPanel();
		abaPing.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPane.addTab("Ping", null, abaPing, null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panelTerminal = new JPanel();
		panelTerminal.setBackground(Color.BLACK);
		panelTerminal.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Terminal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GroupLayout gl_abaPing = new GroupLayout(abaPing);
		gl_abaPing.setHorizontalGroup(
			gl_abaPing.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_abaPing.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_abaPing.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTerminal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_abaPing.setVerticalGroup(
			gl_abaPing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaPing.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelTerminal, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textTerminal = new JTextArea();
		textTerminal.setEditable(false);
		textTerminal.setLineWrap(true);
		textTerminal.setForeground(Color.GREEN);
		textTerminal.setBackground(Color.BLACK);
		GroupLayout gl_panelTerminal = new GroupLayout(panelTerminal);
		gl_panelTerminal.setHorizontalGroup(
			gl_panelTerminal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTerminal.createSequentialGroup()
					.addContainerGap()
					.addComponent(textTerminal, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelTerminal.setVerticalGroup(
			gl_panelTerminal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTerminal.createSequentialGroup()
					.addComponent(textTerminal, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelTerminal.setLayout(gl_panelTerminal);
		
		lblIpRede = new JLabel("Informe o endereço de rede para executar o ping.");
		
		textIpRede = new JTextField();
		textIpRede.setColumns(10);
		
		lblExIp = new JLabel("(ex. 127.0.0.1 ou www.google.com)");
		lblExIp.setForeground(Color.LIGHT_GRAY);
		lblExIp.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		btnVerificaComunicacao = new JButton("Ping");
		btnVerificaComunicacao.addActionListener(this);
		
		lblQtdPing = new JLabel("pings");
		
		textQtdPing = new JTextField();
		textQtdPing.setColumns(10);
		
		rdbtnPingLimitado = new JRadioButton("Somente");
		
		rdbtnPingIlimitado = new JRadioButton("Sem limites");
		rdbtnPingIlimitado.setSelected(true);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(177)
							.addComponent(textIpRede, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblExIp))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnPingIlimitado)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnPingLimitado)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textQtdPing, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
							.addGap(12)
							.addComponent(lblQtdPing)
							.addGap(385)
							.addComponent(btnVerificaComunicacao, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIpRede)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIpRede)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textIpRede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblExIp)))
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rdbtnPingIlimitado)
							.addGap(8)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textQtdPing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnPingLimitado)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addComponent(lblQtdPing))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(btnVerificaComunicacao)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		abaPing.setLayout(gl_abaPing);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Voltar");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
		if (e.getSource() == btnVerificaComunicacao) {
			try {
				try {
					do_button_actionPerformed(e);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	protected void do_button_actionPerformed(ActionEvent e)
			throws UnknownHostException, IOException, InterruptedException {

		String ip = textIpRede.getText();
		if (ip.length() < 4) {
			JOptionPane.showMessageDialog(null, "Informe um IP válido!");
		} else {
			try {
				Utils utils = new Utils();
				InputStream ping = utils.verificaComunicacao(ip);
				Scanner sc = new Scanner(ping);
					new Thread() {
						@Override
						public void run() {
							try {
								sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							String texto = sc.nextLine() + "\n";
							while (sc.hasNextLine()) {
								textTerminal.setText(texto += sc.nextLine() + "\n");
							} // Finaliza o While
						}
					}.start(); // Finaliza a Thread
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		dispose();
	}
}
