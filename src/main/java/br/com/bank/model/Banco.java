package br.com.bank.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Optional<Conta> pesquisarContaDoCliente(String cpf) {
//        Conta c = null;
//        for (Conta conta : contas) {
//            if (conta.getCpf().equals(cpf)) {
//                c = conta;
//            }
//        }
//        return c;

        Optional<Conta> contaResult = contas.stream().filter(o -> o.getCpf().equals(cpf)).findFirst();
        return contaResult;
//        return contas.stream().filter(o -> o.getCpf().equals(cpf)).findFirst();
    }

    public List<Conta> listarContasAltaRenda() {
        return filtrarContas(c -> c.getSaldo() >= 10000);
    }

    private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contas.stream().filter(filtro).collect(Collectors.toList());
    }

    public List<Conta> getContas() {
        return contas;
    }

    public int getTotalDeContas() {
        return contas.size();
    }
}
