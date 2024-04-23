package at.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class AggregateCreatedEvent {

    @Getter
    private final String id;
    
    @Getter
    private final String name;
}
