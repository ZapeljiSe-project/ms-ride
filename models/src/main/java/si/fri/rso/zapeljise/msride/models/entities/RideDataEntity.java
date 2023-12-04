package si.fri.rso.zapeljise.msride.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ride")
@NamedQueries(value =
        {
                @NamedQuery(name = "RideDataEntity.getAll",
                        query = "SELECT im FROM RideDataEntity im")
        })
public class RideDataEntity {
    @Column(name = "Active")
    private Boolean active;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FromTown")
    private String fromTown;

    @Column(name = "ToTown")
    private String toTown;

    @Column(name = "Date")
    private Date date;

    @Column(name = "TimeMinutes")
    private Integer timeMinutes;

    @Column(name = "TimeHours")
    private Integer timeHours;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Driver")
    private String driver;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "Space")
    private Integer space;

    @Column(name = "Car")
    private String car;

    @Column(name = "Insurance")
    private Boolean insurance;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Pick")
    private Boolean pick;

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

    public void setToTown(String toTown) {
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