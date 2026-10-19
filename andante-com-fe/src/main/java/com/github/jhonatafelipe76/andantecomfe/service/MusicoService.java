package com.github.jhonatafelipe76.andantecomfe.service;

import com.github.jhonatafelipe76.andantecomfe.model.Musico;
import com.github.jhonatafelipe76.andantecomfe.repository.MusicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicoService {
    private final MusicoRepository musicoRepository;

    public MusicoService(MusicoRepository musicoRepository) {
        this.musicoRepository = musicoRepository;
    }

    public Musico salvar(Musico musico){
        return musicoRepository.save(musico);
    }

    public List<Musico> listarMusicos() {
        return musicoRepository.findAll();
    }

    public Optional<Musico> buscarPorId(Long id){
        return musicoRepository.findById(id);
    }

    public void excluirPorId(Long id){
        musicoRepository.deleteById(id);
    }






}