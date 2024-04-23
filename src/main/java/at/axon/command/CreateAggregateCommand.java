package at.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateAggregateCommand {

    @TargetAggregateIdentifier
    private final String id;
    
    private final String name;

    public CreateAggregateCommand(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
