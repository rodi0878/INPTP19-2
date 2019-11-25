package cz.upce.fei.inptp.zz.entity;

import cz.upce.fei.inptp.project.entity.Order;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCapacity() {
        Order order = new Order("1", "5", -3);
        
        assertNotNull(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCapacity() {
        Order order = new Order("0", "3", 0);
        
        assertNotNull(order);
    }

    @Test
    public void testPositiveCapacity() {
        Order order = new Order("2", "3", 5);
        
        assertEquals("2", order.getFrom());
        assertEquals("3", order.getTo());
        assertEquals(5, order.getCapacity());
    }   
}
