/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tampelini
 */
public class Funcionario extends Cliente {
    
    //Atributos
    private String senha;
    private String cargo;
    private String nivel_acesso;
    
    //Getters e Setters
    public String getSenha() {
        return senha;
    }
    
     public String getSenhaCriptografada() { 
         return "*****";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
}
