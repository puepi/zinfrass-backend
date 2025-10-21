package infra.dto.request;

import lombok.Data;

@Data
public class AppUserRequestDto {
    private String username;
    private String password;
}
