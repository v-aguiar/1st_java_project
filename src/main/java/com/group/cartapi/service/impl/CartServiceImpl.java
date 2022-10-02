package com.group.cartapi.service.impl;

import com.group.cartapi.enumeration.PaymentOption;
import com.group.cartapi.model.Cart;
import com.group.cartapi.model.Item;
import com.group.cartapi.model.Restaurant;
import com.group.cartapi.repository.CartRepository;
import com.group.cartapi.repository.ItemRepository;
import com.group.cartapi.repository.ProductRepository;
import com.group.cartapi.resource.dto.ItemDto;
import com.group.cartapi.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
  private final CartRepository cartRepository;
  private final ItemRepository itemRepository;
  private final ProductRepository productRepository;

  @Override
  public Item addItemToCart(ItemDto itemDto) {
    Cart cart = getCart(itemDto.getCartId());

    if (cart.isClosed()) {
      throw new RuntimeException("This cart has already been closed.");
    }

    Item itemToAdd = Item.builder()
        .quantity(itemDto.getQuantity())
        .cart(cart)
        .product(productRepository.findById(itemDto.getProductId()).orElseThrow(
            () -> new RuntimeException("Product not found.")
        ))
        .build();

    List<Item> cartItems = cart.getItens();
    if(cartItems.isEmpty()) {
      cartItems.add(itemToAdd);
    } else {
      for (Item item : cartItems) {
        Restaurant currentRestaurant = item.getProduct().getRestaurant();
        Restaurant restaurantFromItemToAdd = itemToAdd.getProduct().getRestaurant();

        if (currentRestaurant.equals(restaurantFromItemToAdd)) {
          cartItems.add(itemToAdd);
        } else {
          throw new RuntimeException("You can't add items from different restaurants to the same cart.");
        }
      }
    }

    cartRepository.save(cart);
    return itemRepository.save(itemToAdd);
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
  public Cart closeCart(Long id, int paymentOptionNumber) {
    Cart cart = getCart(id);
    if (cart.getItens().isEmpty()) {
      throw new RuntimeException("Cart is empty");
    }
    PaymentOption paymentOption = paymentOptionNumber == 0 ? PaymentOption.MONEY : PaymentOption.CARD;
    cart.setPaymentOption(paymentOption);
    cart.setClosed(true);
    return cartRepository.save(cart);
  }
}
