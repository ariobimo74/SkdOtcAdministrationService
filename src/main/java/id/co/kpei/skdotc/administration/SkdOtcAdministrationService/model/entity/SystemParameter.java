package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.dto.SystemParameterDto;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "systemParameterQuery", classes = {@ConstructorResult(targetClass = SystemParameterDto.class, columns = {
        @ColumnResult(name = "id", type = Integer.class),
        @ColumnResult(name = "param", type = String.class),
        @ColumnResult(name = "value", type = Double.class),
        @ColumnResult(name = "note", type = String.class),
        @ColumnResult(name = "status", type = String.class),
        @ColumnResult(name = "last_update", type = Date.class)
})})

@NamedNativeQuery(name = "SystemParameter.getAll",
query = "SELECT * FROM system_parameter", resultSetMapping = "systemParameterQuery")

@NamedNativeQuery(name = "SystemParameter.getById",
query = "SELECT * FROM system_parameter WHERE id = :parameterId", resultSetMapping = "systemParameterQuery")

@NamedNativeQuery(name = "SystemParameter.getAllPagingAsc",
query = "SELECT * FROM system_parameter\n" +
        "ORDER BY last_update\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "systemParameterQuery")

@NamedNativeQuery(name = "SystemParameter.getAllPagingDesc",
query = "SELECT * FROM system_parameter DESC\n" +
        "ORDER BY last_update\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "systemParameterQuery")

@NamedNativeQuery(name = "SystemParameter.getAllAdvancedSearchAsc",
query = "SELECT * FROM system_parameter\n" +
        "WHERE param LIKE LOWER(CONCAT('%',:theParam,'%'))\n" +
        "AND status LIKE LOWER(CONCAT('%',:theStatus,'%'))\n" +
        "AND value BETWEEN :startVal AND :endVal\n" +
        "AND (CAST(last_update AS VARCHAR) BETWEEN :startDate AND :endDate)\n" +
        "ORDER BY last_update\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "systemParameterQuery")

@NamedNativeQuery(name = "SystemParameter.getAllAdvancedSearchDesc",
query = "SELECT * FROM system_parameter\n" +
        "WHERE param LIKE LOWER(CONCAT('%',:theParam,'%'))\n" +
        "AND status LIKE LOWER(CONCAT('%',:theStatus,'%'))\n" +
        "AND value BETWEEN :startVal AND :endVal\n" +
        "AND (CAST(last_update AS VARCHAR) BETWEEN :startDate AND :endDate)\n" +
        "ORDER BY last_update DESC\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "systemParameterQuery")

@Entity
@Table(name = "system_parameter")
public class SystemParameter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "param", length = 100)
    private String param;

    @Column(name = "value")
    private double value;

    @Column(name = "note", length = 250)
    private String note;

    @Column(name = "status", length = 10)
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    public SystemParameter() {
    }

    public SystemParameter(int id, String param, double value, String note, String status, Date lastUpdate) {
        this.id = id;
        this.param = param;
        this.value = value;
        this.note = note;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
