package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "PAPEIS")
@AllArgsConstructor
@NoArgsConstructor
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @ManyToMany(mappedBy = "papeis", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;
}
