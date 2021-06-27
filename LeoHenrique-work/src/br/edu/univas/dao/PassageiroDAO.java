package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.model.Passageiro;

public class PassageiroDAO {
	   //Adicionar informações do BANCO
		private String url = "inserir";
		private String user = "inserir";
		private String pass = "inserir"; 

	public void savePassageiro(Passageiro passageiro) {

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			String insert = "insert into passageiro (rg, nome, peso) values (?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(insert);
			st.setInt(1, passageiro.getRg());
			st.setString(2, passageiro.getNome());
			st.setFloat(3, passageiro.getPeso());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePassageiro(Passageiro passageiro) {
		//similar ao insert
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String update = "update passageiro set nome = ? peso = ? where rg = ?";

			PreparedStatement st = conn.prepareStatement(update);
			st.setInt(1, passageiro.getRg());
			st.setString(2, passageiro.getNome());
			st.setFloat(3, passageiro.getPeso());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePassageiro(int rg) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String delete = "delete from passageiro where rg = ?";

			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, rg);

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Passageiro> listarPassageiro() {
		
		String select = "select rg, nome, peso from passageiro";
		List<Passageiro> passageiros = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			
			PreparedStatement st = conn.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Passageiro passageiro = new Passageiro();
				
				passageiro.setRg(rs.getInt("rg"));
				passageiro.setNome(rs.getString("nome"));
				passageiro.setPeso(rs.getFloat("peso"));
				passageiros.add(passageiro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passageiros;
	}
}
