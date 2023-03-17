package co.whitetree.javatodo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationRequest {
    @NotNull
    private Long id;
    @NotBlank
    private String code;
}
