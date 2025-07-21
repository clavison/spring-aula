package br.com.senai.aula.service;

import br.com.senai.aula.model.Documento;
import br.com.senai.aula.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento salvar(Documento documento) {
        return documentoRepository.save(documento);
    }

    public List<Documento> listarTodos() {
        return documentoRepository.findAll();
    }

    public Optional<Documento> buscarPorId(Long id) {
        return documentoRepository.findById(id);
    }

    public void excluir(Long id) {
        documentoRepository.deleteById(id);
    }

    public Documento buscarPorCpf(String cpf) {
        return documentoRepository.findByCpf(cpf);
    }

    public Documento buscarPorRg(String rg) {
        return documentoRepository.findByRg(rg);
    }

    public List<Documento> buscarPorNomeDaPessoa(String nome) {
        return documentoRepository.findByNomeDaPessoa(nome);
    }
}

