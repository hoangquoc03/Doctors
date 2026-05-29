package org.example.namingconvention.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @GetMapping("/{doctorId}/appointments")
    public String getAppointmentsByDoctor(@PathVariable int doctorId){
        return "List appointments of doctor Id = " +doctorId;
    }
}
