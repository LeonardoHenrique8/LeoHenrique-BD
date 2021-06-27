package br.edu.univas.main;

import java.util.List;

import br.edu.univas.dao.ReservaDAO;
import br.edu.univas.model.Reserva;

import java.util.Date;

public class TesteReserva {

	public static void main(String[] args) {
		Reserva first_reserva = new Reserva();
		first_reserva.setCod(1);
		first_reserva.setData(null);
		first_reserva.setTipo("Econômica");
		
		ReservaDAO teste = new ReservaDAO();
		teste.saveReserva(first_reserva);
		
		Reserva second_reserva = new Reserva(2,null, "Executiva");
		teste.updateReserva(second_reserva);
		
		teste.deleteReserva(1);
		
		List<Reserva> my_reservas = teste.listarReservas();
		for (Reserva reserva : my_reservas) {
			System.out.println(reserva);
		}
	}

}
