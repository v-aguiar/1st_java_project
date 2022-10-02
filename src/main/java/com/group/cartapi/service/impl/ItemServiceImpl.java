package com.group.cartapi.service.impl;

import com.group.cartapi.model.Item;
import com.group.cartapi.repository.ItemRepository;
import com.group.cartapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;

  @Override
  public List<Item> getItems() {
    return itemRepository.findAll();
  }
}
