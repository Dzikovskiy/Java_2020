package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewspaperFactoryTest {
    NewspaperFactory newspaperFactory;

    @Test
    public void testGetInstance() {
        newspaperFactory = NewspaperFactory.getInstance();
        Assert.assertNotNull(newspaperFactory);
        Assert.assertEquals(newspaperFactory.getClass(), NewspaperFactory.class);
    }

    @Test
    public void testCreatePublication() {
        newspaperFactory = NewspaperFactory.getInstance();
        Publication publication = newspaperFactory.createPublication();
        Assert.assertNotNull(publication);
        Assert.assertEquals(publication.getType(), PublicationType.NEWSPAPER);
    }
}