package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.service;

import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.dto.SystemParameterDto;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.entity.SystemParameter;

import java.util.List;
import java.util.Optional;

public interface SystemParameterService
{
    List<SystemParameterDto> getAll();

    List<SystemParameterDto> getAll(String sortBy, int rowPerPage, int page);

    List<SystemParameterDto> getAll(String sortBy, String theParam, String theStatus, double startVal, double endVal,
                                    String startDate, String endDate, int rowPerPage, int page);

    Optional<SystemParameterDto> getById(int id);

    SystemParameter addSystemParameter(SystemParameterDto systemParameter);

    SystemParameter editSystemParameter(int id, SystemParameterDto systemParameter);

    void deleteSystemParameter(int id);
}
