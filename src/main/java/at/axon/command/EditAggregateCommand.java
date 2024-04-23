package at.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@ToString
public class EditAggregateCommand {
    
    @TargetAggregateIdentifier
    @Getter
    private String id;
    
    @Getter
    private String nameToSet;

}
