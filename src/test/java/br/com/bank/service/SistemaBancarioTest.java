package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SistemaBancarioTest {

    @Mock
    private Bacen bacen;

    @InjectMocks
    private SistemaBancario sistemaBancario;

//    private SistemaBancario sistemaBancario;

    @BeforeEach
    void beforeEach() {
//        sistemaBancario = new SistemaBancario(new BacenFake());
//        sistemaBancario = new SistemaBancario(new BacenStub());
    }

    @Test
    void testFazNada() {
        assertTrue(1 == 1);
    }


//    @Test
//    void mock001(){
//        when(bacen.cadastrarBanco(banco)).thenReturn(1l);
//        assertEquals(1l, bacen.cadastrarBanco(banco));
//    }


//    Caso o cadastro do banco no Bacen tenha sido feito com sucesso, ele retorna o número de registro do Banco
//    @Test
//    void cadastro_do_banco_com_sucesso() {
//        Banco itau = new Banco("Itau");
//        long reg = sistemaBancario.registrarBanco(itau);
//
//        assertEquals(1, reg);
//
//        Banco bradesco = new Banco("Bradesco");
//        reg = sistemaBancario.registrarBanco(bradesco);
//
//        assertEquals(2, reg);
//    }





//    Agora, usando um mock com Mockito e definindo os comportamentos da classe Bacen para o caso de sucesso e o de falha,
//    além do cenário de sucesso, implemente o cenário abaixo.
    @Test
    void deve_registrar_banco() {
        Banco inter = new Banco("Inter");

        // 2 modos diferentes
        Mockito.doReturn(25l).when(bacen).cadastrarBanco(inter);
//        when(bacen.cadastrarBanco(inter)).thenReturn(1l);

        assertEquals(25l, bacen.cadastrarBanco(inter));
    }

//    Caso o cadastro do banco no Bacen tenha dado algum problema, a exceção BancoNaoCadastradoException do tipo
//    RuntimeException deve ser retornada. Use o assertThrows para isso.
    @Test
    void nao_deve_cadastrar_se_tiver_problema_de_conexao() {
        Banco ceseis = new Banco("ceseis");

//        Mockito.doThrow(BancoNaoCadastradoException.class).when(bacen).cadastrarBanco(ceseis);
        Mockito.doThrow(RuntimeException.class).when(bacen).cadastrarBanco(ceseis);

        assertThrows(RuntimeException.class, () -> {
            sistemaBancario.registrarBanco(ceseis);
        });
    }


}