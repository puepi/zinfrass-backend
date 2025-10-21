package infra.service;

import infra.dto.Mapper;
import infra.dto.request.AppUserRequestDto;
import infra.model.AppUser;
import infra.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements  IAppUserService{
    private final AppUserRepository userRepository;

    @Override
    public AppUser register(AppUserRequestDto requestDto) {
        return userRepository.save(Mapper.userRequestDtoToUser(requestDto));
    }
}
