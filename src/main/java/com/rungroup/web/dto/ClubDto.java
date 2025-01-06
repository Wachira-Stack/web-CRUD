package com.rungroup.web.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message="Club Title should not be empty")
    private String title;
    @NotEmpty(message="Photo Link must be provided")
    private String photoUrl;
    private String content;
    @NotEmpty(message="Content should not be empty")
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
