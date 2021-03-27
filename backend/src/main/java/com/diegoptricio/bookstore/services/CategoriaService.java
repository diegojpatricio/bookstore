package com.diegoptricio.bookstore.services;

import com.diegoptricio.bookstore.domain.Categoria;
import com.diegoptricio.bookstore.domain.DTO.CategoriaDTO;
import com.diegoptricio.bookstore.repositories.CategoriaRepository;
import com.diegoptricio.bookstore.services.exceptions.ObjectNotFoundExeption;
import com.diegoptricio.bookstore.services.exceptions.ViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository cr;

    public Categoria buscarCategoriaId(Integer id){
        Optional<Categoria> categoria = cr.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundExeption("Objeto não encontrato! id: " + id +
                ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> listarCategoria(){
        return cr.findAll();
    }

    public Categoria criarCategoria(Categoria obj){
        obj.setId(null);
        return cr.save(obj);
    }

    public Categoria atualizar(Integer id, CategoriaDTO objDTO) {
        Categoria obj = buscarCategoriaId(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return cr.save(obj);
    }

    public void deletar(Integer id) {
        buscarCategoriaId(id);
        try {
            cr.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new ViolationException("A categoria não pode ser deletado. Possui livros acessiados.");
        }


    }
}
