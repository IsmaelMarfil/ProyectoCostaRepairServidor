package com.example.costarepair.controller;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.domain.Vehiculo;
import com.example.costarepair.service.ClienteService;
import com.example.costarepair.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }
    @GetMapping(value = {"" , "/"}, params = {"!buscar", "!ordenar", "!pagina", "!tamano"})
    public List<Vehiculo> all(){
        log.info("Accediendo a todos los vehiculos");
        return this.vehiculoService.all();

    }
    @GetMapping(value = {"", "/"}, params={"!buscar", "!ordenar"} )
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "pagina", defaultValue = "0") int pagina,
                                                   @RequestParam(value="tamano", defaultValue = "3") int tamano) {
        log.info("Accediendo a todos los vehiculos con paginación");
        Map<String, Object> responseAll = this.vehiculoService.all(pagina, tamano);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = {"","/"}, params = {"!pagina", "!tamano"})
    public List<Vehiculo> all(@RequestParam("buscar") Optional<String> buscarOptional,
                               @RequestParam("ordenar") Optional<String> ordenarOptional
    ) {
        log.info("Accediendo a todos los vehiculos con filtro buscar: %s y ordenar: %s" +
                buscarOptional.orElse("VOID"), ordenarOptional.orElse("VOID")
       );
        return this.vehiculoService.allByQueryFiltersStream(buscarOptional, ordenarOptional);
    }

    @PostMapping(value = {"", "/"})
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
