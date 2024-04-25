package at.eischer;

import at.axon.aggregates.MyAggregate;
import at.axon.command.CreateAggregateCommand;
import at.axon.command.EditAggregateCommand;
import at.axon.events.AggregateCreatedEvent;
import org.axonframework.eventhandling.GenericDomainEventMessage;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.axonframework.test.matchers.Matchers;
import org.junit.jupiter.api.Test;

class AggregateTestFixtureTests {

    private final FixtureConfiguration<MyAggregate> aggregateTestFixture = new AggregateTestFixture<>(MyAggregate.class);
    
    @Test
    void testCreateAggregate() {
        aggregateTestFixture
                .given()
                .when(new CreateAggregateCommand("myId", "myName"))
                .expectEvents(new AggregateCreatedEvent("myId", "myName"));
    }

    @Test
    void testCreateExistingAggregate() {
        aggregateTestFixture
                .given(new AggregateCreatedEvent("myId", "myName"))
                .when(new CreateAggregateCommand("myId", "myName"))
                .expectException(RuntimeException.class)
                .expectExceptionMessage("Aggregate already exists");
    }
    
    @Test
    void testEditAggregateWithMatcher() {
        aggregateTestFixture
                .given(new AggregateCreatedEvent("myId", "myName"))
                .when(new EditAggregateCommand("myId", "myNewName"))
                .expectEventsMatching(Matchers.sequenceOf(Matchers.predicate(event -> event instanceof GenericDomainEventMessage<?>)));
    }
}
