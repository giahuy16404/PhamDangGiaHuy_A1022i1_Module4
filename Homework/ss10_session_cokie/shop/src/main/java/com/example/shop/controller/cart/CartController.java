package com.example.shop.controller.cart;

import com.example.shop.dto.cart.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public ModelAndView showList(@SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        ModelAndView modelAndView = new ModelAndView("cart/list");
        if (cartDto == null) {
            modelAndView.addObject("cartSize", 0);
        } else {
            modelAndView.addObject("cartSize", cartDto.getProductMap().size());
            modelAndView.addObject("total",cartDto.totalPrice());
        }
        return modelAndView.addObject("cart", cartDto);
    }

}
