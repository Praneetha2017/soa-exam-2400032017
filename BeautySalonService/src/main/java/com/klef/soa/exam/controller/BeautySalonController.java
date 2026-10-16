
package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.exam.entity.BeautySalon;
import com.klef.soa.exam.service.BeautySalonService;

@RestController
@RequestMapping("/beautysalon")
public class BeautySalonController {

    @Autowired
    private BeautySalonService service;

    @GetMapping("/")
    public String demo() {
        return "Spring Boot Beauty Salon Project";
    }

    @PostMapping("/Add")
    public ResponseEntity<BeautySalon> addBeautySalon(
            @RequestBody BeautySalon salon) {

        BeautySalon bs = service.add(salon);
        return ResponseEntity.status(201).body(bs);
    }

    @GetMapping("/DisplayAll")
    public ResponseEntity<List<BeautySalon>> displayAll() {

        List<BeautySalon> salons = service.displayAll();
        return ResponseEntity.status(200).body(salons);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteBeautySalon(
            @PathVariable long id) {

        String message = service.delete(id);

        if (message.equals("BeautySalon deleted successfully")) {
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
