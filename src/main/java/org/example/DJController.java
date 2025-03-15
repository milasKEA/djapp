package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Change to @Controller
@RequestMapping("/api/djs")
public class DJController {

    private final DJService djService;

    @Autowired
    public DJController(DJService djService) {
        this.djService = djService;
    }

    @PostMapping
    public ResponseEntity<DJ> createDJ(@RequestBody DJ dj) {
        System.out.println(dj.getBio());
        return ResponseEntity.ok(djService.createDJ(dj));
    }

    @GetMapping("/allDjs")
    public ResponseEntity<List> getAllDJs() {
        System.out.println("før iteration");
        List djList = djService.getAllDJs();
        for (Object o : djList) {
            System.out.println(o);
        }
        return ResponseEntity.ok(djList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DJ> getDJById(@PathVariable Long id) {
        DJ dj = djService.getDJById(id);
        return dj != null ? ResponseEntity.ok(dj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DJ> updateDJ(@PathVariable Long id, @RequestBody DJ dj) {
        DJ updatedDJ = djService.updateDJ(id, dj);
        return updatedDJ != null ? ResponseEntity.ok(updatedDJ) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDJ(@PathVariable Long id) {
        djService.deleteDJ(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/djs") // This can stay as an endpoint for fetching DJs
    public String showAllDJs(Model model) {
        List<DJ> djs = djService.findAllDJs(); // Use your existing service to fetch DJs
        model.addAttribute("djs", djs);
        return "djs"; // This is the name of your HTML file (djs.html)
    }
}