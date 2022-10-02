package com.group.cartapi.resource;

import com.group.cartapi.model.Cart;
import com.group.cartapi.model.Item;
import com.group.cartapi.resource.dto.ItemDto;
import com.group.cartapi.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood-dev-week/carts")
@RequiredArgsConstructor
public class CartResource {
  private final CartService cartService;

  @PostMapping
  public Item addItemToCart(@RequestBody ItemDto itemDto) {
    return cartService.addItemToCart(itemDto);
  }

  @GetMapping("/{id}")
  public Cart getCart(@PathVariable("id") Long id) {
    return cartService.getCart(id);
  }

  @PatchMapping("closeCart/{id}")
  public Cart closeCart(
          @PathVariable("id") Long id,
          @RequestParam("paymentOption") int paymentOption
  ) {
    return cartService.closeCart(id, paymentOption);
  }
}
