package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DJServiceImpl implements DJService {

    private final DJRepository djRepository;

    @Autowired
    public DJServiceImpl(DJRepository djRepository) {
        this.djRepository = djRepository;
    }

    @Override
    public DJ createDJ(DJ dj) {
        return djRepository.save(dj);
    }

    @Override
    public List<DJ> getAllDJs() {
        return djRepository.findAll();
    }

    @Override
    public DJ getDJById(Long id) {
        return djRepository.findById(id).orElse(null);
    }

    @Override
    public DJ updateDJ(Long id, DJ dj) {
        Optional<DJ> existingDJ = djRepository.findById(id);
        if (existingDJ.isPresent()) {
            dj.setId(id); // Set the ID to maintain the same entry
            return djRepository.save(dj);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteDJ(Long id) {
        djRepository.deleteById(id);
    }
    @Override
    public List<DJ> findAllDJs() {
        return djRepository.findAll(); // Returns all DJs
    }
}