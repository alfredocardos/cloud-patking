package one.project.patking.Model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class estacionamentoPutDTO {
    private Long id;
    private String licenca;
    private String status;
    private String modelo;
    private String cor;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private final LocalDateTime dataEntrada = LocalDateTime.now();
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private  LocalDateTime dataSaida;
    private Double prreço;
}
