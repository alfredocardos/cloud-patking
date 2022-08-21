package one.project.patking.Controller;


import one.project.patking.Model.Estacionamento;
import one.project.patking.Model.dto.estacionamentoDTO;
import one.project.patking.Services.estServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estacionamento")

public class estacionemntoController {
   private final estServices estServices;

    public estacionemntoController(one.project.patking.Services.estServices estServices) {
        this.estServices = estServices;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Estacionamento>> listAll() {

        return new ResponseEntity<>(estServices.listAll(), HttpStatus.OK);
    }


    @GetMapping(path = "/users/{id}")
    public ResponseEntity<Estacionamento> findByid(@PathVariable Long id) {
        return ResponseEntity.ok(estServices.FindBYidOrThrowBadRequestException(id));
    }
    @GetMapping(path = "/users/{find}")
    public ResponseEntity<List<Estacionamento>> findByLicenca(@RequestParam String l) {
        return ResponseEntity.ok(estServices.listlicensa(l));
    }


    @PostMapping(value ="/managers/create")
    public ResponseEntity<Estacionamento> save
            (@RequestBody @Valid estacionamentoDTO estacionamentoDTO) {
        return new ResponseEntity<>(estServices.create(estacionamentoDTO), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/managers/{id}") //usando o path para que o id seja inserido na tag html
    //deleta pelo id digitado
    public ResponseEntity<Estacionamento> delete(@PathVariable Long id) {
        estServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  //  @PutMapping
  //  //troca o objeto pelo id digitado
  //  public ResponseEntity<Anime> replace(@RequestBody AnimePutRequestBody anime) {
  //      animeServices.replace(anime);
  //      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  //  }

}
