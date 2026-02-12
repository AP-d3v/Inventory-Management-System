package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/buyproduct")
    public String buyProduct(@RequestParam("productID") int id, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);
            redirectAttributes.addFlashAttribute("successMessage", "Purchase successful!");
            redirectAttributes.addFlashAttribute("successProductId", product.getId());
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Purchase Failed!");
            redirectAttributes.addFlashAttribute("errorProductId", product.getId());
        }
        return "redirect:/mainscreen";
    }
}