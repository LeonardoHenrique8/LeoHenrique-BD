package br.edu.univas.main;

import java.util.List;

import br.edu.univas.dao.PassageiroDAO;
import br.edu.univas.model.Passageiro;

public class TestePassageiro {

	public static void main(String[] args) {
		Passageiro first_passageiro = new Passageiro(34564, "Leonardo", 78);
		
		PassageiroDAO teste = new PassageiroDAO();
		teste.savePassageiro(first_passageiro);
		
		Passageiro second_passageiro = new Passageiro(237526, "Yuno", 75);
		teste.updatePassageiro(second_passageiro);
		
		teste.deletePassageiro(237526);
		
		List<Passageiro> my_passageiros = teste.listarPassageiro();
		for (Passageiro passageiro : my_passageiros) {
			System.out.println(passageiro);
		}
	}

}
