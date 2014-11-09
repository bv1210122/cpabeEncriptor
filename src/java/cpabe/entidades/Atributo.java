/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpabe.entidades;


/**
 * Entidade Atributo
 * @author BV1210122
 */

public class Atributo {
     
   
    private Long atributo_id;
    private String atributo_nome;
    private String atributo_descricao;

    public Long getAtributo_id() {
        return atributo_id;
    }

    public void setAtributo_id(Long atributo_id) {
        this.atributo_id = atributo_id;
    }

    public String getAtributo_nome() {
        return atributo_nome;
    }

    public void setAtributo_nome(String atributo_nome) {
        this.atributo_nome = atributo_nome;
    }

    public String getAtributo_descricao() {
        return atributo_descricao;
    }

    public void setAtributo_descricao(String atributo_descricao) {
        this.atributo_descricao = atributo_descricao;
    }

   
}
