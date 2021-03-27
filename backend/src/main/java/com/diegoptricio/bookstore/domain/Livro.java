package com.diegoptricio.bookstore.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Livros")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nomeAutor")
    private String nomeAutor;
    @Column(name = "texto")
    private String texto;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
