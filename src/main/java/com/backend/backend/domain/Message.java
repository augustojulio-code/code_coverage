package com.backend.backend.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;

public class Message {

    @Id
    private Long id;

    @Column(nullable = false)
    private String user;
    @Column(nullable = false)
    private String content;
    @Builder.Default
    private LocalDateTime dateTimeNow;

}
