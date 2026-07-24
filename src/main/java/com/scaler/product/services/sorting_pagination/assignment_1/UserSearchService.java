package com.scaler.product.services.sorting_pagination.assignment_1;

import com.scaler.product.model.sorting_pagination.assignment_1.Sex;
import com.scaler.product.model.sorting_pagination.assignment_1.User;
import com.scaler.product.repo.sorting_pagination.assignment_1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    @Autowired
    private UserRepository userRepository;

    private final Integer pageSize = 5;

    public List<User> getUsersHavingAddress(String address, Integer pageNumber) {
        Page<User> userDetailsByAddress = this.userRepository.findByAddress(address, PageRequest.of(pageNumber, this.pageSize));
        return userDetailsByAddress.stream().toList();
    }

    public List<User> getDetailsOfAllLadies(Integer pageNumber) {
        Page<User> userDetailsBySex = this.userRepository.findBySex(Sex.FEMALE, PageRequest.of(pageNumber, this.pageSize));
        return userDetailsBySex.stream().toList();
    }

    public List<User> getDetailsOfAllAdultMales(Integer pageNumber) {
        Page<User> userDetailsBySex = this.userRepository.findBySex(Sex.MALE, PageRequest.of(pageNumber, this.pageSize));
        return userDetailsBySex.stream().filter(user -> user.getAge() >= 18).toList();
    }
}
