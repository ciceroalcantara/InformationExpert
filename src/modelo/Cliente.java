package modelo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Cliente {
	private String nome;
	private Collection<Aluguel> fitasAlugadas = new ArrayList<Aluguel>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		fitasAlugadas.add(aluguel);
	}

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		double total = 0.0;
		int pontosDeAlugadorFrequente = 0;

		Iterator<Aluguel> alugueis = fitasAlugadas.iterator(); // iterator tem como objetico mostrar toda lista de
																// alugueis do cliente
		String resultado = "Registro de Alugueis de: " + getNome() + fimDeLinha;
		while (alugueis.hasNext()) {
			Aluguel cada = alugueis.next();
			
			// mostra valores no extrato para o aluguel especifico
			resultado += "\t" + cada.getFita().getTitulo() + "\t RS: " + cada.valor_cada_aluguel()  + "\t Pontos: " + cada.getPontosDeAlugadorFrequente() + fimDeLinha;
		} 
		
		resultado += "Valor total: " + getValorTotal() + fimDeLinha;  // mostra total do cliente
		resultado += "Voce acumulou " + getPontosDeAlugadorFrequenteTotal() + " pontos de alugador frequente";  // mostra pontos que o cliente acumulou
		return resultado;
	}

	private double getValorTotal() {
		double total = 0.0;
		Iterator<Aluguel> alugueis = fitasAlugadas.iterator();
		while (alugueis.hasNext()) {
			Aluguel cada = (Aluguel) alugueis.next();
			total = total + cada.valor_cada_aluguel();
		}
		return total;
		
		
	}
	private int getPontosDeAlugadorFrequenteTotal() {

		int pontos = 0;
		Iterator<Aluguel> alugueis = fitasAlugadas.iterator();
		while(alugueis.hasNext()) {
			Aluguel cada = (Aluguel)alugueis.next();
			pontos = pontos + cada.getPontosDeAlugadorFrequente();
		}
			return pontos;
	}
}
	
	

