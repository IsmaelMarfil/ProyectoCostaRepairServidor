package com.example.costarepair.controller;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import com.example.costarepair.service.ClienteService;
import com.example.costarepair.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }
    @GetMapping({"" , "/"})
    public List<Vehiculo> all(){
        log.info("Accediendo a todos los vehiculos");
        return this.vehiculoService.all();

    }

    @PostMapping({"", "/"})
    public Vehiculo newVehiculo(@RequestBody Vehiculo vehiculo){return this.vehiculoService.save(vehiculo);}

    @GetMapping("/{id}")
    public Vehiculo one(@PathVariable("id") Long id) {
        return this.vehiculoService.one(id);
    }

    @PutMapping("/{id}")
    public Vehiculo replceVehiculo(@PathVariable("id") Long id, @RequestBody Vehiculo vehiculo) {
        return this.vehiculoService.replace(id, vehiculo);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable("id") Long id) {
        this.vehiculoService.delete(id);
    }



}
