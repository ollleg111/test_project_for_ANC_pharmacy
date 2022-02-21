package com.example.demo.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TwoStrings {
    private String originalString;
    private String shortString;
}
