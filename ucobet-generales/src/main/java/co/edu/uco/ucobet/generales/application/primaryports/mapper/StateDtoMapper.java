package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDto;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;



@Mapper(componentModel = "spring")
public interface StateDtoMapper {
	
	StateDtoMapper INSTANCE = Mappers.getMapper(StateDtoMapper.class);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "country", target = "country")
	StateDomain toDomain(ConsultStateDto dto);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "country", target = "country")
	ConsultStateDto toDto(StateDomain stateDomain);

	List<ConsultStateDto> toDtoCollection(List<StateDomain> domains);

}