package com.DealVPSAssignment.mohitcodes.services;

import com.DealVPSAssignment.mohitcodes.payloads.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto createItem(ItemDto item);
    ItemDto updateItem(ItemDto item,Integer itemId);
    ItemDto getItemById(Integer ItemId);
    List<ItemDto> getAllItems();
    void deleteItem(Integer ItemId);
}
