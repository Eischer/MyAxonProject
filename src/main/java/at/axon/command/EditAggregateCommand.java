package at.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@AllArgsConstructor
@ToString
public class EditAggregateCommand {
    
    @TargetAggregateIdentifier
    private String id;
    
    private String nameToSet;

}
