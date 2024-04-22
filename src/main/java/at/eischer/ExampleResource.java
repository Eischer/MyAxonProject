package at.eischer;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

@Path("/axon")
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    private static Logger logger = LoggerFactory.getLogger(ExampleResource.class);

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("create/{id}")
    public Response createAggregate(@PathParam("id") String id, @Context UriInfo uriInfo) {
        logger.info(MessageFormat.format("Create Aggregate with AggregateIdentifier: {0}", id));
        exampleService.createNewAggregate(id);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(id).build()).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("edit/{id}")
    public Response editAggregate(@PathParam("id") String id, @Context UriInfo uriInfo) {
        logger.info(MessageFormat.format("Edit Aggregate with AggregateIdentifier: {0}", id));
        exampleService.editNewAggregate(id, "staticName");
        return Response.created(uriInfo.getAbsolutePathBuilder().path(id).build()).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public Response showStartPage() {
        logger.info("Startpage is displayed");
        return Response.ok().entity("Startpage").build();
    }
}
