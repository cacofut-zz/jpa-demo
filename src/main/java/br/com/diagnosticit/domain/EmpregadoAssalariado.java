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
public class EmpregadoAssalariado extends Empregado{
    
    private double salario;

    public EmpregadoAssalariado() {
        this( 0,"teste" );
    }

    public EmpregadoAssalariado(double salario) {
        this( salario, "teste" );
    }

    public EmpregadoAssalariado(double salario, String nome) {
        super(nome);
        this.salario = salario;
    }

    public EmpregadoAssalariado(double salario, long id, String nome) {
        super(id, nome);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() +  " EmpregadoAssalariado{" + "salario=" + salario + '}';
    }
    
    
    
}
