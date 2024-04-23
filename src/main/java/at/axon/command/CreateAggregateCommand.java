package at.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@ToString
public class CreateAggregateCommand {

    @TargetAggregateIdentifier
    @Getter
    private final String id;

    @Getter
    private final String name;

}
