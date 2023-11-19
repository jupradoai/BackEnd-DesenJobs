package com.ProjetoIntegrador.DesenJobs.Entity;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Getter @Setter @NoArgsConstructor
@Document(collection = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @Field(name = "id")
    private ObjectId id;

    @Nonnull
    @JsonProperty("nome")
    @Field(name = "nome")
    private String nome;
    
    @Nonnull
    @JsonProperty("email")
    @Field(name = "email")
    private String email;
    
    @Nonnull
    @JsonProperty("telefone")
    @Field(name = "telefone")
    private String telefone;

    @Nonnull
    @JsonProperty("password")
    @Field(name = "password")
    private String password;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id != null && id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }

    @JsonProperty
    public void setPassword(String password2, String password) {
		this.password = password;
		
	}
    @JsonProperty
	public String getPassword() {	return this.password;
	}

	public String getEmail() {
		
		return this.email;
	}
	
}
