package com.github.jhonatafelipe76.andantecomfe.controller;

import com.github.jhonatafelipe76.andantecomfe.model.Musico;
import com.github.jhonatafelipe76.andantecomfe.service.MusicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/musicos")
public class MusicoController {

    private final MusicoService musicoService;

    public MusicoController(MusicoService musicoService) {
        this.musicoService = musicoService;
    }

    @GetMapping("formulario")
    public String exibirFormulário(Model model) {
        model.addAttribute("musico", new Musico());
        return "musicos/formulario";

    }

    @GetMapping("lista")
    public String listarMusico (Model model) {
        model.addAttribute("musicos", musicoService.listarMusicos());
        return "/musicos/lista";

    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        musicoService.excluirPorId(id);
        return "redirect:/lista";

    }

   @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Musico musico) {
        musicoService.salvar(musico);
        return "redirect:/lista";
   }

   @GetMapping("/editar/{id}")
   public String editar(@PathVariable Long id, Model model) {
        Optional<Musico> musico = musicoService.buscarPorId(id);
        if (musico.isPresent()) {
            model.addAttribute("musico", musico.get());
            return "musico/formulario";
        }
        return "redirect:/musico/lista";
   }





}
