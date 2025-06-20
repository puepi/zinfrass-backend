package infra.service;

import infra.dto.request.PosteRequestDto;
import infra.dto.response.PosteResponseDto;
import infra.model.Poste;
import org.springframework.stereotype.Service;

@Service
public interface IPosteService {
    PosteResponseDto addPoste(PosteRequestDto requestDto);

    Poste getPoste(Long id);
}
