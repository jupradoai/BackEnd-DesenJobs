package com.ProjetoIntegrador.DesenJobs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProjetoIntegrador.DesenJobs.Entity.Avaliacao;
import com.ProjetoIntegrador.DesenJobs.Repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
@ComponentScan 
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Transactional
    public Avaliacao salvar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

	
}
