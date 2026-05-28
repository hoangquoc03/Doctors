package org.example.namingconvention.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @PostMapping("/appointment")
    public ResponseEntity<?> bookAppointment(
            @RequestParam(required = false) String patientName) {

        if (patientName == null || patientName.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Patient name is required");
        }

        return ResponseEntity.ok("Appointment booked successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable int id) {

        if (id == 999) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Medical record not found");
        }

        return ResponseEntity.ok("Patient found");
    }

    @GetMapping("/database-error")
    public ResponseEntity<?> databaseError() {

        try {
            throw new RuntimeException("MySQL crashed");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error");
        }
    }

    @PostMapping("/age")
    public ResponseEntity<?> checkAge(@RequestParam int age) {

        if (age < 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Age must be greater than or equal to 0");
        }

        return ResponseEntity.ok("Valid age");
    }
}
