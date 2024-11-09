package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {

}

