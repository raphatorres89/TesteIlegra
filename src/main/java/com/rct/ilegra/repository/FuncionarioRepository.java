package com.rct.ilegra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rct.ilegra.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
