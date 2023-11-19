package com.ProjetoIntegrador.DesenJobs.Entity;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Getter @Setter @NoArgsConstructor
@Document(collection = "sugestoes")
public class Sugestoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Field(name = "id")
    private ObjectId id;

    @JsonProperty("email_usuario")
    @Field(name = "email_usuario")
    private String emailUsuario;
    
    @Nonnull
    @JsonProperty("nome_empresa")
    @Field(name = "nome_empresa")
    private String nomeEmpresa;

    @Nonnull
    @JsonProperty("sugestao_melhoria")
    @Field(name = "sugestao_melhoria")
    private String sugestaoMelhoria;

    public Sugestoes(String emailUsuario, String nomeEmpresa, String sugestaoMelhoria) {
        this.emailUsuario = emailUsuario;
        this.nomeEmpresa = nomeEmpresa;
        this.sugestaoMelhoria = sugestaoMelhoria;
    }
    
   
}
