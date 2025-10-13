package infra.service;

import infra.dto.request.PosteRequestDto;
import infra.dto.response.PosteResponseDto;
import infra.model.Poste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPosteService {
    PosteResponseDto addPoste(PosteRequestDto requestDto);

    Poste getPoste(Long id);

    List<PosteResponseDto> getAllPostes();

    Page<PosteResponseDto> getPaginatedAllPostes(Pageable pageable);
}
