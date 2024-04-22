package at.axon.eventhandlers;

import at.axon.events.AggregateCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandlers {

    private static Logger logger = LoggerFactory.getLogger(EventHandlers.class);

    @EventHandler
    public void handleCreateAggregate(AggregateCreatedEvent createAggregateEvent) {
        logger.info("Enter EventHandler");
    }
}
