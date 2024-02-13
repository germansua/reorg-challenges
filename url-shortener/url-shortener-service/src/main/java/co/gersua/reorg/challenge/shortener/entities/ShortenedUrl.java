package co.gersua.reorg.challenge.shortener.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(indexes = @Index(columnList = "originalUrl"))
public class ShortenedUrl {

    private @Id String shortenedUrl;
    private String originalUrl;
    private long counter;
}

