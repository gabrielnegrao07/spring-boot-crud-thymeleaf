package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "USUARIOS")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "SENHA")
    private String senha;

    @JoinTable(name = "USUARIOS_PAPEIS",
            joinColumns = {@JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PAPEL")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Papel> papeis;

    @Column(name = "ATIVADO")
    private Boolean ativado;

    @Column(name = "DATA_HORA_CADASTRO")
    private LocalDateTime dataHoraCadastro;
}
