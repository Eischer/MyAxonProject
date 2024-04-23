package at.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class AggregateEditedEvent {

    @Getter
    private final String id;
    
    @Getter
    private final String name;
}
