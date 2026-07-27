package com.example.moviebooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer showId;

    @NotEmpty
    private List<Integer> showSeatIds;
}
