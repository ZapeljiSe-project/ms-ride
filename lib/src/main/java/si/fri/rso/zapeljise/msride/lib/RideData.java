package si.fri.rso.zapeljise.msride.lib;

import java.util.Date;

public class RideData {
    private Boolean active;

    private Integer id;

    private String fromTown;

    private String toTown;

    private Date date;

    private Integer timeMinutes;

    private Integer timeHours;

    private Integer price;

    private String driver;

    private String notes;

    private Integer space;

    private String car;

    private Boolean insurance;

    private String phone;

    private Boolean pick;

    // Getters and setters.

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromTown() {
        return fromTown;
    }

    public void setFromTown(String fromTown) {
        this.fromTown = fromTown;
    }

    public String getToTown() {
        return toTown;
    }

    public void setTo(String toTown) {
        this.toTown = toTown;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(Integer timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public Integer getTimeHours() {
        return timeHours;
    }

    public void setTimeHours(Integer timeHours) {
        this.timeHours = timeHours;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getPick() {
        return pick;
    }

    public void setPick(Boolean pick) {
        this.pick = pick;
    }
}