package com.example.shop.controller;

import com.example.shop.dto.CartDto;
import com.example.shop.dto.ProductDto;
import com.example.shop.model.Product;
import com.example.shop.service.IProductService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")

//Tạo session tên cart
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCard() {
        System.out.println("Card----------");
        return new CartDto();
    }

    //Trả về danh sách sản phẩm
    @GetMapping("")
    public String showProduct(@RequestParam(defaultValue = "0") int page,
                              Model model,
                              @CookieValue(value = "productId0", required = false, defaultValue = "-1")
                              Long id0,
                              @CookieValue(value = "productId1", required = false, defaultValue = "-1")
                              Long id1,
                              @CookieValue(value = "productId2", required = false, defaultValue = "-1")
                              Long id2,
                              @CookieValue(value = "productId3", required = false, defaultValue = "-1")
                              Long id3,
                              @SessionAttribute(value = "cart", required = false) CartDto cartDto
    ) {
        Pageable pageable = PageRequest.of(page, 12);
        Page<Product> products = iProductService.findAll(pageable);
        List<Product> product = new ArrayList<>();

        //Thêm đối tượng cookie vào list
        List<Long> productId = new ArrayList<>();
        productId.add(id3);
        productId.add(id2);
        productId.add(id1);
        productId.add(id0);

        //Loại bỏ các trường hợp ko có cookie
        for (Long i : productId) {
            if (i == -1) {
                continue;
            }
            product.add(iProductService.findById(i));
        }

        model.addAttribute("products", products);
        model.addAttribute("recent", product);

        //Xét trong giỏ hàng có bao nhiêu mặt hàng
        if (cartDto == null) {
            model.addAttribute("cartSize", 0);
        } else {
            model.addAttribute("cartSize", cartDto.getProductMap().size());
        }
        return "product/list";
    }

    //Hiển thị trang thêm sách vào hệ shop
    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/create";
    }

    //Nhận từ form, thêm sản phẩm vào shop
    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto productDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        String fileUpload = "D:\\CODEGYM\\Module4\\Homework\\ss10_session_cokie\\shop\\src\\main\\resources\\static\\img";
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        MultipartFile multipartFile = productDto.getImage();
        String fileName = multipartFile.getOriginalFilename();

        String filePath = fileUpload + "\\" + fileName;
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setImage(fileName);
        product.setQuantity(15);
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("successCreate", "Thêm mới thành công");
        return "redirect:/shop";
    }

    //Hiển thị thông tin chi tiết sản phẩm theo id
    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable long id, HttpServletResponse response, HttpServletRequest request, Model model) {

        //Lấy tất cả về mảng cookie
        Cookie[] cookies = request.getCookies();
        List<Long> viewProductId = new ArrayList<>();

        //Thêm đối tượng vào list
        for (Cookie cookie : cookies) {
            if (    cookie.getName().equals("productId0") ||
                    cookie.getName().equals("productId1") ||
                    cookie.getName().equals("productId2") ||
                    cookie.getName().equals("productId3")) {
                viewProductId.add(Long.parseLong(cookie.getValue()));
            }
        }

        //Tránh trùng lặp
        for (int i = 0; i < viewProductId.size(); i++) {
            if (viewProductId.get(i) == id) {
                viewProductId.remove(i);
                break;
            }
        }

        //Xóa vị trí thêm vào đầu của list
        if (viewProductId.size() == 4) {
            viewProductId.remove(0);
        }

        //thêm đối tượng mới vào cookie
        viewProductId.add(id);

        //Tạo Cookie để lưu lịch sử xem gần nhất
        for (int i = 0; i < viewProductId.size(); i++) {
            Cookie cookie = new Cookie("productId" + i, viewProductId.get(i) + "");
            cookie.setMaxAge(1 * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        model.addAttribute("product", iProductService.findById(id));
        return "/product/detail";
    }

    @GetMapping("/add-cart/{id}")
    public String addToCart(@PathVariable long id, @SessionAttribute(value = "cart") CartDto cartDto) {
        cartDto.addProduct(iProductService.findById(id));
        return "redirect:/shop";
    }

    @PostMapping("/remove-cart")
    public String removeCart(@RequestParam List<Long> id, @SessionAttribute(value = "cart") CartDto cartDto){
        for (Long l :id) {
            cartDto.removeProduct(iProductService.findById(l));
        }
        return "redirect:/cart";
    }
}
