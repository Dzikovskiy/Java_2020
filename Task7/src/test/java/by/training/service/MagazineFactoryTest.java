package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MagazineFactoryTest {
    MagazineFactory magazineFactory;

    @Test
    public void testGetInstance() {
        magazineFactory = MagazineFactory.getInstance();
        Assert.assertNotNull(magazineFactory);
        Assert.assertEquals(magazineFactory.getClass(), MagazineFactory.class);
    }

    @Test
    public void testCreatePublication() {
        magazineFactory = MagazineFactory.getInstance();
        Publication publication = magazineFactory.createPublication();
        Assert.assertNotNull(publication);
        Assert.assertEquals(publication.getType(), PublicationType.MAGAZINE);
    }
}