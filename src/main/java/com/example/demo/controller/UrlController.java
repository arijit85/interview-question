package com.example.demo.controller;

import com.example.demo.persistence.RecordNotFoundException;
import com.example.demo.service.UrlShorteningService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UrlController {

    UrlShorteningService urlShorteningService;

    @PostMapping("/short")
    public String getShortUrl(@RequestParam String url) {
        return urlShorteningService.generateShortUrl(url);
    }

    @GetMapping("/long")
    public String getLongUrl(@RequestParam(name = "tiny", required = true, defaultValue = "") String shortUrl) throws RecordNotFoundException {
        return urlShorteningService.generateLongUrl(shortUrl);
    }
}
