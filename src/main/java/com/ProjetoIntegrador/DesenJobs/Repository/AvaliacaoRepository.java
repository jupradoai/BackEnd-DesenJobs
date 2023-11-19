package com.ProjetoIntegrador.DesenJobs.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ProjetoIntegrador.DesenJobs.Entity.Avaliacao;

public interface AvaliacaoRepository extends MongoRepository<Avaliacao, ObjectId> {
    // Se necessário, adicione métodos personalizados aqui
}
