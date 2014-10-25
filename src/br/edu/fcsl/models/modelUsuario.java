package br.edu.fcsl.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.edu.fcsl.entidade.Usuario;

public class modelUsuario {
	public void userInsert(Usuario user) {
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/subrede?"
							+ "user=root&password=root");

			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("subrede");
			EntityManager em = factory.createEntityManager();

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane
					.showMessageDialog(
							null,
							"Verifique sua conexão com o banco de dados\n"
									+ "mysql://localhost:3306/subrede?user=root&password=root",
							"Sem conexão!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void userDelete(String nome, String senha) {
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/subrede?"
							+ "user=root&password=root");

			String sql = "DELETE FROM Usuario WHERE nome = '" + nome
					+ "'  AND senha = " + senha + ";";

			System.out.println(sql);

			Statement stmt = null;

			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane
					.showMessageDialog(
							null,
							"Verifique sua conexão com o banco de dados\n"
									+ "mysql://localhost:3306/subrede?user=root&password=root",
							"Sem conexão!", JOptionPane.ERROR_MESSAGE);
		}

	}
}
