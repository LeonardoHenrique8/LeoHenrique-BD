package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.model.Detalhes;

public class DetalhesDAO {
   //Adicionar informações do BANCO
	private String url = "inserir";
	private String user = "inserir";
	private String pass = "inserir"; 

	public void saveDetalhes(Detalhes detalhes) {

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			String insert = "insert into curso (cpf, endereco, telefone) values (?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(insert);
			st.setInt(1, detalhes.getCpf());
			st.setString(2, detalhes.getEndereco());
			st.setString(3, detalhes.getTelefone());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDetalhes(Detalhes detalhes) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String update = "update detalhes set endereco = ? telefone = ? where cpf = ?";

			PreparedStatement st = conn.prepareStatement(update);
			st.setInt(1, detalhes.getCpf());
			st.setString(2, detalhes.getEndereco());
			st.setString(3, detalhes.getTelefone());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDetalhes(int cpf) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String delete = "delete from detalhes where cpf = ?";

			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, cpf);

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Detalhes> listarDetalhes() {
		
		String select = "select cpf, endereco, telefone from detalhes";
		List<Detalhes> detalhes = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			
			PreparedStatement st = conn.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Detalhes detalhe = new Detalhes();
				
				detalhe.setCpf(rs.getInt("cpf"));
				detalhe.setEndereco(rs.getString("endereco"));
				detalhe.setTelefone(rs.getString("telefone"));
				detalhes.add(detalhe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalhes;
	}
}
