package com.github.alimalek.gerimedica.assignment.mapper;

import com.github.alimalek.gerimedica.assignment.domain.Information;
import com.github.alimalek.gerimedica.assignment.model.InformationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InformationMapper {

    InformationDTO toDTO(Information entity);

    List<InformationDTO> toDTO(List<Information> entity);

    Information toEntity(InformationDTO dto);

}
