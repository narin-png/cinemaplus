package az.coders.cinemaplus.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class HeaderInterceptor implements HandlerInterceptor {// interceptor service catmadan isler gormeye komek edir ve ya bir code commondursa her service cpntrollerde yazms=qdansa burda yaz
    public static final String HEADER_LANGUAGE = "Language";
    public static String LANGUAGE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LANGUAGE = request.getHeader(HEADER_LANGUAGE);
        return true;

    }
// aftercompletion override controller isin bitirenden sonra
    //pre controllerlere catrmadan once
    //post controller bitir ama view  rendered
}
