package com.example.costarepair.controller;

import com.example.costarepair.domain.Cita;
import com.example.costarepair.domain.Cliente;
import com.example.costarepair.service.CitaService;
import com.example.costarepair.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/citas")
public class CitaController {
    private final CitaService citaService;

    public CitaController(CitaService citaService){
        this.citaService = citaService;
    }
    @GetMapping({"" , "/"})
    public List<Cita> all(){
        log.info("Accediendo a todos las citas");
        return this.citaService.all();

    }

    @PostMapping({"", "/"})
    public Cita newCita(@RequestBody Cita cita){return this.citaService.save(cita);}

    @GetMapping("/{id}")
    public Cita one(@PathVariable("id") Long id) {
        return this.citaService.one(id);
    }

    @PutMapping("/{id}")
    public Cita replaceCita(@PathVariable("id") Long id, @RequestBody Cita cita) {
        return this.citaService.replace(id, cita);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable("id") Long id) {
        this.citaService.delete(id);
    }


}
