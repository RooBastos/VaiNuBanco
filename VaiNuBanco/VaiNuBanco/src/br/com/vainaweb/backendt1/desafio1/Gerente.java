package br.com.vainaweb.backendt1.desafio1;

public class Gerente extends Pessoa {

	private double matricula;
	private int senha;
	
	public Gerente() {
		
	}

	public Gerente(String nome, String CPF, double matricula, int senha) {
		super(nome, CPF);
		this.matricula = matricula;
		this.senha = senha;
	}

	
	
	public double getMatricula() {
		return matricula;
	}

	public void setMatricula(double matricula) {
		this.matricula = matricula;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public void Visualizar() {
		System.out.printf("""
			| ------------------------------------ |
			   |--- Informações do Gerente ---|
			    Nome: %s
			    CPF: %s
				Matrícula: %f
			| ------------------------------------ |\n
			""", getNome(), getCPF() , matricula);
	}
	
}
