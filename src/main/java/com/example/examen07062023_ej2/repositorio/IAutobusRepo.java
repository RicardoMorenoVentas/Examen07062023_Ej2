package com.example.examen07062023_ej2.repositorio;

import com.example.examen07062023_ej2.modelo.db.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutobusRepo extends JpaRepository<Autobus, String> {
}
