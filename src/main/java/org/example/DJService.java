package org.example;

import java.util.List;

public interface DJService {
    DJ createDJ(DJ dj);

    List<DJ> getAllDJs();

    List<DJ> findAllDJs();

    DJ getDJById(Long id);

    DJ updateDJ(Long id, DJ dj);

    void deleteDJ(Long id);



}