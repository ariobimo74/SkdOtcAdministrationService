package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.api;

import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.entity.SystemParameter;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.service.SystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parameters")
public class SystemParameterApi
{
    @Autowired
    private SystemParameterService systemParameterService;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(systemParameterService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id)
    {
        return new ResponseEntity<>(systemParameterService.getById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/paging")
    public ResponseEntity<?> getAll(@RequestParam(value = "sortBy", defaultValue = "asc") String sortBy,
                                    @RequestParam(value = "rowPerPage", defaultValue = "2") int rowPerPage,
                                    @RequestParam(value = "page", defaultValue = "1") int page)
    {
        return new ResponseEntity<>(systemParameterService.getAll(sortBy, rowPerPage, page), HttpStatus.OK);
    }

    @GetMapping(path = "/searching")
    public ResponseEntity<?> getAll(@RequestParam(value = "sortBy", defaultValue = "asc") String sortBy,
                                    @RequestParam(value = "param", defaultValue = "") String theParam,
                                    @RequestParam(value = "status", defaultValue = "") String theStatus,
                                    @RequestParam(value = "startVal", defaultValue = "0") double startVal,
                                    @RequestParam(value = "endVal", defaultValue = "10") double endVal,
                                    @RequestParam(value = "startDate") String startDate,
                                    @RequestParam(value = "endDate") String endDate,
                                    @RequestParam(value = "rowPerPage", defaultValue = "2") int rowPerPage,
                                    @RequestParam(value = "page", defaultValue = "1") int page)
    {
        return new ResponseEntity<>(systemParameterService.getAll(sortBy, theParam, theStatus, startVal, endVal, startDate, endDate, rowPerPage, page),
                HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SystemParameter addSystemParameter(@RequestBody SystemParameter systemParameter)
    {
        return systemParameterService.addSystemParameter(systemParameter);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SystemParameter editSystemParameter(@PathVariable(value = "id") int id,
                                               @RequestBody SystemParameter systemParameter)
    {
        return systemParameterService.editSystemParameter(id, systemParameter);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSystemParameter(@PathVariable(value = "id") int id)
    {
        systemParameterService.deleteSystemParameter(id);
    }
}
