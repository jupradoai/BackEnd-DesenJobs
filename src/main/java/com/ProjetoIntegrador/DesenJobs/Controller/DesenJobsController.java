package com.ProjetoIntegrador.DesenJobs.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoIntegrador.DesenJobs.Entity.Usuario;
import com.ProjetoIntegrador.DesenJobs.Service.UsuarioService;

@RestController
@RequestMapping("api/DJ/usuarios")
public class DesenJobsController {

    private final UsuarioService usuarioService;

    @Autowired
    public DesenJobsController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        // Verifique as credenciais do usuário
        if (usuarioService.autenticar(usuario.getEmail(), usuario.getPassword())) {
            // Se as credenciais forem válidas, retorne uma mensagem de sucesso
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            // Se as credenciais não forem válidas, retorne um erro não autorizado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getbyId(@PathVariable ObjectId  id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable ObjectId  id, @RequestBody Usuario usuario) {
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> users= usuarioService.burcarTodos();
        return ResponseEntity.ok(users);
    }
}
