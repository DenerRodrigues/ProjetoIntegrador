package br.edu.fcsl.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.edu.fcsl.controller.Utils;
import br.edu.fcsl.models.modelUsuario;

public class ExcluirUsuario extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNome;
	private JLabel lblSenha;
	private JTextField textNome;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JButton btnCancelar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ExcluirUsuario dialog = new ExcluirUsuario();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExcluirUsuario() {
		setTitle("Excluir");
		setBounds(100, 100, 375, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lblNome = new JLabel("Nome:");
		
		lblSenha = new JLabel("Senha:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblSenha))
					.addGap(7)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
						.addComponent(passwordField))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(this);
				buttonGroup.add(btnCancelar);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			{
				btnExcluir = new JButton("Excluir");
				btnExcluir.addActionListener(this);
				buttonGroup.add(btnExcluir);
				btnExcluir.setActionCommand("OK");
				buttonPane.add(btnExcluir);
				getRootPane().setDefaultButton(btnExcluir);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExcluir) {
			try {
				do_btnExcluir_actionPerformed(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}

	protected void do_btnExcluir_actionPerformed(ActionEvent e) throws SQLException {
		String nome = textNome.getText();
		@SuppressWarnings("deprecation")
		String senha = passwordField.getText();

		modelUsuario modelUser = new modelUsuario();
		modelUser.userDelete(nome, senha);

		dispose();
	}

	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
}
