package entities;

public class PessoaFisica extends Pessoa {

	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double impostoPago() {
		double impostoRenda = 0.0;
		double impostoSaude = 0.0;
		
		if (super.getRendaAnual() < 20000.0) {
			impostoRenda = super.getRendaAnual() * 15 / 100; 
		} else {
			impostoRenda = super.getRendaAnual() * 25 / 100;
		}
		
		if (gastosSaude > 0.0) {
			impostoSaude = gastosSaude * 50 / 100;
		}
		
		return impostoRenda - impostoSaude;
	}
	
	@Override
	public String toString() {
		return super.getNome() + ": $ " + String.format("%.2f", impostoPago());
	}
}
