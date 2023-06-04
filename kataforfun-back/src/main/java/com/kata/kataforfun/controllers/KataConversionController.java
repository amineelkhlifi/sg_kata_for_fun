package com.kata.kataforfun.controllers;

import com.kata.kataforfun.controllers.dto.ResultDto;
import com.kata.kataforfun.services.KataConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kata-for-fun")
public class KataConversionController {

    private final KataConversionService kataConversionService;

    @Autowired
    public KataConversionController(KataConversionService kataConversionService) {
        this.kataConversionService = kataConversionService;
    }

    @GetMapping(value = "/{inputNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    public ResultDto convertNumber(@PathVariable(name = "inputNumber") int inputNumber) {
        return new ResultDto(kataConversionService.convertNumber(inputNumber));
    }


}


