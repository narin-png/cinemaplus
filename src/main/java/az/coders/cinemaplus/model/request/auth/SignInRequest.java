package az.coders.cinemaplus.model.request.auth;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
