package az.coders.cinemaplus.service;

import az.coders.cinemaplus.dto.UserDto;
import az.coders.cinemaplus.model.request.UserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> getUsers();

    UserDto getUserById(Integer id);

    UserDto createUser(UserDto userDto);

    void deleteUser(Integer id);

    UserDto updateUser(Integer id, UserDto userDto);
    UserRequest updateUser(Integer id, UserRequest userRequest);
}
