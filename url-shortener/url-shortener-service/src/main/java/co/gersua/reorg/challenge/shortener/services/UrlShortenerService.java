package co.gersua.reorg.challenge.shortener.services;

import co.gersua.reorg.challenge.shortener.entities.ShortenedUrl;
import co.gersua.reorg.challenge.shortener.repositories.UrlShortenerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@AllArgsConstructor
public class UrlShortenerService {

    private static final String SHA_256 = "SHA-256";
    // private static final String BASE_URL = "http://shurl.co/";
    private static final String BASE_URL = "http://localhost:8080/";

    private UrlShortenerRepository repository;

    public Optional<ShortenedUrl> getAndUpdate(String shortUrl) {
        var shorted = getShortenedByShortUrl(shortUrl);
        if (shorted.isPresent()) {
            var current = shorted.get();
            current.setCounter(current.getCounter() + 1);
            repository.save(current);
        }
        return shorted;
    }

    public Optional<ShortenedUrl> getShortenedByShortUrl(String shortUrl) {
        shortUrl = shortUrl.contains(BASE_URL) ? shortUrl : BASE_URL + shortUrl;
        var shorted = repository.findById(shortUrl);
        return shorted;
    }

    public List<ShortenedUrl> getAll() {
        return repository.findAll();
    }

    public ShortenedUrl shorten(String originalUrl) {
        final var cleanOriginalUrl = originalUrl.endsWith("/") ? originalUrl.substring(0, originalUrl.length() - 1) : originalUrl;
        return repository
                    .findByOriginalUrl(cleanOriginalUrl)
                    .orElseGet(() -> generateShortenUrl(cleanOriginalUrl));
    }

    private ShortenedUrl generateShortenUrl(String cleanOriginalUrl) {
        var digest = calculateDigest(cleanOriginalUrl);
        // Take the first 8 numbers
        var shortUrl = BASE_URL + digest.substring(0, 8);
        var shorten = new ShortenedUrl(shortUrl, cleanOriginalUrl, 0);
        repository.save(shorten);
        return shorten;
    }

    String calculateDigest(String url) {
        try {
            var messageDigest = MessageDigest.getInstance(SHA_256);
            var rawDigest = messageDigest.digest(url.getBytes(UTF_8));
            return toHexString(rawDigest);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Something went really wrong here: " + ex);
        }
        return "";
    }

    private String toHexString(byte[] rawDigest) {
        var builder = new StringBuilder();
        for (var b : rawDigest) {
            var hex = Integer.toHexString(b & 0xff);
            if (hex.length() == 1) {
                builder.append('0');
            }
            builder.append(hex);
        }
        return builder.toString();
    }
}
