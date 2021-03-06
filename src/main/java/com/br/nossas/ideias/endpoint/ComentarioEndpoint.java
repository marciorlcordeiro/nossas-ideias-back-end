package com.br.nossas.ideias.endpoint;


import com.br.nossas.ideias.error.ResourceNotFoundExcepction;
import com.br.nossas.ideias.model.Comentario;
import com.br.nossas.ideias.model.Ideia;
import com.br.nossas.ideias.repository.ComentarioRepository;
import com.br.nossas.ideias.repository.IdeiaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api//comentarios")
public class ComentarioEndpoint {

    private final ComentarioRepository comentarioDAO;

    public ComentarioEndpoint(ComentarioRepository comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(comentarioDAO.findAll(pageable),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin
    public ResponseEntity<?> getComentarioByIdIdeia(@PathVariable("id") Long id) {
        List<Comentario> comentario = comentarioDAO.findByIdIdeia(id);
        if(comentario == null)
            throw new ResourceNotFoundExcepction("Ideia not found for Id " + id);
        return new ResponseEntity<>(comentario,HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Comentario comentario) {
        comentarioDAO.save(comentario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}