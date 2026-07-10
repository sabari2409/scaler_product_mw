package com.scaler.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.product.dto.UserRequestDto;
import com.scaler.product.model.Address;
import com.scaler.product.model.FakeStoreUser;
import com.scaler.product.model.Name;
import com.scaler.product.services.IFakeStoreUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FakeStoreUserController.class)
public class FakeStoreUserControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IFakeStoreUserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddUser() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("john_doe");
        userRequestDto.setPassword("password123");
        userRequestDto.setEmail("john@example.com");
        Name name = new Name();
        name.setFirstname("John");
        name.setLastname("Doe");
        userRequestDto.setName(name);
        Address address = new Address();
        address.setCity("Springfield");
        address.setStreet("Main St");
        address.setNumber(123L);
        userRequestDto.setAddress(address);

        FakeStoreUser user = new FakeStoreUser();
        user.setUsername("john_doe");
        user.setPassword("password123");
        user.setEmail("john@example.com");
        user.setName(name);
        user.setAddress(address);

        when(userService.add(any(FakeStoreUser.class))).thenReturn(user);

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john_doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.name.firstname").value("John"))
                .andExpect(jsonPath("$.address.city").value("Springfield"));
    }

    @Test
    void testUpdateUser() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("john_doe_updated");
        userRequestDto.setPassword("newpassword123");
        userRequestDto.setEmail("john_updated@example.com");
        Name name = new Name();
        name.setFirstname("Johny");
        name.setLastname("Does");
        userRequestDto.setName(name);
        Address address = new Address();
        address.setCity("Shelbyville");
        address.setStreet("Elm St");
        address.setNumber(456L);
        userRequestDto.setAddress(address);

        FakeStoreUser user = new FakeStoreUser();
        user.setUsername("john_doe_updated");
        user.setPassword("newpassword123");
        user.setEmail("john_updated@example.com");
        user.setName(name);
        user.setAddress(address);

        when(userService.update(any(FakeStoreUser.class), anyLong())).thenReturn(user);

        mockMvc.perform(put("/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john_doe_updated"))
                .andExpect(jsonPath("$.email").value("john_updated@example.com"))
                .andExpect(jsonPath("$.address.city").value("Shelbyville"));
    }
}
