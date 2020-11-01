package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;

import java.util.ArrayList;
import java.util.List;

public class PublicationsObserver {
    List<PublicationsListener> listeners = new ArrayList<>();

    public void notifyOnSave(int year, PublicationType type) {
        for (PublicationsListener listener : listeners) {
            if (listener.getYear() == year && listener.getType() == type) {
                listener.addToCount();
            }
        }
    }

    public void notifyOnDelete(int year, PublicationType type) {
        for (PublicationsListener listener : listeners) {
            if (listener.getYear() == year && listener.getType() == type) {
                listener.minusToCount();
            }
        }
    }

    public void subscribe(PublicationsListener listener){
        listeners.add(listener);
    }

}
