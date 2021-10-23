/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3.oct.Reto_3;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhone
 */
@Service
public class ServiciosFarm {
     @Autowired
    private RepositorioFarm metodosCrud;

    public List<Farm> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Farm> getFarm(int farmId) {
        return metodosCrud.getFarm(farmId);
    }

    public Farm save(Farm farm){
        if(farm.getId()==null){
            return metodosCrud.save(farm);
        }else{
            Optional<Farm> e=metodosCrud.getFarm(farm.getId());
            if(e.isEmpty()){
                return metodosCrud.save(farm);
            }else{
                return farm;
            }
        }
    }

    public Farm update(Farm farm){
        if(farm.getId()!=null){
            Optional<Farm> e=metodosCrud.getFarm(farm.getId());
            if(!e.isEmpty()){
                if(farm.getAddress()!=null){
                    e.get().setAddress(farm.getAddress());
                }
                if(farm.getExension()!=null){
                    e.get().setExension(farm.getExension());
                }
                if(farm.getCateg_id()!=null){
                    e.get().setCateg_id(farm.getCateg_id());
                }
                if(farm.getName()!=null){
                    e.get().setName(farm.getName());
                }                
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return farm;
            }
        }else{
            return farm;
        }
    }


    public boolean deleteFarm(int farmId) {
        Boolean aBoolean = getFarm(farmId).map(farm -> {
            metodosCrud.delete(farm);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
