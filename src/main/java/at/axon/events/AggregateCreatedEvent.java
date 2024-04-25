package at.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class AggregateCreatedEvent {

    private final String id;
    
    private final String name;
}
