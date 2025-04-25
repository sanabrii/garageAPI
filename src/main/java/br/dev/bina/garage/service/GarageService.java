/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.bina.garage.service;

import br.dev.bina.garage.DTO.VeiculoMinDTO;
import br.dev.bina.garage.entities.Veiculo;
import br.dev.bina.garage.repositories.GarageRepository;
import java.util.List;
import java.util.Optional;
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
    
    public Optional<Veiculo> findById(long id) {
         return garageRepository.findById(id);
     }
     
    public List<Veiculo> findByCor(String cor) {
        List<Veiculo> result = garageRepository.findByCorIgnoreCase(cor);
        return result;
    }
    
    public List<VeiculoMinDTO> findByModelo(String modelo) {
        List<Veiculo> resultGarage = garageRepository.findByModeloIgnoreCase(modelo);
        
        List<VeiculoMinDTO> resultDTO = resultGarage.stream()
                .map(x -> new VeiculoMinDTO(x)).toList();
        
        return resultDTO;
    }
    
    public List<VeiculoMinDTO> findByAno(int ano) {
        List<Veiculo> resultGarage = garageRepository.findByAno(ano);
        
        List<VeiculoMinDTO> resultDTO = resultGarage.stream()
                .map(x -> new VeiculoMinDTO(x)).toList();
        
        return resultDTO;
    }
}
