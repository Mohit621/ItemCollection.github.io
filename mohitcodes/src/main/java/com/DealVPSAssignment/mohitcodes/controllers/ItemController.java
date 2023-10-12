package com.DealVPSAssignment.mohitcodes.controllers;

import com.DealVPSAssignment.mohitcodes.payloads.ApiResponse;
import com.DealVPSAssignment.mohitcodes.payloads.ItemDto;
import com.DealVPSAssignment.mohitcodes.services.ItemService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
@Validated
public class ItemController {

    @Autowired
    private ItemService itemService;

    //POST
    @PostMapping("/")
    public ResponseEntity<ItemDto> createItem( @RequestBody @Valid ItemDto itemDto){
        ItemDto createItemDto = this.itemService.createItem(itemDto);
        return new ResponseEntity<>(createItemDto, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{itemId}")
    public ResponseEntity<ItemDto> updateItem( @RequestBody @Valid ItemDto itemDto,@PathVariable("itemId") Integer iid){

        ItemDto updatedItem = this.itemService.updateItem(itemDto, iid);

        return ResponseEntity.ok(updatedItem);
    }

    //DELETE
    @DeleteMapping("/{itemId}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable("itemId") Integer iid){
         this.itemService.deleteItem(iid);
         return new ResponseEntity<ApiResponse>(new ApiResponse( "Item Deleted Successfully", true), HttpStatus.OK);
    }

    //GET ALL
    @GetMapping("/")
    public ResponseEntity<List<ItemDto>> getAllItems(){
        return  ResponseEntity.ok(this.itemService.getAllItems());
    }

    //GET BY ID
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDto> getSingleItem(@PathVariable Integer itemId) {
        return  ResponseEntity.ok(this.itemService.getItemById(itemId));
    }

}
