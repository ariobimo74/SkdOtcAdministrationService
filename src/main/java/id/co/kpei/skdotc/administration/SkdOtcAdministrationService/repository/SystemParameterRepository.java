package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.repository;

import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.dto.SystemParameterDto;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.entity.SystemParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SystemParameterRepository extends JpaRepository<SystemParameter, Integer>
{
    @Query(nativeQuery = true)
    List<SystemParameterDto> getAll();

    @Query(nativeQuery = true)
    Optional<SystemParameterDto> getById(int parameterId);

    @Query(nativeQuery = true)
    List<SystemParameterDto> getAllPagingAsc(@Param(value = "offset") int offset,
                                             @Param(value = "fetch") int fetch);

    @Query(nativeQuery = true)
    List<SystemParameterDto> getAllPagingDesc(@Param(value = "offset") int offset,
                                              @Param(value = "fetch") int fetch);

    @Query(nativeQuery = true)
    List<SystemParameterDto> getAllAdvancedSearchAsc(@Param(value = "theParam") String theParam,
                                                     @Param(value = "theStatus") String theStatus,
                                                     @Param(value = "startVal") double startVal,
                                                     @Param(value = "endVal") double endVal,
                                                     @Param(value = "startDate") String startDate,
                                                     @Param(value = "endDate") String endDate,
                                                     @Param(value = "offset") int offset,
                                                     @Param(value = "fetch") int fetch);

    @Query(nativeQuery = true)
    List<SystemParameterDto> getAllAdvancedSearchDesc(@Param(value = "theParam") String theParam,
                                                      @Param(value = "theStatus") String theStatus,
                                                      @Param(value = "startVal") double startVal,
                                                      @Param(value = "endVal") double endVal,
                                                      @Param(value = "startDate") String startDate,
                                                      @Param(value = "endDate") String endDate,
                                                      @Param(value = "offset") int offset,
                                                      @Param(value = "fetch") int fetch);
}
