package one.project.patking.mapper;

import one.project.patking.Model.Estacionamento;
import one.project.patking.Model.dto.estacionamentoDTO;
import one.project.patking.Model.dto.estacionamentoPutDTO;
import org.mapstruct.factory.Mappers;

public abstract class EstacionamenoMapper {
    public static   final  EstacionamenoMapper INSTANCE = Mappers.getMapper(EstacionamenoMapper.class);



    public abstract Estacionamento toestacionamento(estacionamentoDTO est);
    public abstract Estacionamento toestacionamentoPUT(estacionamentoPutDTO est);


}
