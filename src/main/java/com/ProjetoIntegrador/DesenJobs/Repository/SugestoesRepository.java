package com.ProjetoIntegrador.DesenJobs.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ProjetoIntegrador.DesenJobs.Entity.Sugestoes;

public interface SugestoesRepository extends MongoRepository<Sugestoes, ObjectId> {
    
}
