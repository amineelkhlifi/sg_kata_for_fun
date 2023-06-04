package com.kata.kataforfun.controllers;

import com.kata.kataforfun.services.KataConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(KataConversionController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class KataConversionControllerTest {

    private static final String API_URL = "http://localhost:8080";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KataConversionService kataConversionService;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        //Given
        int inputNumber = 3;
        when(kataConversionService.convertNumber(inputNumber)).thenReturn("KataKata");

        //When, Then
        this.mockMvc.perform(get(API_URL+"/kata-conversion/"+inputNumber))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("KataKata")));

    }
}
