package com.github.alimalek.gerimedica.assignment.mapper;

import com.github.alimalek.gerimedica.assignment.domain.Information;
import com.github.alimalek.gerimedica.assignment.model.InformationDTO;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class InformationMapperTest {

    InformationMapperImpl mapper = new InformationMapperImpl();

    @Test
    void givenEntity_whenMapToModel_thenOK() throws ParseException {
        var simpleDateFormate = new SimpleDateFormat("dd-MM-yyyy");

        // entity
        var entity = Information.builder()
                .source("ZIB")
                .codeListCode("ZIB001")
                .code("1")
                .displayValue("Lorem")
                .longDescription("Long Description")
                .fromDate(new Date(simpleDateFormate.parse("01-01-2019").getTime()))
                .toDate(new Date(simpleDateFormate.parse("01-01-2029").getTime()))
                .sortingPriority(1)
                .build();

        // map to model
        var model = mapper.toDTO(entity);

        // then validate the model information
        assertEquals("ZIB", model.getSource());
        assertEquals("ZIB001", model.getCodeListCode());
        assertEquals("1", model.getCode());
        assertEquals("Lorem", model.getDisplayValue());
        assertEquals("Long Description", model.getLongDescription());
        assertEquals(new java.util.Date(simpleDateFormate.parse("01-01-2019").getTime()), model.getFromDate());
        assertEquals(new java.util.Date(simpleDateFormate.parse("01-01-2029").getTime()), model.getToDate());
        assertEquals(1, model.getSortingPriority());
    }


    @Test
    void givenModel_whenMapToEntity_thenOK() throws ParseException {
        var simpleDateFormate = new SimpleDateFormat("dd-MM-yyyy");

        // model
        var model = InformationDTO.builder()
                .source("ZIB")
                .codeListCode("ZIB001")
                .code("1")
                .displayValue("Lorem")
                .longDescription("Long Description")
                .fromDate(new Date(simpleDateFormate.parse("01-01-2019").getTime()))
                .toDate(new Date(simpleDateFormate.parse("01-01-2029").getTime()))
                .sortingPriority(1)
                .build();

        // map to entity
        var entity = mapper.toEntity(model);

        // then validate the entity information
        assertEquals("ZIB", entity.getSource());
        assertEquals("ZIB001", entity.getCodeListCode());
        assertEquals("1", entity.getCode());
        assertEquals("Lorem", entity.getDisplayValue());
        assertEquals("Long Description", entity.getLongDescription());
        assertEquals(new java.util.Date(simpleDateFormate.parse("01-01-2019").getTime()), entity.getFromDate());
        assertEquals(new java.util.Date(simpleDateFormate.parse("01-01-2029").getTime()), entity.getToDate());
        assertEquals(1, entity.getSortingPriority());
    }

}