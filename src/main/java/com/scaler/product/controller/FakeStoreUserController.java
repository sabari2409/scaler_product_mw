package com.scaler.product.controller;

import com.scaler.product.dto.UserRequestDto;
import com.scaler.product.model.Address;
import com.scaler.product.model.FakeStoreUser;
import com.scaler.product.model.Name;
import com.scaler.product.services.IFakeStoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class FakeStoreUserController {

    @Autowired
    private IFakeStoreUserService userService;

    @PostMapping
    public FakeStoreUser createUser(@RequestBody UserRequestDto requestDto) {
        FakeStoreUser user = this.from(requestDto);
        return this.userService.add(user);
    }

    @PutMapping("{id}")
    public FakeStoreUser updateUser(@RequestBody FakeStoreUser user, @PathVariable("id") Long Id) {
        return this.userService.update(user, Id);
    }


    private FakeStoreUser from(UserRequestDto userRequestDto) {
        FakeStoreUser user = new FakeStoreUser();

        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        if (userRequestDto.getAddress() != null) {
            Name name = new Name();
            name.setFirstname(userRequestDto.getName().getFirstname());
            name.setLastname(userRequestDto.getName().getLastname());
            user.setName(name);
        }

        if (userRequestDto.getName() != null) {
            Address address = new Address();
            address.setCity(userRequestDto.getAddress().getCity());
            address.setStreet(userRequestDto.getAddress().getStreet());
            address.setNumber(userRequestDto.getAddress().getNumber());
            user.setAddress(address);
        }

        return user;
    }
}
