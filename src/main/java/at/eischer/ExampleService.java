package at.eischer;

import at.axon.command.CreateAggregateCommand;
import at.axon.command.EditAggregateCommand;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.axonframework.config.Configuration;

@ApplicationScoped
public class ExampleService {

    @Inject
    Configuration configuration;

    public void createNewAggregate(String id, String name) {
        configuration.commandGateway().sendAndWait(new CreateAggregateCommand(id, name));
    }

    public void editNewAggregate(String id, String name) {
        configuration.commandGateway().sendAndWait(new EditAggregateCommand(id, name));
    }
}