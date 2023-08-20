package br.com.bank;

import br.com.bank.model.Banco;
import br.com.bank.model.Conta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BancoTest {

    Banco banco;
    Map<String, Double> mapCpfSaldo;
//    final Map<String, Double> mapCpfSaldo = new HashMap<String, Double>();
//        clientesCpfSaldo.put("123", 10000.00);
//        clientesCpfSaldo.put("456", 5000.00);
//        clientesCpfSaldo.put("789", 1117000.00);
//        clientesCpfSaldo.put("147", 9000.00);
//        clientesCpfSaldo.put("258", 10001.00);
//        clientesCpfSaldo.put("369", 9999.00);

    @BeforeEach
    void setup() {
        banco = new Banco("ABC");
        mapCpfSaldo = new HashMap<String, Double>();
        mapCpfSaldo.put("123", 10000.00);
        mapCpfSaldo.put("456", 5000.00);
        mapCpfSaldo.put("789", 1117000.00);
        mapCpfSaldo.put("147", 9000.00);
        mapCpfSaldo.put("258", 10001.00);
        mapCpfSaldo.put("369", 9999.00);
    }

    @Test
    void testAdicionarConta() {
        assertEquals(0, banco.getContas().size());
        banco.adicionarConta(new Conta("987"));
        assertEquals(1, banco.getContas().size());
    }

//    @Test
//    void testPesquisarContaDoCliente() {
//        final List<String> clientesCpf = Arrays.asList("123", "456", "789", "147", "258", "369");
//        Collections.shuffle(clientesCpf);
//        clientesCpf.forEach(c -> banco.adicionarConta(new Conta(c)));
//        final String cpfExpected = clientesCpf.get(new Random().nextInt(clientesCpf.size()));
//        assertEquals(1, banco.getContas().stream().filter(o ->
//                o.getCpf().equals(cpfExpected)).count());
//    }

    @Test
    void testPesquisarContaDoCliente() {
        final List<String> clientesCpf = Arrays.asList("123", "456", "789", "147", "258", "369");
        Collections.shuffle(clientesCpf);
        clientesCpf.forEach(c -> banco.adicionarConta(new Conta(c)));
        final String cpfExpected = clientesCpf.get(new Random().nextInt(clientesCpf.size()));
        assertTrue(banco.pesquisarContaDoCliente(cpfExpected).isPresent());
    }

    @Test
    void testListarContasAltaRenda() {
        mapCpfSaldo.forEach((k, v) -> {
            Conta c = new Conta(k);
            c.setSaldo(v);
            banco.adicionarConta(c);
        });
        assertEquals(3, banco.listarContasAltaRenda().size());
    }

}
