package com.irshita.patel.controller;

import com.irshita.patel.model.IrshitaModel;
import com.irshita.patel.service.IrshitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class IrshitaController {

    @Autowired
    private IrshitaService irshitaService;

    @GetMapping(path = "/irshita")
    public String getMessage(){
        return "Hello, Irshita!!";
    }

    @PostMapping(path = "/saveIrshita")
    public ResponseEntity<IrshitaModel> createIrshita(@RequestBody IrshitaModel irshitaModel){
        return ResponseEntity.ok().body(this.irshitaService.saveIrshita(irshitaModel));
    }

    @PutMapping(path = "/updateIrshita/{id}")
    public ResponseEntity<IrshitaModel> updateIrshita(@PathVariable Integer id, @RequestBody IrshitaModel model) throws IllegalAccessException {
        model.setIshId(id);
        return ResponseEntity.ok().body(this.irshitaService.updateIrshitaObjectById(model));
    }

    @GetMapping(path = "/getIrshita/{id}")
    public ResponseEntity<IrshitaModel> getIrshitaById(@PathVariable Integer id) throws IllegalAccessException {
        return ResponseEntity.ok().body(this.irshitaService.getSingleIrshitaObjectById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    public HttpStatus deleteIrshita(@PathVariable Integer id){
        this.irshitaService.deleteIrshitaObjectById(id);
        return HttpStatus.OK;
    }

}