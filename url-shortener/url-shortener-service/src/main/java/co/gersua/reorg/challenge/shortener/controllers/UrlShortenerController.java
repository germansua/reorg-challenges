package co.gersua.reorg.challenge.shortener.controllers;

import co.gersua.reorg.challenge.shortener.entities.ShortenedUrl;
import co.gersua.reorg.challenge.shortener.services.UrlShortenerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UrlShortenerController {

    private UrlShortenerService service;

    @PostMapping
    public ResponseEntity<ShortenedUrl> shorten(@RequestBody ShortenedUrlRequest request) throws Exception {
        return ResponseEntity.ok().body(service.shorten(request.originalUrl()));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirect(@PathVariable String shortUrl) {
        var shorten = service.getAndUpdate(shortUrl);
        if (shorten.isPresent()) {
            var headers = new HttpHeaders();
            headers.add("Location", shorten.get().getOriginalUrl());
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/stats")
    public ResponseEntity<List<ShortenedUrl>> getStats() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/stats/{shortUrl}")
    public ResponseEntity<ShortenedUrl> getStatsByShortUrlHash(@PathVariable String shortUrl) {
        var shorten = service.getShortenedByShortUrl(shortUrl);
        return shorten.isPresent() ? ResponseEntity.ok(shorten.get()) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
