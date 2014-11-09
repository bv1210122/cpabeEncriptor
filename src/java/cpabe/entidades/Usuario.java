/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpabe.entidades;


/**
 * Entidade Usuario
 * @author BV1210122
 */

public class Usuario {
     
   
    private Long usuario_id;
    private String usuario_user;
    private String usuario_pass;
    private Atributo usuario_atributo;

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_user() {
        return usuario_user;
    }

    public void setUsuario_user(String usuario_user) {
        this.usuario_user = usuario_user;
    }

    public String getUsuario_pass() {
        return usuario_pass;
    }

    public void setUsuario_pass(String usuario_pass) {
        this.usuario_pass = usuario_pass;
    }

    public Atributo getUsuario_atributo() {
        return usuario_atributo;
    }

    public void setUsuario_atributo(Atributo usuario_atributo) {
        this.usuario_atributo = usuario_atributo;
    }   
    
}
