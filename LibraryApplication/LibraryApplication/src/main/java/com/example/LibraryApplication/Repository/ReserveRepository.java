package com.example.LibraryApplication.Repository;

import com.example.LibraryApplication.domain.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    @Query(value = "select customer_id from reservation_entry where isbn = :isbn", nativeQuery = true)
    List<Long> findByIsbnAndActiveTrue(@Param("isbn") String isbn);

}
