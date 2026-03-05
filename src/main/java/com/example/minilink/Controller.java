package com.example.minilink;

import com.example.minilink.Link;
import com.example.minilink.LinkRecode;
import com.example.minilink.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private LinkRepository repository;

    @PostMapping("/encurtar")
    public LinkRecode.LinkRecord encurtar(@RequestBody String urlrecebida) {
        String id = UUID.randomUUID().toString().substring(0, 6);
        Link novoLink = new Link(id, urlrecebida);
        repository.save(novoLink); // Agora o erro de 'S' deve sumir
        return new LinkRecode.LinkRecord(id, urlrecebida);
    }

    @GetMapping("/{id}")
    public String buscar(@PathVariable String id) {
        // Corrigido para findById e parênteses ajustados
        return repository.findById(id).map(link -> {
            repository.incrementarCliques(id);
            return link.getUrlOriginal();
        }).orElse("Link não encontrado!");
    }
}