package com.DealVPSAssignment.mohitcodes.repositories;

import com.DealVPSAssignment.mohitcodes.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
