package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookFactoryTest {
    BookFactory bookFactory;

    @Test
    public void testGetInstance() {
        bookFactory = BookFactory.getInstance();
        Assert.assertNotNull(bookFactory);
        Assert.assertEquals(bookFactory.getClass(), BookFactory.class);
    }

    @Test
    public void testCreatePublication() {
        bookFactory = BookFactory.getInstance();
        Publication publication = bookFactory.createPublication();
        Assert.assertNotNull(publication);
        Assert.assertEquals(publication.getType(), PublicationType.BOOK);
    }
}