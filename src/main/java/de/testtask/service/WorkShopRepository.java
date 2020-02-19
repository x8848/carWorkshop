package de.testtask.service;

import de.testtask.domain.WorkShop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkShopRepository extends CrudRepository<WorkShop, Long> {

    List<WorkShop> findByCity(String city);

}