package com.diegoptricio.bookstore.resources;

import com.diegoptricio.bookstore.domain.Categoria;
import com.diegoptricio.bookstore.domain.DTO.CategoriaDTO;
import com.diegoptricio.bookstore.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "api/categorias")
public class CategoriasResource {


    @Autowired
    private CategoriaService cs;

    @GetMapping(value = "/{idCategoria}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Integer idCategoria){
        Categoria categoria = cs.buscarCategoriaId(idCategoria);
        return ResponseEntity.ok().body(categoria);
    }


    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategoria(){
        List<Categoria> list = cs.listarCategoria();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria obj){
        obj = cs.criarCategoria(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO objDTO){
        Categoria addCategoria = cs.atualizar(id, objDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(addCategoria));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id){
        cs.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
