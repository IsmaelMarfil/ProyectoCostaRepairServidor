package com.example.costarepair.controller;

import com.example.costarepair.domain.Cliente;
import com.example.costarepair.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @GetMapping({"" , "/"})
    public List<Cliente> all(){
        log.info("Accediendo a todos los clientes");
        return this.clienteService.all();

    }
    @GetMapping(value = {"", "/"}, params={"!buscar", "!ordenar"} )
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "pagina", defaultValue = "0") int pagina,
                                                   @RequestParam(value="tamano", defaultValue = "3") int tamano) {
        log.info("Accediendo a todos los clientes con paginación");
        Map<String, Object> responseAll = this.clienteService.all(pagina, tamano);
        return ResponseEntity.ok(responseAll);
    }

    @PostMapping({"", "/"})
    public Cliente newCliente(@RequestBody Cliente cliente){return this.clienteService.save(cliente);}

    @GetMapping("/{id}")
    public Cliente one(@PathVariable("id") Long id) {
        return this.clienteService.one(id);
    }

    @PutMapping("/{id}")
    public Cliente replaceCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return this.clienteService.replace(id, cliente);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable("id") Long id) {
        this.clienteService.delete(id);
    }



}
