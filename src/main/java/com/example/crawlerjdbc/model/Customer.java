package com.example.crawlerjdbc.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * 会員 エンティティ
 */
@Getter
@Setter
public class Customer {

    @Id
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Size(max = 32)
    private String name;

    @NotNull
    private String role;
}
