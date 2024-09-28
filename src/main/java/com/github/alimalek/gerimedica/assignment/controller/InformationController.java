package com.github.alimalek.gerimedica.assignment.controller;

import com.github.alimalek.gerimedica.assignment.model.InformationDTO;
import com.github.alimalek.gerimedica.assignment.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/information")
@RequiredArgsConstructor
public class InformationController {

    private final InformationService informationService;

    @GetMapping
    public ResponseEntity<Page<InformationDTO>> getByPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok().body(informationService.findAll(pageable));
    }

    @GetMapping("/{code}")
    public ResponseEntity<InformationDTO> getByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok().body(informationService.findById(code));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestParam("file") MultipartFile file) {
        informationService.uploadCSV(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        informationService.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
