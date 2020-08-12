package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomGlobalExceptionHandler
{
    @ExceptionHandler(NotFoundException.class)
    public void parameterNotFound(HttpServletResponse httpServletResponse) throws IOException
    {
        httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
    }
}
