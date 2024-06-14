package danich.factory.service;

import danich.view.actions.Event;

public interface Observer {
    void notify(Event event);
}