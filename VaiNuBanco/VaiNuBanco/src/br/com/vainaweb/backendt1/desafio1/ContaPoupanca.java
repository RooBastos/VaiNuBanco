package br.com.vainaweb.backendt1.desafio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends Pessoa implements FuncoesConta {

	private int agencia;
	private int numeroConta;
	private float saldo;
	private LocalDate dataCriacao;
	private boolean contaAtiva = true;
	
	public ContaPoupanca() {
		
	}

	public ContaPoupanca(String nome, String CPF, int agencia, int numeroConta, float saldo) {
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
	
	public boolean getcontaAtiva() {
		return contaAtiva;
	}

	public void setcontaAtiva (boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public void Visualizar() {
		System.out.printf("""
			| ------------------------------------ |
			   |--- Informações do Cliente ---|
			    Nome: %s
			    CPF: %s
					
			   |--- Conta Poupança ---|
			    Agencia: %d
			    Número da Conta: %d
				
			    Saldo: R$%.2f
			| ------------------------------------ |\n
			""", getNome(), getCPF() ,agencia, numeroConta, saldo);

	}

	@Override
	public void Depositar(float saldo) {
		this.saldo += saldo;

	}

	@Override
	public void Sacar(float saldo) {
		this.saldo = (float) (saldo + (saldo * 0.02));

	}

	@Override
	public void Transferir(float saldo) {
		this.saldo -= saldo;

	}
	
	@Override
	public void RetornaSaldo() {
		System.out.printf("""
			| ------------------------------------ |
				|--- Conta Poupança ---|
			    Agencia: %d
			    Número da Conta: %d
				
			    Saldo: R$%.2f
			| ------------------------------------ |\n
				""", agencia, numeroConta, saldo);
	}
	
	public void ConfereAniversario() {
		float saldoInicial = this.saldo;
		float rendimento30 = (float) (saldoInicial * 0.015);
		
		float novoSaldo = (rendimento30 + this.saldo);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = this.dataCriacao.format(formatter);
		
		System.out.printf("""
				| ------------------------------------ |
				  |--- Aniversário Conta Poupança ---|
					Data Inicial: %s
					
					Após 30 dias: R$%.2f
				| ------------------------------------ |\n
				""", dataFormatada, novoSaldo);
	}

}
