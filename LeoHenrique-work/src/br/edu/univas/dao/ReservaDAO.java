package br.edu.univas.dao;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.model.Reserva;

public class ReservaDAO {
        //Adicionar informações do BANCO
		private String url = "inserir";
		private String user = "inserir";
		private String pass = "inserir"; 
		
	public void saveReserva(Reserva reserva) {

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			String insert = "insert into reserva (cod, data, tipo) values (?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(insert);
			st.setInt(1, reserva.getCod());
			st.setDate(2, (java.sql.Date) reserva.getData());
			st.setString(3, reserva.getTipo());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateReserva(Reserva reserva) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String update = "update reserva set data = ? tipo = ? where cod = ?";

			PreparedStatement st = conn.prepareStatement(update);
			st.setInt(1, reserva.getCod());
			st.setDate(2, (java.sql.Date)reserva.getData());
			st.setString(3, reserva.getTipo());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReserva(int cod) {
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			String delete = "delete from reserva where cod = ?";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, cod);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Reserva> listarReservas() {
		String select = "select cod, data, tipo from reserva";
		List<Reserva> reserva = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			
			PreparedStatement st = conn.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Reserva reservas = new Reserva();
				
				reservas.setCod(rs.getInt("cod"));
				reservas.setData(rs.getDate("data"));
				reservas.setTipo(rs.getString("tipo"));
				reserva.add(reservas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva;
	}
}
