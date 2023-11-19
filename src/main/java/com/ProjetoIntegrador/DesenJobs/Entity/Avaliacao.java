package com.ProjetoIntegrador.DesenJobs.Entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.annotation.Nonnull;

@Data
@Getter @Setter @NoArgsConstructor
@Document(collection = "avaliacoes")
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Field(name = "id")
    private ObjectId id;

    
    @JsonProperty("email_avaliador")
    @Field(name = "email_avaliador")
    private String emailAvaliador;

    @Nonnull
    @JsonProperty("nome_empresa")
    @Field(name = "nome_empresa")
    private String nomeEmpresa;

    @Nonnull
    @JsonProperty("resultado_avaliacao")
    @Field(name = "resultado_avaliacao")
    private String resultadoAvaliacao;
    
    
    public Avaliacao(String emailAvaliador, String nomeEmpresa, String resultadoAvaliacao) {
        this.emailAvaliador = emailAvaliador;
        this.nomeEmpresa = nomeEmpresa;
        this.resultadoAvaliacao = resultadoAvaliacao;
    }

}
