package br.com.bank.model;


public class Conta {

	private double saldo;
	private String cpf;

	public Conta(String cpf) {
		this.cpf = cpf;
		this.saldo = 0;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
