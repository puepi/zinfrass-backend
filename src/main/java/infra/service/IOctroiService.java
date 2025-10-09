package infra.service;

import infra.dto.request.OctroiRequestDto;
import infra.dto.response.OctroiResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOctroiService {
    OctroiResponseDto addOctroi(OctroiRequestDto requestDto);
    List<OctroiResponseDto> getAllOctrois();

    void deleteOctroi(Long id);
}
