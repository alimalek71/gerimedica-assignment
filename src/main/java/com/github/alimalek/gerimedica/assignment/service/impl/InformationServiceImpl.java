package com.github.alimalek.gerimedica.assignment.service.impl;

import com.github.alimalek.gerimedica.assignment.component.InformationCSVComponent;
import com.github.alimalek.gerimedica.assignment.domain.Information;
import com.github.alimalek.gerimedica.assignment.exception.InformationNotFound;
import com.github.alimalek.gerimedica.assignment.mapper.InformationMapper;
import com.github.alimalek.gerimedica.assignment.model.InformationDTO;
import com.github.alimalek.gerimedica.assignment.repository.InformationRepository;
import com.github.alimalek.gerimedica.assignment.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;
    private final InformationCSVComponent informationCSVComponent;
    private final InformationMapper informationMapper;

    @Override
    public Page<InformationDTO> findAll(Pageable pageable) {
        Page<Information> page = informationRepository.findAll(pageable);
        return new PageImpl<>(informationMapper.toDTO(page.getContent()), pageable, page.getTotalElements());
    }

    @Override
    public InformationDTO findById(String code) {
        Information information = informationRepository.findById(code).orElseThrow(InformationNotFound::new);
        return informationMapper.toDTO(information);
    }

    @Override
    @Transactional
    public void uploadCSV(MultipartFile file) {
        List<Information> informationList = informationCSVComponent.csvToInformation(file);
        informationRepository.saveAll(informationList);
    }

    @Override
    @Transactional
    public void deleteAll() {
        informationRepository.deleteAll();
    }
}
