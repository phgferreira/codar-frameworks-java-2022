package br.com.bluesoft.alucar.controller.dto;

public class MensagemDto {

    private String mensagem;

    public MensagemDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
