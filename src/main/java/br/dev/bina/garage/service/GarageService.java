/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.bina.garage.service;

import br.dev.bina.garage.entities.Veiculo;
import br.dev.bina.garage.repositories.GarageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
/**
 *
 * @author sesidevb
 */
@Service
public class GarageService {
    
    @Autowired
    private GarageRepository garageRepository;
     
    public List<Veiculo> findAll() {
        List<Veiculo> result = garageRepository.findAll();
        return result;
    }
     
        
    public List<Veiculo> findByCor(String cor) {
        List<Veiculo> result = garageRepository.findByCorIgnoreCase(cor);
        return result;
    }
}
