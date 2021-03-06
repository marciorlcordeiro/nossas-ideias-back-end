package com.br.nossas.ideias.endpoint;


import com.br.nossas.ideias.model.Voto;
import com.br.nossas.ideias.repository.VotoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/votos")
public class VotoEndpoint {

    private final VotoRepository votoDAO;

    public VotoEndpoint(VotoRepository votoDAO) {
        this.votoDAO = votoDAO;
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(votoDAO.findAll(pageable),HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Voto voto) {
        votoDAO.save(voto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}