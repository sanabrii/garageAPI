package br.dev.bina.garage.repositories;


import br.dev.bina.garage.entities.Veiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 
 /**
  *
  * @author sesidevb
  */
public interface GarageRepository extends JpaRepository<Veiculo, Long>{
     
    List<Veiculo> findByCorIgnoreCase(String cor);
    List<Veiculo> findByModeloIgnoreCase(String modelo);
     
}

