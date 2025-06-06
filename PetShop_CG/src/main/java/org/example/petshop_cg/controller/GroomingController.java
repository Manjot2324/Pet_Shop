package org.example.petshop_cg.controller;

import org.example.petshop_cg.entity.GroomingService;
import org.example.petshop_cg.repository.GroomingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroomingController {

    @Autowired
    GroomingRepo groomingRepo;

    public GroomingRepo getGroomingRepo() {
        return groomingRepo;
    }

    @GetMapping("/services")
    public List<GroomingService> getGroomingServices(GroomingService groomingService) {
        return groomingRepo.findAll();
    }
}
