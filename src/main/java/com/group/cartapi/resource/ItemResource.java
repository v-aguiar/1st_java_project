package com.group.cartapi.resource;

import com.group.cartapi.model.Item;
import com.group.cartapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ifood-dev-week/items")
@RequiredArgsConstructor
public class ItemResource {
  private final ItemService itemService;

  @GetMapping
  public List<Item> getItems() {
    return itemService.getItems();
  }
}
