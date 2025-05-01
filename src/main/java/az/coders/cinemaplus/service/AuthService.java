package az.coders.cinemaplus.service;

import az.coders.cinemaplus.model.request.auth.SignInRequest;
import az.coders.cinemaplus.model.response.auth.SignInResponse;
import org.springframework.http.HttpHeaders;

public interface AuthService {
    SignInResponse signIn(SignInRequest signInRequest);

    void setCookies(HttpHeaders headers, SignInResponse signInResponse);

    void clearCookie(HttpHeaders headers);

    void signOut(String refreshToken);



    SignInResponse refreshCookie(String refreshToken);
}
