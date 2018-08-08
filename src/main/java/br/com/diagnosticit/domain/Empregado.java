/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author cristiano
 */
@MappedSuperclass
public abstract class Empregado {
    
    @Id
    @GeneratedValue
    private long id;

    public Empregado() {
    }

    public Empregado(String nome) {
        this.nome = nome;
    }

    public Empregado(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Empregado{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
