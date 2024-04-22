package at.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class EditAggregateCommand {
    
    @TargetAggregateIdentifier
    private String id;
    
    private String nameToSet;

    public EditAggregateCommand(String id, String nameToSet) {
        this.id = id;
        this.nameToSet = nameToSet;
    }

    public String getId() {
        return id;
    }

    public String getNameToSet() {
        return nameToSet;
    }
}
