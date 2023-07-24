package com.example.library.controller;

import com.example.library.common.CodeCardException;
import com.example.library.common.QuantityException;
import com.example.library.dto.BookDto;
import com.example.library.model.Book;
import com.example.library.model.BorrowedCard;
import com.example.library.model.DetailBorrowedCard;
import com.example.library.service.itf.IBookService;
import com.example.library.service.itf.IBorrowedCardService;
import com.example.library.service.itf.IDetailBorrowedCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowedCardService iBorrowedCardService;
    @Autowired
    private IDetailBorrowedCardService iDetailBorrowedCardService;

    @GetMapping("")
    public ModelAndView listBooks(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("listBooks");
        Pageable pageable = PageRequest.of(page, 10);
        Page<Book> bookPage = iBookService.listBooks(pageable);
        modelAndView.addObject("books", bookPage);
        return modelAndView;
    }

    @GetMapping("/add-book")
    public ModelAndView createBook() {
        ModelAndView modelAndView = new ModelAndView("createBook");
        modelAndView.addObject("bookDto", new BookDto());
        return modelAndView;
    }

    @PostMapping("/add-book")
    public String createBook(@Valid @ModelAttribute BookDto bookDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        String fileUpload = "D:\\CODEGYM\\Module4\\Homework\\ss09_AOP\\library\\src\\main\\resources\\static";

        new BookDto().validate(bookDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createBook";
        }
        MultipartFile multipartFile = bookDto.getImg();
        String fileName = multipartFile.getOriginalFilename();

        String filePath = fileUpload + "\\" + fileName;
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        book.setImg(fileName);

        if (iBookService.createBook(book)) {
            redirectAttributes.addFlashAttribute("errorCreateBook", "Thêm mới thành công");
            return "redirect:/library";

        } else {
            redirectAttributes.addFlashAttribute("errorCreateBook", "Thêm mới không thành công");
            return "createBook";
        }
    }

    @PostMapping("/borrowed_book")
    public String borrowedBook(@RequestParam List<Integer> selectedBooks,RedirectAttributes redirectAttributes) throws QuantityException {
        BorrowedCard borrowedCard = new BorrowedCard();
        Book book = new Book();
        Random random = new Random();
        for (int i : selectedBooks) {
            if (iBookService.checkQuantityBook(i) == 1) {
                throw new QuantityException("Sách bạn chọn trong kho đã hết!");
            }
        }
        StringBuilder randomString = null;
        boolean flagCode = true;
        while (flagCode) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            randomString = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                randomString.append(randomChar);
            }
            if (!randomString.toString().equals(iBorrowedCardService.checkCodeCard(randomString.toString()))) {
                flagCode = false;
            }
        }

        borrowedCard.setCodeBorrowedCard(randomString.toString());
        borrowedCard.setStarBorrowed(LocalDate.now().toString());
        borrowedCard.setQuantityBorrowedBooks(selectedBooks.size());
        iBorrowedCardService.create(borrowedCard);
        borrowedCard.setId(iBorrowedCardService.showMaxId());
        for (int i : selectedBooks) {
            DetailBorrowedCard detailBorrowedCardService = new DetailBorrowedCard();
            book.setId(i);
            detailBorrowedCardService.setBook(book);
            detailBorrowedCardService.setBorrowedCard(borrowedCard);
            if (iDetailBorrowedCardService.create(detailBorrowedCardService)) {
                iBookService.minusOneBookQuantity(i);
            }
        }
        redirectAttributes.addFlashAttribute("successfulCard","Thuê sách thành công!");
        return "redirect:/library/list-card-borrowed";
    }

    @ExceptionHandler(QuantityException.class)
    public String quantityBooks() {
        return "quantityException";
    }

    @GetMapping("list-card-borrowed")
    public String listCardBorrowed(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<BorrowedCard> borrowedCards = iBorrowedCardService.findAll(pageable);
        model.addAttribute("borrowedCards", borrowedCards);
        return "listCardBorrowed";
    }

    //trả về một thẻ mượn sách có tất cả các sách đã mượn..
    @GetMapping("remove-book-card")
    public String returnBook(@RequestParam String code, @RequestParam(defaultValue = "0") int page, Model model) throws CodeCardException {
        Pageable pageable = PageRequest.of(page, 8);
        Page<DetailBorrowedCard> detailBorrowedCards = iDetailBorrowedCardService.showByCode(pageable, code);
        model.addAttribute("borrowedCard", detailBorrowedCards);
        return "removeBookCard";
    }
    @ExceptionHandler(CodeCardException.class)
    public String codeCardException(){
        return "codeCardException";
    }

    @PostMapping("remove-book-card")
    @Transactional
    public String returnBook(@RequestParam List<Integer> checkRemoveBook,
                             @RequestParam int idBorrowedCard,
                             @RequestParam int quantityBorrowedBooks
    ) {
        for (int i : checkRemoveBook) {
            iDetailBorrowedCardService.removeBorrowedCardBooks(idBorrowedCard, i);
            iBorrowedCardService.minusOneBorrowedQuantity(idBorrowedCard);
            iBookService.increaseBookQuantity(i);
        }
        if (checkRemoveBook.size() == quantityBorrowedBooks) {
            iBorrowedCardService.remove(idBorrowedCard);
        }
        return "redirect:/library";
    }


}
