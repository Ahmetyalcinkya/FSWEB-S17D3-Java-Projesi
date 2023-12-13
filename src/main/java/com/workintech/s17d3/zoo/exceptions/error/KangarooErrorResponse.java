package com.workintech.s17d3.zoo.exceptions.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KangarooErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
