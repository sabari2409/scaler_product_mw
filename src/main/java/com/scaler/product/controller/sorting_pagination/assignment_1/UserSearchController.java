package com.scaler.product.controller.sorting_pagination.assignment_1;

import com.scaler.product.dto.sorting_pagination.assignment_1.UserSearchRequestDto;
import com.scaler.product.model.sorting_pagination.assignment_1.User;
import com.scaler.product.services.sorting_pagination.assignment_1.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("search")
public class UserSearchController {

    @Autowired
    private UserSearchService userSearchService;

    @PostMapping
    public List<User> getUsersHavingAddress(@RequestBody UserSearchRequestDto requestDto) {
        return this.userSearchService.getUsersHavingAddress(requestDto.getQuery(), requestDto.getPageNumber());
    }


    @GetMapping("ladies")
    public List<User> getDetailsOfAllLadies(@RequestParam Integer pageNumber) {
        return this.userSearchService.getDetailsOfAllLadies(pageNumber);
    }

    @GetMapping("adultMales")
    public List<User> getDetailsOfAllAdultMales(@RequestParam Integer pageNumber) {
        return this.userSearchService.getDetailsOfAllAdultMales(pageNumber);
    }

}
