package br.com.senai.aula.dto.mapper;

import br.com.senai.aula.dto.DocumentoDTO;
import br.com.senai.aula.model.Documento;

public class DocumentoMapper {

    public static DocumentoDTO toDTO(Documento entity) {
        if (entity == null) return null;

        return new DocumentoDTO(
                entity.getId(),
                entity.getCpf(),
                entity.getRg()
        );
    }

    public static Documento toEntity(DocumentoDTO dto) {
        if (dto == null) return null;

        Documento documento = new Documento();
        documento.setId(dto.getId());
        documento.setCpf(dto.getCpf());
        documento.setRg(dto.getRg());
        return documento;
    }
}

