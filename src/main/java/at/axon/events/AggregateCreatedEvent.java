package at.axon.events;

public class AggregateCreatedEvent {

    private final String id;
    
    private final String name;

    public AggregateCreatedEvent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return this.name;
    }
}
