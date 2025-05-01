package az.coders.cinemaplus.model.response.auth;

import az.coders.cinemaplus.dto.RefreshTokenDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInResponse {
    private AccessTokenResponse accessToken;
    private RefreshTokenDTO refreshToken;
}
