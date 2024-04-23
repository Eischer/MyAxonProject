package at.axon.aggregates;

import at.axon.command.CreateAggregateCommand;
import at.axon.command.EditAggregateCommand;
import at.axon.events.AggregateCreatedEvent;
import at.axon.events.AggregateEditedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateRoot;
import org.axonframework.modelling.command.CreationPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@AggregateRoot
public class MyAggregate {

    @AggregateIdentifier
    String aggregateId;

    private String name;

    private static Logger logger = LoggerFactory.getLogger(MyAggregate.class);

    public MyAggregate() {
        // Constructor for Axon
    }
    
    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
    public void handle(CreateAggregateCommand createAggregateCommand) {
        logger.info("Enter CommandHandler. AggregateId is: " + aggregateId);
        if (name != null) {
            throw new RuntimeException("Aggregate already exists");
        }
        apply(new AggregateCreatedEvent(createAggregateCommand.getId(), createAggregateCommand.getName()));
    }
    
    @CommandHandler
    public void edit(EditAggregateCommand editAggregateCommand) {
        apply(new AggregateEditedEvent(editAggregateCommand.getId(), editAggregateCommand.getNameToSet()));
    }

    @EventSourcingHandler
    public void on (AggregateCreatedEvent event) {
        logger.info("Enter EventsourcingHandler. The event-id: " + event.getId());
        this.aggregateId = event.getId();
        this.name = event.getName();
    }
    
    @EventSourcingHandler
    public void onEdit(AggregateEditedEvent aggregateEditedEvent) {
        this.aggregateId = aggregateEditedEvent.getId();
        this.name = aggregateEditedEvent.getName();
    }
}
