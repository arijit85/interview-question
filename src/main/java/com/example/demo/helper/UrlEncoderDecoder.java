package com.example.demo.helper;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class UrlEncoderDecoder {
    public static final String hashCharset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public Optional<String> encode(int num) {
        var digits = new ArrayList<Integer>();
        while (num > 0) {
            var remainder = num % 62;
            digits.add(remainder);
            num = num / 62;
        }
        Collections.reverse(digits);
        return digits.stream()
                .map(hashCharset::charAt).map(x -> x.toString())
                .reduce((x, y) -> x.concat(y));
    }

    public Integer decode(String hash) {
        List<Integer> base62idx = hash.chars()
                .mapToObj(x -> (char) x)
                .map(hashCharset::indexOf)
                .collect(Collectors.toList());
        Collections.reverse(base62idx);
        return IntStream.range(0, base62idx.size())
                .reduce(0, (x, y) -> x + base62idx.get(y) * Double.valueOf(Math.pow(62, y)).intValue());
    }

}
