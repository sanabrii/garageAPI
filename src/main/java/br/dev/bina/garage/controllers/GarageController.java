package br.dev.bina.garage.controllers;


import br.dev.bina.garage.entities.Veiculo;
import br.dev.bina.garage.service.GarageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
