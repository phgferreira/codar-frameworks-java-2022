package br.com.bluesoft.alucar.model.projecao;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface ComissaoProjecao {

    String getNome();
    BigInteger getCpf();
    BigDecimal getValor();
    String getBanco();
    Integer getAgencia();
    Integer getContaCorrente();

}
