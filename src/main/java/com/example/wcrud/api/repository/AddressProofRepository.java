package com.example.wcrud.api.repository;

import com.example.wcrud.api.model.AddressProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressProofRepository extends JpaRepository<AddressProof, Long> {
}
