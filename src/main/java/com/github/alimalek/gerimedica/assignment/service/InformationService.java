package com.github.alimalek.gerimedica.assignment.service;

import com.github.alimalek.gerimedica.assignment.model.InformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface InformationService {
    Page<InformationDTO> findAll(Pageable pageable);

    InformationDTO findById(String code);

    void uploadCSV(MultipartFile file);

    void deleteAll();
}
