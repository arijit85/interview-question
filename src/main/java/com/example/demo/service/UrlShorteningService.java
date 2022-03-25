package com.example.demo.service;

import com.example.demo.helper.UrlEncoderDecoder;
import com.example.demo.persistence.RecordNotFoundException;
import com.example.demo.persistence.UrlRepository;
import com.example.demo.persistence.entities.UrlEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlShorteningService {

    UrlEncoderDecoder urlEncoderDecoder;
    UrlRepository urlRepository;

    public String generateShortUrl(String longUrl){
        Integer urlPrimaryKey = urlRepository.save(UrlEntity.builder().url(longUrl).build()).getId();
        String shortUrl = urlEncoderDecoder.encode(urlPrimaryKey)
                .orElseThrow(() -> new RuntimeException("not a valid entry"));
        return shortUrl;
    }

    public String generateLongUrl(String shortUrl) throws RecordNotFoundException {
        System.out.println("shorturl: "+ shortUrl);
        Integer urlPrimaryKey = urlEncoderDecoder.decode(shortUrl);
        System.out.println("calculated primary key : "+ urlPrimaryKey);
        return urlRepository.
                findById(urlPrimaryKey)
                .orElseThrow(() -> new RecordNotFoundException("no record found for" + shortUrl))
                .getUrl();
    }
}
