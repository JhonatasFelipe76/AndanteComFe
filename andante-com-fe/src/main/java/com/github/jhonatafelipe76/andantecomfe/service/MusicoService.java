package com.github.jhonatafelipe76.andantecomfe.service;

import com.github.jhonatafelipe76.andantecomfe.model.Musico;
import com.github.jhonatafelipe76.andantecomfe.repository.MusicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicoService {
    private final MusicoRepository musicoRepository;

    public MusicoService(MusicoRepository musicoRepository) {
        this.musicoRepository = musicoRepository;
    }

    public Musico Salvar(Musico musico){
        return musicoRepository.save(musico);
    }

    public List<Musico> listarMusicos() {
        return musicoRepository.findAll();
    }




}