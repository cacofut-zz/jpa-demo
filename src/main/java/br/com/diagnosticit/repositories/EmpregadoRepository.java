/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.repositories;

import br.com.diagnosticit.domain.Empregado;
import br.com.diagnosticit.domain.EmpregadoAssalariado;
import br.com.diagnosticit.domain.EmpregadoHorista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cristiano
 */
@Repository
@Transactional
public class EmpregadoRepository {

    @PersistenceContext
    private EntityManager em;

    public Empregado insert(Empregado empregado) {
        em.persist(empregado);
        return empregado;
    }

    public List<EmpregadoAssalariado> findAllEmpregadosAssalariados() {
        return em.createQuery( "select e from EmpregadoAssalariado e", EmpregadoAssalariado.class ).getResultList();
    }

    public List<EmpregadoHorista> findAllEmpregadosHoristas() {
        return em.createQuery( "select e from EmpregadoHorista e", EmpregadoHorista.class ).getResultList();
    }
}
