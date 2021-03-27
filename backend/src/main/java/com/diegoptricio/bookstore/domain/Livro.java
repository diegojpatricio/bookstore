package com.diegoptricio.bookstore.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "LIVROS")
public class Livro {

    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String teexto;

    private Categoria categoria;

}
