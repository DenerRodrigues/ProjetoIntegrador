package br.edu.fcsl.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelLogin;
	private JPasswordField passwordField;
	private JLabel lblSenha;
	private JButton btnNovo;
	private JButton btnEntrar;
	private JButton btnExcluir;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JLabel labelUsuario;
	private JTextField textUsuario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Login() {
		SubstanceLookAndFeel.setSkin(new MeuSkin());
		setResizable(false);
		setFont(new Font("Dialog", Font.ITALIC, 12));
		setTitle("SubRede's System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		panel = new JPanel();
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelLogin.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		buttonGroup.add(btnExcluir);
		
		btnNovo = new JButton("Novo");
		buttonGroup.add(btnNovo);
		btnNovo.addActionListener(this);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		buttonGroup.add(btnEntrar);
		
		passwordField = new JPasswordField();
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 16));
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textUsuario, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(68, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(86)
					.addComponent(labelUsuario)
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(86)
					.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addComponent(labelUsuario, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnEntrar)
					.addGap(12)
					.addComponent(btnNovo)
					.addGap(12)
					.addComponent(btnExcluir)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		panelLogin.setLayout(gl_panelLogin);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExcluir) {
			do_btnExcluir_actionPerformed(e);
		}
		if (e.getSource() == btnEntrar) {
			do_btnEntrar_actionPerformed(e);
		}
		if (e.getSource() == btnNovo) {
			do_btnNovo_actionPerformed(e);
		}
	}

	protected void do_btnEntrar_actionPerformed(ActionEvent e) {
		dispose();
		CalcularSubrede subrede = new CalcularSubrede();
		subrede.setLocationRelativeTo(null);
		subrede.setExtendedState(JFrame.MAXIMIZED_BOTH);
		subrede.setVisible(true);
	}

	protected void do_btnNovo_actionPerformed(ActionEvent e) {
		NovoUsuario novo = new NovoUsuario();
		novo.setLocationRelativeTo(null);
		novo.setVisible(true);
	}

	protected void do_btnExcluir_actionPerformed(ActionEvent e) {
		ExcluirUsuario excluir = new ExcluirUsuario();
		excluir.setLocationRelativeTo(null);
		excluir.setVisible(true);
	}
}
