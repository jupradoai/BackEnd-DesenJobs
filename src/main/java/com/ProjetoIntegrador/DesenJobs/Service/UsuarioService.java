package com.ProjetoIntegrador.DesenJobs.Service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetoIntegrador.DesenJobs.Entity.Usuario;
import com.ProjetoIntegrador.DesenJobs.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@ComponentScan 
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true )
    public Usuario buscarPorId(ObjectId id){
        return usuarioRepository.findById(id).orElseThrow( () -> new RuntimeException("USUARIO NÃO ENCONTRADO"));
    }
    
    @Transactional
    public Usuario editarSenha(ObjectId  id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password, password);
        return user;
    }


    @Transactional(readOnly = true)
    public List<Usuario> burcarTodos() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public boolean autenticar(String email, String password) {
        // Verifique se o usuário com o email fornecido existe
        Usuario user = usuarioRepository.findByEmail(email);
        if (user == null) {
            return false; // Usuário não encontrado
        }

        // Verifique se a senha fornecida coincide com a senha no banco de dados
        return user.getPassword().equals(password);
    }
}
