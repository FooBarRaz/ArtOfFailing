package demo;

/**
 * Created by raz on 2/24/17.
 */
public class Vehicle {
    private Long lastServiceMileage;
    private String model;
    private String make;
    private Long currentMileage;
    private String id;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCurrentMileage(Long currentMileage) {
        this.currentMileage = currentMileage;
    }

    public void setLastServiceMileage(Long lastServiceMileage) {
        this.lastServiceMileage = lastServiceMileage;
    }

    public Long getLastServiceMileage() {
        return lastServiceMileage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
