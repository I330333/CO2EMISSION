package com.inter.co2emis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inter.co2emis.model.Co2emission;

@Repository
public interface Co2emissionRepository extends CrudRepository<Co2emission, Long> {

	List<Co2emission> findByvehicletype(String vehicletype);

}
