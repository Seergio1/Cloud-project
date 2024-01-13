package com.example.stock.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stock.Models.Out_method;
import java.util.List;


@Repository
public interface Out_methodRepository extends JpaRepository<Out_method,Long>{
    @Query("SELECT om FROM out_method om WHERE om.id = :idMethod")
    List<Out_method> findOutMethodById(@Param("idMethod") Long idMethod);
}
