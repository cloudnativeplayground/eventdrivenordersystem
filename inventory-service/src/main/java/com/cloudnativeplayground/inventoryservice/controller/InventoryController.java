package com.cloudnativeplayground.inventoryservice.controller;

import org.springframework.web.bind.annotation.*;
import com.cloudnativeplayground.inventoryservice.model.InventoryItem;
import com.cloudnativeplayground.inventoryservice.service.InventoryService;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/{id}")
    public InventoryItem getItem(@PathVariable Long id) {
        return inventoryService.getItemById(id);
    }

    @PostMapping
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryService.addItem(item);
    }

    @PutMapping("/{id}")
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem item) {
        return inventoryService.updateItem(id, item);
    }
}
