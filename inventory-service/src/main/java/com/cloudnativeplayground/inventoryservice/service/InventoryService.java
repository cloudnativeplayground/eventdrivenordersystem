package com.cloudnativeplayground.inventoryservice.service;

import org.springframework.stereotype.Service;
import com.cloudnativeplayground.inventoryservice.model.InventoryItem;
import com.cloudnativeplayground.inventoryservice.repository.InventoryRepository;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public InventoryItem getItemById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public InventoryItem addItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

    public InventoryItem updateItem(Long id, InventoryItem item) {
        InventoryItem existingItem = getItemById(id);
        existingItem.setName(item.getName());
        existingItem.setQuantity(item.getQuantity());
        return inventoryRepository.save(existingItem);
    }
}
