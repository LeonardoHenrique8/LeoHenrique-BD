package br.edu.univas.main;

import java.util.List;

import br.edu.univas.dao.DetalhesDAO;
import br.edu.univas.model.Detalhes;

public class TesteDetalhes {

	public static void main(String[] args) {
		Detalhes first_detalhe = new Detalhes(7654, "Rua XXXXXX", "35-000000");
		
		DetalhesDAO teste = new DetalhesDAO();
		teste.saveDetalhes(first_detalhe);
		
		Detalhes second_detalhe = new Detalhes(987126, "Rua ZZZZZZ", "35-111111");
		teste.updateDetalhes(second_detalhe);
		
		teste.deleteDetalhes(237526);
		
		List<Detalhes> my_detalhes = teste.listarDetalhes();
		for (Detalhes detalhes : my_detalhes) {
			System.out.println(detalhes);
		}
	}

}
