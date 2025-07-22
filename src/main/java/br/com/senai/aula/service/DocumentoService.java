package br.com.senai.aula.service;

import br.com.senai.aula.dto.DocumentoDTO;
import br.com.senai.aula.dto.mapper.DocumentoMapper;
import br.com.senai.aula.model.Documento;
import br.com.senai.aula.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public DocumentoDTO salvar(DocumentoDTO documentoDTO) {
        Documento documento = DocumentoMapper.toEntity(documentoDTO);
        Documento salvo = documentoRepository.save(documento);
        return DocumentoMapper.toDTO(salvo);
    }

    public List<DocumentoDTO> listarTodos() {
        return documentoRepository.findAll()
                .stream()
                .map(DocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DocumentoDTO> buscarPorId(Long id) {
        return documentoRepository.findById(id)
                .map(DocumentoMapper::toDTO);
    }

    public void excluir(Long id) {
        documentoRepository.deleteById(id);
    }

    public DocumentoDTO buscarPorCpf(String cpf) {
        Documento documento = documentoRepository.findByCpf(cpf);
        return DocumentoMapper.toDTO(documento);
    }

    public DocumentoDTO buscarPorRg(String rg) {
        Documento documento = documentoRepository.findByRg(rg);
        return DocumentoMapper.toDTO(documento);
    }

    public List<DocumentoDTO> buscarPorNomeDaPessoa(String nome) {
        return documentoRepository.findByNomeDaPessoa(nome)
                .stream()
                .map(DocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }
}

