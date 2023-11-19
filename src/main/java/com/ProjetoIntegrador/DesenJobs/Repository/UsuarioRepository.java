package com.ProjetoIntegrador.DesenJobs.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ProjetoIntegrador.DesenJobs.Entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId> {
    Usuario findByEmail(String email);
}
