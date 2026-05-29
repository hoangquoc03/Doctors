package org.example.namingconvention.controller;


import org.example.namingconvention.dto.ApiResponse;
import org.example.namingconvention.dto.Doctor;
import org.example.namingconvention.dto.Meta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @GetMapping("/{doctorId}/appointments")
    public String getAppointmentsByDoctor(@PathVariable int doctorId){
        return "List appointments of doctor Id = " +doctorId;
    }
    @GetMapping
    public ApiResponse<List<Doctor>> getAllDoctors(){
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(1,"Nguyen Van A","Cardiology"));
        doctors.add(new Doctor(2,"Nguyen Van B","Neurology"));
        Meta meta = new Meta(2,1);
        return new ApiResponse<>(
                "success",
                200,
                doctors,
                meta
        );
    }
}
