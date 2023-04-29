package entities;

public class PessoaJuridica extends Pessoa {

	private Integer nFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer nFuncionarios) {
		super(nome, rendaAnual);
		this.nFuncionarios = nFuncionarios;
	}

	public Integer getnFuncionarios() {
		return nFuncionarios;
	}

	public void setnFuncionarios(Integer nFuncionarios) {
		this.nFuncionarios = nFuncionarios;
	}

	@Override
	public Double impostoPago() {
		double imposto = 0.0;
		
		if (nFuncionarios <= 10) {
			imposto = super.getRendaAnual() * 16 / 100; 
		} else {
			imposto = super.getRendaAnual() * 14 / 100;
		}
		
		return imposto;
	}
	
	@Override
	public String toString() {
		return super.getNome() + ": $ " + String.format("%.2f", impostoPago());
	}
}
