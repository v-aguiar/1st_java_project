package com.group.cartapi.service.impl;

import com.group.cartapi.model.Cart;
import com.group.cartapi.model.Item;
import com.group.cartapi.repository.CartRepository;
import com.group.cartapi.resource.dto.ItemDto;
import com.group.cartapi.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
  private final CartRepository cartRepository;

  @Override
  public Item addItemToCart(ItemDto itemDto) {
    return null;
  }

  @Override
  public Cart getCart(Long id) {
    return cartRepository.findById(id).orElseThrow(
      () -> {
        throw new RuntimeException("Cart not found");
      }
    );
  }

  @Override
  public Cart closeCart(Long id, int paymentOption) {
    return null;
  }
}