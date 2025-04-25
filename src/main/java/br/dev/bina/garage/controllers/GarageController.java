package br.dev.bina.garage.controllers;


import br.dev.bina.garage.DTO.VeiculoMinDTO;
import br.dev.bina.garage.entities.Veiculo;
import br.dev.bina.garage.service.GarageService;
import java.util.List;
import java.util.Optional;
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
     
    @GetMapping("/forsale")
    public List<Veiculo> findAll() {
        List<Veiculo> result = garageService.findAll();
        return result;
    }
    
    @GetMapping("/forsale/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable long id) {
        Optional<Veiculo> optionalVeiculo = garageService.findById(id);
 
        if (optionalVeiculo.isPresent()) {
            Veiculo veiculo = optionalVeiculo.get();
 
            return ResponseEntity.ok(veiculo);
 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/color/{cor}")
    public ResponseEntity<List<Veiculo>> findByCorIgnoreCase(@PathVariable String cor) {
        List<Veiculo> result = garageService.findByCor(cor);
        
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
    
    @GetMapping("/model/{modelo}")
    public ResponseEntity<List<VeiculoMinDTO>> findByModeloIgnoreCase(@PathVariable String modelo) {
        
        List<VeiculoMinDTO> result = garageService.findByModelo(modelo);  
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
    
    @GetMapping("/year/{ano}")
    public ResponseEntity<List<VeiculoMinDTO>> findByAno(@PathVariable int ano) {
        
        List<VeiculoMinDTO> result = garageService.findByAno(ano);  
          
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
