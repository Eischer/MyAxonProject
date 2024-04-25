package at.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@AllArgsConstructor
@ToString
public class CreateAggregateCommand {

    @TargetAggregateIdentifier
    private final String id;

    private final String name;

}
