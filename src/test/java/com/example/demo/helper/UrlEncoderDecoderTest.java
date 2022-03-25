package com.example.demo.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UrlEncoderDecoderTest {

    UrlEncoderDecoder urlEncoderDecoder;

    @BeforeEach
    void setUp() {
        urlEncoderDecoder = new UrlEncoderDecoder();
    }

    @Test
    void encode_shouldGenerateHash() {
        assertEquals("cb", urlEncoderDecoder.encode(125).get());
    }

    @Test
    void decode_shouldDecodeHash() {
        assertEquals(19158, urlEncoderDecoder.decode("e9a")) ;
    }

}