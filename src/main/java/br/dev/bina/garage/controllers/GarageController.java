package br.dev.bina.garage.controllers;


import br.dev.bina.garage.entities.Veiculo;
import br.dev.bina.garage.service.GarageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
 /**
  *
  * @author sesidevb
  */
@RestController
public class GarageController {
     
    @Autowired
    private GarageService garageService;
     
    @GetMapping("/veiculo")
    public List<Veiculo> findAll() {
        List<Veiculo> result = garageService.findAll();
        return result;
    }
    
    @GetMapping("/cor/{corName}")
    public ResponseEntity<List<Veiculo>> findByCorIgnoreCase(@PathVariable String corName) {
        List<Veiculo> result = garageService.findByCor(corName);
        
        if (result.isEmpty()) {
            //a lista está vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            //uhullll tem dados
            //ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
    
    

}
