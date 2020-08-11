package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.service.impl;

import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.dto.SystemParameterDto;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.entity.SystemParameter;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.repository.SystemParameterRepository;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.service.SystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SystemParameterServiceImpl implements SystemParameterService
{
    @Autowired
    private SystemParameterRepository systemParameterRepository;

    @Override
    public List<SystemParameterDto> getAll() {
        return systemParameterRepository.getAll();
    }

    @Override
    public List<SystemParameterDto> getAll(String sortBy, int rowPerPage, int page)
    {
        int rowStart = (page - 1) * rowPerPage;

        if (sortBy.toLowerCase().equals("desc"))
        {
            return systemParameterRepository.getAllPagingDesc(rowStart, rowPerPage);
        }
        else
        {
            return systemParameterRepository.getAllPagingAsc(rowStart, rowPerPage);
        }
    }

    @Override
    public List<SystemParameterDto> getAll(String sortBy, String theParam, String theStatus, double startVal,
                                           double endVal, String startDate, String endDate, int rowPerPage, int page)
    {
        int rowStart = (page-1) * rowPerPage;

        if (sortBy.toLowerCase().equals("desc"))
        {
            return systemParameterRepository.getAllAdvancedSearchDesc(theParam, theStatus, startVal, endVal, startDate,
                    endDate, rowStart, rowPerPage);
        }
        else
        {
            return systemParameterRepository.getAllAdvancedSearchAsc(theParam, theStatus, startVal, endVal, startDate,
                    endDate, rowStart, rowPerPage);
        }
    }

    @Override
    public Optional<SystemParameterDto> getById(int id)
    {
        return systemParameterRepository.getById(id);
    }

    @Override
    public SystemParameter addSystemParameter(SystemParameterDto systemParameter) {
        SystemParameter newSystemParameter = new SystemParameter();

        newSystemParameter.setParam(systemParameter.getParam());
        newSystemParameter.setStatus(systemParameter.getStatus());
        newSystemParameter.setValue(systemParameter.getValue());
        newSystemParameter.setNote(systemParameter.getNote());
        newSystemParameter.setLastUpdate(systemParameter.getLast_update());

        return systemParameterRepository.save(newSystemParameter);
    }

    @Override
    public SystemParameter editSystemParameter(int id, SystemParameterDto systemParameter) {
        SystemParameter newSystemParameter = systemParameterRepository.findById(id).get();

        newSystemParameter.setParam(systemParameter.getParam());
        newSystemParameter.setStatus(systemParameter.getStatus());
        newSystemParameter.setValue(systemParameter.getValue());
        newSystemParameter.setNote(systemParameter.getNote());
        newSystemParameter.setLastUpdate(systemParameter.getLast_update());

        return systemParameterRepository.save(newSystemParameter);
    }

    @Override
    public void deleteSystemParameter(int id) {
        systemParameterRepository.deleteById(id);
    }
}
