package com.cloudnativeplayground.inventoryservice.controller;

import com.cloudnativeplayground.inventoryservice.model.InventoryItem;
import com.cloudnativeplayground.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InventoryController.class)
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService inventoryService;

    @Test
    void testGetAllItems() throws Exception {
        when(inventoryService.getAllItems()).thenReturn(Arrays.asList(
                new InventoryItem() {{ setId(1L); setName("Item1"); setQuantity(10); }},
                new InventoryItem() {{ setId(2L); setName("Item2"); setQuantity(5); }}
        ));

        mockMvc.perform(get("/inventory"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Item1"));
    }

    @Test
    void testGetItemById() throws Exception {
        InventoryItem item = new InventoryItem();
        item.setId(1L);
        item.setName("Item1");
        item.setQuantity(10);

        when(inventoryService.getItemById(1L)).thenReturn(item);

        mockMvc.perform(get("/inventory/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Item1"))
                .andExpect(jsonPath("$.quantity").value(10));
    }

    @Test
    void testAddItem() throws Exception {
        InventoryItem item = new InventoryItem();
        item.setId(1L);
        item.setName("NewItem");
        item.setQuantity(15);

        when(inventoryService.addItem(any(InventoryItem.class))).thenReturn(item);

        mockMvc.perform(post("/inventory")
                        .contentType("application/json")
                        .content("{\"name\": \"NewItem\", \"quantity\": 15}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("NewItem"))
                .andExpect(jsonPath("$.quantity").value(15));
    }
}
