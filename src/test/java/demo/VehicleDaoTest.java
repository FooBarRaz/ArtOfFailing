package demo;

import org.junit.Test;

import java.util.Optional;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresent;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class VehicleDaoTest {


    @Test
    public void getInstance_shouldReturnSingletonInstance() throws Exception {
        final VehicleDao firstInstance = VehicleDao.getInstance();
        final VehicleDao secondInstance = VehicleDao.getInstance();

        assertThat(firstInstance, is(secondInstance));
    }

    @Test
    public void save_generatesNewIdForEachSavedVehicle() throws Exception {
        final VehicleDao vehicleDao = VehicleDao.getInstance();

        final Vehicle firstVehicle = buildVehicle("DMC", "DeLorean");
        String firstSavedVehicleId = vehicleDao.save(firstVehicle);

        final Vehicle secondVehicle = buildVehicle("DMC", "DeLorean");
        String secondSavedVehicleId = vehicleDao.save(secondVehicle);


        assertThat(firstSavedVehicleId, not(secondSavedVehicleId));
    }

    private Vehicle buildVehicle(String make, String model) {
        final Vehicle secondVehicle = new Vehicle();
        secondVehicle.setMake(make);
        secondVehicle.setModel(model);
        return secondVehicle;
    }

    @Test
    public void save_savesCarInMemory() throws Exception {
        final VehicleDao vehicleDao = VehicleDao.getInstance();

        final Vehicle vehicle = new Vehicle();
        vehicleDao.save(vehicle);
    }

    @Test
    public void findById_whenVehicleWasPreviouslySaved_retrievesVehicle() throws Exception {
        final VehicleDao vehicleDao = VehicleDao.getInstance();
        String id = vehicleDao.save(buildVehicle("Aston Martin", "DBS"));

        Optional<Vehicle> savedCar = vehicleDao.findById(id);

        assertThat(savedCar, isPresent());
        assertThat(savedCar.get().getMake(), is("Aston Martin"));
        assertThat(savedCar.get().getModel(), is("DBS"));
    }

    @Test
    public void findById_whenVehicleWasNotPreviousSaved_returnsEmpty() throws Exception {
        final VehicleDao vehicleDao = VehicleDao.getInstance();

        Optional<Vehicle> savedCar = vehicleDao.findById("foo");

        assertThat(savedCar, isEmpty());
    }

}