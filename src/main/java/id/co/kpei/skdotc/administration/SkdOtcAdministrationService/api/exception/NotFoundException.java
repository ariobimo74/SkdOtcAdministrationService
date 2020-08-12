package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.api.exception;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(long id)
    {
        super("Parameter not found with id = " + id);
    }
}
