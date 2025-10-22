package infra.service;

import infra.dto.Mapper;
import infra.dto.request.AppUserRequestDto;
import infra.exception.ResourceNotFoundException;
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

    @Override
    public String login(AppUserRequestDto user) {
        AppUser theUser=userRepository.findByUsername(user.getUsername())
                .orElseThrow(()->new ResourceNotFoundException("User not found"));
        if(theUser.getPassword().equals(user.getPassword()))
            return "Successfully logged in";
        return "Failed to log in";
    }
}
