package com.diegoptricio.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /**
     * O @JsonIgnore protege a APP contra serialização.
     * A serialização ocorre Devido a relação entre as entidades, pois
     * a entidade categorias possui livros e livros possui categorias.
     */
    @JsonIgnore
    @ManyToOne 
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
