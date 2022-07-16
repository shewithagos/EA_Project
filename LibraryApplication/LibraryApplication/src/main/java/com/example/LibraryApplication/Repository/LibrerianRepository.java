package com.example.LibraryApplication.Repository;

import com.example.LibraryApplication.domain.Librerian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrerianRepository extends JpaRepository<Librerian, Long> {
}
