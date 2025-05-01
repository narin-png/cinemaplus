package az.coders.cinemaplus.service.impl;

import az.coders.cinemaplus.config.EnhancedObjectMapper;
import az.coders.cinemaplus.dto.UserDto;
import az.coders.cinemaplus.entity.User;
import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.exception.NotFoundException;
import az.coders.cinemaplus.model.request.UserRequest;
import az.coders.cinemaplus.repository.UserRepository;
import az.coders.cinemaplus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EnhancedObjectMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return mapper.convertList(userRepository.findAll(), UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return mapper.convertValue(findById(id), UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.convertValue(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        User findUser = findById(id);
        User user = mapper.convertValue(userDto, User.class);
        user.setId(findUser.getId());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserRequest updateUser(Integer id, UserRequest userRequest) {
        User findUser = findById(id);
        User user = mapper.convertValue(userRequest, User.class);
        user.setId(findUser.getId());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserRequest.class);
    }

    private User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
