package at.axon.aggregates;

import at.axon.command.CreateAggregateCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAggregate {

    @AggregateIdentifier
    private int aggregateId;

    private String name;

    private static Logger logger = LoggerFactory.getLogger(MyAggregate.class);

    @CommandHandler
    public void handle(CreateAggregateCommand createAggregateCommand) {
        logger.info("Enter CommandHandler");
    }
}
