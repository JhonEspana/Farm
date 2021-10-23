/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3.oct.Reto_3;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhone
 */
@Repository
public class RepositorioFarm {
    @Autowired
    private InterfaceFarm crud;

    public List<Farm> getAll(){
        return (List<Farm>) crud.findAll();
    }

    public Optional<Farm> getFarm(int id){
        return crud.findById(id);
    }

    public Farm save(Farm farm){
        return crud.save(farm);
    }
    public void delete(Farm farm){
        crud.delete(farm);
    }
    
}
