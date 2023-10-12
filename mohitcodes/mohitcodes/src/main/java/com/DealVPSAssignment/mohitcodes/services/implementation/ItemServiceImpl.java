package com.DealVPSAssignment.mohitcodes.services.implementation;

import com.DealVPSAssignment.mohitcodes.entities.Item;
import com.DealVPSAssignment.mohitcodes.payloads.ItemDto;
import com.DealVPSAssignment.mohitcodes.repositories.ItemRepository;
import com.DealVPSAssignment.mohitcodes.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.DealVPSAssignment.mohitcodes.exceptions.ResourseNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDto createItem(ItemDto itemDto) {

        Item item=dtoToItem(itemDto);
        Item savedItem = this.itemRepository.save(item);

        return this.itemToDto(savedItem);
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto, Integer itemId) {

        Item item=this.itemRepository.findById(itemId).orElseThrow(()-> new ResourseNotFoundException("Item", "id", itemId));

        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());

        Item updateditem = this.itemRepository.save(item);
        ItemDto itemDto1 = this.itemToDto(updateditem);

        return itemDto1;
    }

    @Override
    public ItemDto getItemById(Integer itemId) {
        Item item=this.itemRepository.findById(itemId).orElseThrow(()-> new ResourseNotFoundException("Item", "id", itemId));
        return this.itemToDto(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items=this.itemRepository.findAll();
        List<ItemDto> itemDtos=items.stream().map(item -> this.itemToDto(item)).collect(Collectors.toList());
        return itemDtos;
    }

    @Override
    public void deleteItem(Integer itemId) {
        Item item = this.itemRepository.findById(itemId).orElseThrow(()-> new ResourseNotFoundException("Item", "Id", itemId));
        this.itemRepository.delete(item);
    }

    public Item dtoToItem(ItemDto itemDto){
        //with help of auto wire
        Item item = this.modelMapper.map(itemDto, Item.class);
        // without the help of automapper
//        Item item=new Item();
//        item.setId(itemDto.getId());
//        item.setName(itemDto.getName());
//        item.setDescription(itemDto.getDescription());
        return item;
    }

    public ItemDto itemToDto(Item item){
        ItemDto itemDto = this.modelMapper.map(item, ItemDto.class);
        // without the help of automapper
//        ItemDto itemDto=new ItemDto();
//        itemDto.setId(item.getId());
//        itemDto.setName(item.getName());
//        itemDto.setDescription(item.getDescription());
        return itemDto;
    }
}
