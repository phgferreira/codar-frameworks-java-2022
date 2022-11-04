package br.com.bluesoft.alucar.dto;

public class MensagemDto {

    private String mensagem;

    public MensagemDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
