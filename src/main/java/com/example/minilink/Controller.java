package com.example.minilink;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public class Controller {
    private Map<String, String> links = new HashMap<>();

    @PostMapping("/encurtar")
    public LinkRecode.LinkRecord encurtar (@RequestBody String urlrecebida){
        String id = UUID.randomUUID().toString().substring(0, 6);

                links.put(id, urlrecebida);

                        return new LinkRecode.LinkRecord(id, urlrecebida);
    }

    @GetMapping("/{id}")
    public String buscar(@PathVariable String id) {
        return links.getOrDefault(id, "Link não encontrado!");
    }

}
