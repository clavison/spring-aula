package br.com.senai.aula.service;

import br.com.senai.aula.dto.PessoaDTO;
import br.com.senai.aula.dto.mapper.PessoaMapper;
import br.com.senai.aula.model.Pessoa;
import br.com.senai.aula.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO salvar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDTO);
        if (pessoa.getDocumento() != null) {
            pessoa.getDocumento().setPessoa(pessoa);
        }
        Pessoa salva = pessoaRepository.save(pessoa);
        return PessoaMapper.toDTO(salva);
    }

    public List<PessoaDTO> listarTodas() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PessoaDTO> buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(PessoaMapper::toDTO);
    }

    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

    public PessoaDTO buscarPorEmail(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        return PessoaMapper.toDTO(pessoa);
    }

    public List<PessoaDTO> buscarPorNome(String nome) {
        return pessoaRepository.findByNomeLike("%" + nome + "%")
                .stream()
                .map(PessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> buscarPorDataNascimentoAntes(LocalDate data) {
        return pessoaRepository.findPessoasNascidasAntesDe(data)
                .stream()
                .map(PessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO buscarPorCpfDoDocumento(String cpf) {
        Pessoa pessoa = pessoaRepository.findByCpfDoDocumento(cpf);
        return PessoaMapper.toDTO(pessoa);
    }
}
