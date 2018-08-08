/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.domain;

import javax.persistence.Entity;

/**
 *
 * @author cristiano
 */
@Entity
public class EmpregadoHorista extends Empregado{
    
    private int qtdHoras;
    
    public EmpregadoHorista(){
    }

    public EmpregadoHorista(int qtdHoras) {
        this(40, "teste");
    }

    public EmpregadoHorista(int qtdHoras, String nome) {
        super(nome);
        this.qtdHoras = qtdHoras;
    }

    public EmpregadoHorista(int qtdHoras, long id, String nome) {
        super(id, nome);
        this.qtdHoras = qtdHoras;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    @Override
    public String toString() {
        return super.toString() +  " EmpregadoHorista{" + "qtdHoras=" + qtdHoras + '}';
    }
    
    
    
}
