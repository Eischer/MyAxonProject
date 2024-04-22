package at.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateAggregateCommand {

    @TargetAggregateIdentifier
    private final String id;

    public CreateAggregateCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
