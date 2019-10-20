package cz.upce.fei.inptp.zz.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class DriverTest {

    @Test(expected = NullPointerException.class)
    public void testInvalidIdentifier() {
        Driver driver = new Driver(null);
        
        assertNotNull(driver);
    }
}
