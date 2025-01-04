package com.cloudnativeplayground.inventoryservice.service;

import com.cloudnativeplayground.inventoryservice.model.InventoryItem;
import com.cloudnativeplayground.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    private final InventoryRepository inventoryRepository = mock(InventoryRepository.class);
    private final InventoryService inventoryService = new InventoryService(inventoryRepository);

    @Test
    void testGetAllItems() {
        when(inventoryRepository.findAll()).thenReturn(Arrays.asList(
                new InventoryItem() {{ setId(1L); setName("Item1"); setQuantity(10); }},
                new InventoryItem() {{ setId(2L); setName("Item2"); setQuantity(5); }}
        ));

        var items = inventoryService.getAllItems();
        assertEquals(2, items.size());
    }

    @Test
    void testGetItemById() {
        InventoryItem item = new InventoryItem();
        item.setId(1L);
        item.setName("Item1");
        item.setQuantity(10);

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(item));

        var foundItem = inventoryService.getItemById(1L);
        assertEquals("Item1", foundItem.getName());
    }

    @Test
    void testAddItem() {
        InventoryItem item = new InventoryItem();
        item.setName("NewItem");
        item.setQuantity(15);

        when(inventoryRepository.save(item)).thenReturn(item);

        var savedItem = inventoryService.addItem(item);
        assertEquals("NewItem", savedItem.getName());
    }

    @Test
    void testUpdateItem() {
        InventoryItem existingItem = new InventoryItem();
        existingItem.setId(1L);
        existingItem.setName("OldItem");
        existingItem.setQuantity(10);

        InventoryItem updatedItem = new InventoryItem();
        updatedItem.setName("UpdatedItem");
        updatedItem.setQuantity(20);

        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(existingItem));
        when(inventoryRepository.save(existingItem)).thenReturn(existingItem);

        var result = inventoryService.updateItem(1L, updatedItem);
        assertEquals("UpdatedItem", result.getName());
        assertEquals(20, result.getQuantity());
    }
}
