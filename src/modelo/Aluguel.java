package modelo;

public class Aluguel {

	// Atributos
	private static final int pontoExtra = 2;
	private static final int pontoSimples = 1;
	private Fita fita;
	private int diasAlugada;

	// Construtor
	public Aluguel(Fita fita, int diasAlugada) {
		this.fita = fita;
		this.diasAlugada = diasAlugada;
	}

	// Gets
	public Fita getFita() {
		return fita;
	}

	public int getDiasAlugada() {
		return diasAlugada;
	}

	// Metodos
	public double valor_cada_aluguel() { // calcula o valor do aluguel para cada tipo de fita

		double valor_cada_aluguel = 0.0;

		switch (getFita().getCodigoDePreco()) {

		case normal:
			if (getDiasAlugada() > 2) {
				valor_cada_aluguel += (getDiasAlugada() - 2) * 1.5;
			}
			break;

		case lancamento:
			valor_cada_aluguel += getDiasAlugada() * 3;
			break;

		case infantil:
			if (getDiasAlugada() > 3) {
				valor_cada_aluguel += (getDiasAlugada() - 3) * 1.5;
			}
			break;
		}
		return valor_cada_aluguel;
	}

	public int getPontosDeAlugadorFrequente() { // Adciona os pontos de alugador ao usuario de acordo com o tipo de fita
		if (getFita().getCodigoDePreco() == Tipo.lancamento && getDiasAlugada() > 1) {
			return pontoExtra;
		}
		return pontoSimples;
	}
}
