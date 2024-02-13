package co.gersua.reorg.challenge.shortener.repositories;

import co.gersua.reorg.challenge.shortener.entities.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerRepository extends JpaRepository<ShortenedUrl, String> {

    Optional<ShortenedUrl> findByOriginalUrl(String originalUrl);
}
