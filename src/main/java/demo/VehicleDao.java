package demo;

import java.util.*;

/**
 * Created by raz on 2/24/17.
 */
public class VehicleDao {
    private static VehicleDao instance;
    private Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    public static VehicleDao getInstance() {
        if(instance == null) {
            instance = new VehicleDao();
        }
        return instance;
    }

    private VehicleDao(){};

    public String save(Vehicle vehicle) {
        String uuidString = UUID.randomUUID().toString();
        vehicle.setId(uuidString);
        vehicles.add(vehicle);
        return uuidString;
    }

    public Optional<Vehicle> findById(String id) {
        return vehicles.stream()
                .filter(vehicle -> id.equals(vehicle.getId()))
                .findAny();
    }
}

