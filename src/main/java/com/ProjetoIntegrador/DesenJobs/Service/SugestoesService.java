package com.ProjetoIntegrador.DesenJobs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProjetoIntegrador.DesenJobs.Entity.Sugestoes;
import com.ProjetoIntegrador.DesenJobs.Repository.SugestoesRepository;

@Service
public class SugestoesService {

    private final SugestoesRepository sugestoesRepository;

    @Autowired
    public SugestoesService(SugestoesRepository sugestoesRepository) {
        this.sugestoesRepository = sugestoesRepository;
    }

    @Transactional
    public Sugestoes salvar(Sugestoes sugestao) {
        return sugestoesRepository.save(sugestao);
    }

}
