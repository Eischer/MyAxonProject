package at.axon.configuration;

import at.axon.aggregates.MyAggregate;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import io.axoniq.console.framework.AxoniqConsoleConfigurerModule;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.axonframework.config.Configuration;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.serialization.xml.CompactDriver;
import org.axonframework.serialization.xml.XStreamSerializer;

@ApplicationScoped
public class AxonConfigurer {

    @Produces
    public Configuration configure() {
        Configurer configurer = DefaultConfigurer.defaultConfiguration() //
                .configureAggregate(MyAggregate.class)
                .configureSerializer(config -> commmandSerializerForAxonServer());
        AxoniqConsoleConfigurerModule
                .builder(
                        "95d0cfd4-0",
                        "f3094e246fd84ae6a9e4cde5d12fe2f7",
                        "My Application Name"
                )
                .build()
                .configureModule(configurer);

        Configuration configuration = configurer.start();
        return configuration;
    }

    private XStreamSerializer commmandSerializerForAxonServer() {
        XStream xStream = new XStream(new CompactDriver());
        xStream.allowTypesByWildcard(new String[]{ "at.axon.command.*" });
        xStream.addPermission(AnyTypePermission.ANY);
        return XStreamSerializer.builder().xStream(xStream).build();
    }
}
