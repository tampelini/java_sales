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
public class Fornecedor extends  Cliente {
    
    //atributos
    private String cnpj;    
    
    //getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
        return this.getNome();        
    }
}
