package com.backend.backend.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Builder.Default;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Message {

    public Message() {
    }

    @Id
    private UUID id;

    @Column(nullable = false)
    private String user;
    @Column(nullable = false)
    private String content;
    @Builder.Default
    private LocalDateTime dateTimeNow;

    @Default
    private int like = 0;

}
