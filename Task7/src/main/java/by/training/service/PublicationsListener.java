package by.training.service;

import by.training.entity.PublicationType;

public class PublicationsListener {
    private int count = 0;
    private int year;
    private PublicationType type;

    public PublicationsListener(int year, PublicationType type) {
        this.year = year;
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public void update() {
        System.out.println("Publication observer for " + type.name() + " for year: " + year + " count: " + count);
    }

    public void addToCount() {
        this.count++;
        update();
    }

    public void minusToCount() {
        this.count--;
        update();
    }
}
