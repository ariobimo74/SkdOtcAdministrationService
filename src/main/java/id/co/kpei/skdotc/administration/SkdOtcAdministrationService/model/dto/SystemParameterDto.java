package id.co.kpei.skdotc.administration.SkdOtcAdministrationService.model.dto;

import java.util.Date;

public class SystemParameterDto
{
    private int id;
    private String param;
    private double value;
    private String note;
    private String status;
    private Date last_update;

    public SystemParameterDto() {
    }

    public SystemParameterDto(int id, String param, double value, String note, String status, Date last_update) {
        this.id = id;
        this.param = param;
        this.value = value;
        this.note = note;
        this.status = status;
        this.last_update = last_update;
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

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
