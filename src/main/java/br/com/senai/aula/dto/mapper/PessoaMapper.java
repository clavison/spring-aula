package br.com.senai.aula.dto.mapper;

import br.com.senai.aula.dto.PessoaDTO;
import br.com.senai.aula.dto.DocumentoDTO;
import br.com.senai.aula.model.Pessoa;
import br.com.senai.aula.model.Documento;

public class PessoaMapper {

    public static PessoaDTO toDTO(Pessoa entity) {
        if (entity == null) return null;

        DocumentoDTO documentoDTO = DocumentoMapper.toDTO(entity.getDocumento());

        return new PessoaDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getDataNascimento(),
                documentoDTO
        );
    }

    public static Pessoa toEntity(PessoaDTO dto) {
        if (dto == null) return null;

        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setDataNascimento(dto.getDataNascimento());

        Documento documento = DocumentoMapper.toEntity(dto.getDocumento());
        if (documento != null) {
            documento.setPessoa(pessoa);
        }

        pessoa.setDocumento(documento);

        return pessoa;
    }
}

