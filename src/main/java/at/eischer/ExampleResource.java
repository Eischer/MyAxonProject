package at.eischer;

import at.axon.aggregates.MyAggregate;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/axon")
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    private static Logger logger = LoggerFactory.getLogger(ExampleResource.class);

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public Response createAggregate(@PathParam("id") int id, @Context UriInfo uriInfo) {
        exampleService.createNewAggregate(id);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(Integer.toString(id)).build()).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public Response showStartPage() {
        logger.info("Startpage is displayed");
        return Response.ok().entity("Startpage").build();
    }
}
