package visao;

import modelo.Fita;
import modelo.Aluguel;
import modelo.Tipo;
import modelo.Cliente;

public class Locadora {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Cicero Moura de Alcantara");
		
		cliente.adicionaAluguel (new Aluguel(new Fita("Vingadores", Tipo.lancamento), 5));
		cliente.adicionaAluguel (new Aluguel(new Fita("Titanic", Tipo.normal), 10));

	    System.out.println(cliente.extrato());
	}

}
