package br.dev.bina.garage.repositories;


 import br.dev.bina.garage.entities.Veiculo;
 import org.springframework.data.jpa.repository.JpaRepository;
 
 /**
  *
  * @author sesidevb
  */
 public interface GarageRepository extends JpaRepository<Veiculo, Long>{
     
 }

