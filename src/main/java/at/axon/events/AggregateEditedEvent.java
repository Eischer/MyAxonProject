package at.axon.events;

public class AggregateEditedEvent {

    private String id;
    
    private String name;

    public AggregateEditedEvent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
