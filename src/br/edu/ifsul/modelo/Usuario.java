package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "usuario")
public class Usuario extends Funcionario implements Serializable {

    @NotNull(message = "O apelido não pode ser nulo")
    @NotBlank(message = "O apelido deve ser informado")
    @Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
    @Column(name = "apelido", length = 20, nullable = false, unique = true)
    private String apelido;
    
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha deve ser informado")
    @Length(max = 20, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @NotNull(message = "Status não pode ser nulo")
    @Column(name = "status", nullable = false)
    private Boolean status;
    
    @NotNull(message = "Administrador não pode ser nulo")
    @Column(name = "admin", nullable = false)
    private Boolean admin;
    
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AcessoUsuario> acessos = new ArrayList<>();
    
    public Usuario() {
    }      
    
    
     public void adicionarAcesso(AcessoUsuario acesso){
        acesso.setUsuario(this);
        this.acessos.add(acesso);
    }


    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    
 public List<AcessoUsuario> getAcessos() {
        return acessos;
    }

    public void setAcessos(List<AcessoUsuario> acessos) {
        this.acessos = acessos;
    }


}

