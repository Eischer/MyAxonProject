package at.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateAggregateCommand {

    @TargetAggregateIdentifier
    private final int id;
    private final String command;

    public CreateAggregateCommand(int id, String command) {
        this.id = id;
        this.command = command;
    }

    public int getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
