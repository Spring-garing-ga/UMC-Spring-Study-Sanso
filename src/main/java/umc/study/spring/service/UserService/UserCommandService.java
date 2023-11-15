package umc.study.spring.service.UserService;

import umc.study.spring.domain.User;
import umc.study.spring.dto.UserRequestDTO;


public interface UserCommandService {

    public User joinUser(UserRequestDTO.JoinDTO request);
}
