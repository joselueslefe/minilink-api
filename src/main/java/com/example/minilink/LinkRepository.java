package com.example.minilink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LinkRepository extends JpaRepository<Link, String> {
    @Transactional
    @Modifying
    @Query("UPDATE Link l SET l.cliques = l.cliques + 1 WHERE l.id = :id")
    void incrementarCliques(String id);
}
