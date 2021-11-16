package code.model;

import code.model.elements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourceTest {
    @Test
    public void createResourceTest() {
        Resource r = new Resource("resource");
        Assertions.assertEquals(r.getName(), "resource");
        Assertions.assertEquals(r.getQuantity(), 1);

        r = new Resource("new resource", 5);
        Assertions.assertEquals(r.getName(), "new resource");
        Assertions.assertEquals(r.getQuantity(), 5);
    }

    @Test
    public void resourceNameTest() {
        Resource r = new Resource("resource");
        Assertions.assertEquals(r.getName(), "resource");

        r.setName("new resource");
        Assertions.assertEquals(r.getName(), "new resource");
    }

    @Test
    public void resourceQuantityTest() {
        Resource r = new Resource("resource");
        Assertions.assertEquals(r.getQuantity(), 1);

        r.setQuantity(5);
        Assertions.assertEquals(r.getQuantity(), 5);

        r.changeQuantity(1);
        Assertions.assertEquals(r.getQuantity(), 6);
    }

    @Test
    public void equalsTest() {
        Resource r1 = new Resource("coelho");
        Resource r2 = new Resource("robalo");

        Assertions.assertNotEquals(r1, r2);

        r1 = new Resource ("gato", 1);
        r2 = new Resource ("gato", 5);

        Assertions.assertEquals(r1, r2);

    }
}
