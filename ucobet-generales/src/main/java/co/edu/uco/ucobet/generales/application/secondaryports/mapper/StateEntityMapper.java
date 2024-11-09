package co.edu.uco.ucobet.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper(componentModel = "spring")

public interface StateEntityMapper {
	
    StateEntityMapper INSTANCE = Mappers.getMapper(StateEntityMapper.class);

    @Mapping(source = "name", target = "name") 
    StateEntity toEntity(StateDomain stateDomain);
    
    List<StateDomain> toDomainCollection(List<StateEntity> stateEntities);



}
