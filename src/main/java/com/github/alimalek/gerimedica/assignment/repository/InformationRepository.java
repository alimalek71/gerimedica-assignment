package com.github.alimalek.gerimedica.assignment.repository;

import com.github.alimalek.gerimedica.assignment.domain.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, String> {
}
