package at.eischer;

import at.axon.command.CreateAggregateCommand;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.axonframework.config.Configuration;

@ApplicationScoped
public class ExampleService {

    @Inject
    Configuration configuration;

    public void createNewAggregate(String id) {
        configuration.commandGateway().sendAndWait(new CreateAggregateCommand(id));
    }
}