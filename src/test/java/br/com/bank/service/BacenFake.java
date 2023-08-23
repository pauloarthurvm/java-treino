package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

import java.util.HashMap;
import java.util.Map;

public class BacenFake extends Bacen {

    private Map<Integer, Banco> mapBancos;

    public BacenFake() {
        mapBancos = new HashMap<>();
    }

    @Override
    public long cadastrarBanco(Banco banco) {
        int registro = mapBancos.size() + 1;
        mapBancos.put(registro, banco);
        return registro;
    }

}
