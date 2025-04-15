package com.platzi.platzi_pizzeria.web.controller;


import com.platzi.platzi_pizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzi_pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private  PizzaService pizzaService;

//    @Autowired
//    public PizzaController(PizzaService pizzaService) {
//        this.pizzaService = pizzaService;
//    }

//    @GetMapping
//    public ResponseEntity <List<PizzaEntity>> getAll(){
//        return  ResponseEntity.ok(this.pizzaService.getAll()) ;
//    }

    @GetMapping("/pizzaRepository")
    public List<PizzaEntity> getAllPizzas(){
        return  this.pizzaService.getAllPizza();
    }

    @GetMapping("/{idPizza}")
    public PizzaEntity getPizzaById(@PathVariable int idPizza){
            return this.pizzaService.getPizzaById(idPizza);
    }

    @PostMapping()
    public PizzaEntity savePizza(@RequestBody PizzaEntity pizza){
        return this.pizzaService.savePizza(pizza);
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<String> DeletePizza(@PathVariable int idPizza){
            try {
                if(this.pizzaService.ExistPizza(idPizza)){
                    this.pizzaService.deletePizza(idPizza);

                    return ResponseEntity.ok().build();
                }else{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ese id");
                }
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(e.getMessage());
            }


    }



    /*--------------------------QUERY METHOD------------*/

    @GetMapping("/available")
    public List<PizzaEntity> getAllByAvailable(){
        return this.pizzaService.getAllByAvailable();
    }

    @GetMapping("/available/{name}")
    public List<PizzaEntity> getAllByAvailableAndName(@PathVariable String name){
        return this.pizzaService.getAllByAvailableAndName(name);
    }

    @GetMapping("/available/petition")
    public  List<PizzaEntity> getAllByAvailableTrueAndDescriptionContainingIgnoreCase(@RequestParam String description ){
        return this.pizzaService.getAllByAvailableContainingDescription(description);
    }
    @GetMapping("/available/no")
    public  List<PizzaEntity> getAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(@RequestParam String description ){
        return this.pizzaService.getAllByAvailableNotContainingDescription(description);
    }


    @GetMapping("/available/1")
    public  PizzaEntity getPizza(@RequestParam String name ){
        return this.pizzaService.getPizzaByName(name);
    }

    @GetMapping("/top/3")
    public  List<PizzaEntity> getPizza3(){
        return this.pizzaService.getTop3Pizza(20);
    }
    @GetMapping("/topMayor/3")
    public  List<PizzaEntity> getPizza3Mayor(){
        return this.pizzaService.getTop3PizzaMayor(20);
    }

}
