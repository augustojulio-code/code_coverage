package com.backend.backend.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Builder.Default;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "TB_Message")
public class Message {

    public Message() {
    }

    @Id
    private UUID id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String content;
    @Builder.Default
    private LocalDateTime dateTimeNow;

    @Default
    private int likes = 0;

}
