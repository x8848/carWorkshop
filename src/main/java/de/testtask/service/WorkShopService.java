package de.testtask.service;

import de.testtask.domain.WorkShop;

import java.util.List;

public interface WorkShopService {

    void createWorkShop();

    void deleteWorkShop();

    List<WorkShop> searchByTown(String town);

    List<WorkShop> getAllWorkShops();

}