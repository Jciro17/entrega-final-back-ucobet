package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper
public interface RegisterNewCityDtoMapper {
	
	RegisterNewCityDtoMapper INSTANCE = Mappers.getMapper(RegisterNewCityDtoMapper.class);
	
    @Mapping(source = "state", target = "state", qualifiedByName = "mapState")
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    CityDomain toDomain(RegisterNewCityDto dto);

    @Named("mapState")
    default StateDomain mapState(UUID stateId) {
        return StateDomain.create(stateId, TextHelper.EMPTY, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
    }
    
}