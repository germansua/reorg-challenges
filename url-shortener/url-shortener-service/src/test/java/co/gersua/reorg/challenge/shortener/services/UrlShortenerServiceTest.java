package co.gersua.reorg.challenge.shortener.services;

import co.gersua.reorg.challenge.shortener.entities.ShortenedUrl;
import co.gersua.reorg.challenge.shortener.repositories.UrlShortenerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UrlShortenerServiceTest {

    @Mock
    private UrlShortenerRepository repository;

    @InjectMocks
    private UrlShortenerService service;

    @Test
    void testShortenKnownUrl() throws Exception {
        assertEquals(new ShortenedUrl("http://shurl.co/ac6bb669", "https://www.google.com", 0),
                service.shorten("https://www.google.com"));
    }

    @Test
    void testHelloWorldToHexString() throws Exception {
        assertEquals("7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069",
                service.calculateDigest("Hello World!"));
    }

    @Test
    void testKnownUrlToHexString() throws Exception {
        assertEquals("367cb765ec6702e8c75126a3b980278acc7079a8dbc2ec7dc13feb966b27b82d",
                service.calculateDigest("https://www.reorg.com/"));
    }
}