package infra.service;

import infra.dto.request.AppUserRequestDto;
import infra.model.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface IAppUserService {
    public AppUser register(AppUserRequestDto requestDto);

    String login(AppUserRequestDto user);
}
