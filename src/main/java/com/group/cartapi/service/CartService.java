package com.group.cartapi.service;

import com.group.cartapi.model.Cart;
import com.group.cartapi.model.Item;
import com.group.cartapi.resource.dto.ItemDto;

public interface CartService {
  Item addItemToCart(ItemDto itemDto);
  Cart getCart(Long id);
  Cart closeCart(Long id, int paymentOption);
}
