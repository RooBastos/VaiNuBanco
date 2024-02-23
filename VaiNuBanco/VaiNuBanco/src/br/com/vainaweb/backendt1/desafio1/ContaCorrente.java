package br.com.vainaweb.backendt1.desafio1;

public class ContaCorrente extends Pessoa implements FuncoesConta {
	
	private int agencia;
	private int numeroConta;
	private float saldo;
	private float limiteCredito;
	private boolean contaAtiva = true;
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(String nome, String CPF, int agencia, int numeroConta, float saldo) {
		super(nome, CPF);
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}
	
	public boolean getcontaAtiva() {
		return contaAtiva;
	}

	public void setcontaAtiva (boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = this.saldo * 10;
	}

	
	@Override
	public void Visualizar() {
		System.out.printf("""
			| ------------------------------------ |
			   |--- Informações do Cliente ---|
			    Nome: %s
			    CPF: %s
					
			   |--- Conta Corrente ---|
			    Agencia: %d
			    Número da Conta: %d
				
			    Saldo: R$%.2f
			| ------------------------------------ |\n
				""", getNome(), getCPF(), agencia, numeroConta, saldo);

	}
	
	@Override
	public void Depositar(float saldo) {
		this.saldo += saldo;

	}

	@Override
	public void Sacar(float saldo) {
		this.saldo -= saldo;

	}

	@Override
	public void Transferir(float saldo) {
		this.saldo -= saldo;

	}
	
	@Override
	public void RetornaSaldo() {
		System.out.printf("""
			| ------------------------------------ |
				|--- Conta Corrente ---|
			    Agencia: %d
			    Número da Conta: %d
				
			    Saldo: R$%.2f
			| ------------------------------------ |\n
				""", agencia, numeroConta, saldo);
	}
	
	public void VerificaLimiteCredito() {
		System.out.printf("""
				| ------------------------------------ |
					|--- Conta Corrente ---|
				    Agencia: %d
				    Número da Conta: %d
					
				    Limite de Crédito para solicitar: R$%.2f
				    Juros: 2% ao mês
				| ------------------------------------ |\n
					""", agencia, numeroConta, limiteCredito);
	}
	
	public void SolicitaLimite() {
		saldo += limiteCredito;
		
		System.out.printf("""
				| ------------------------------------ |
					|--- Conta Corrente ---|
				    Agencia: %d
				    Número da Conta: %d
					
				    Saldo: R$%.2f
				| ------------------------------------ |\n
					""", agencia, numeroConta, saldo);
	}

}
