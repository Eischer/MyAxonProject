package at.axon.configuration;

import at.axon.aggregates.MyAggregate;
import at.axon.eventhandlers.EventHandlers;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
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
                .registerEventHandler(config -> new EventHandlers())
                .configureAggregate(MyAggregate.class)
                .configureSerializer(config -> commmandSerializerForAxonServer());
        return configurer.start();
    }

    private XStreamSerializer commmandSerializerForAxonServer() {
        XStream xStream = new XStream(new CompactDriver());
        xStream.allowTypesByWildcard(new String[]{ "at.axon.command.*" });
        xStream.addPermission(AnyTypePermission.ANY);
        return XStreamSerializer.builder().xStream(xStream).build();
    }
}
