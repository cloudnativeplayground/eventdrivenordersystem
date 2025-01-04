package com.cloudnativeplayground.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudnativeplayground.inventoryservice.model.InventoryItem;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
}