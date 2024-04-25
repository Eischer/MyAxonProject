package at.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class AggregateEditedEvent {

    private final String id;
    
    private final String name;
}
