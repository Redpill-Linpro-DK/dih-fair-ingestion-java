package no.fair.dih.ingestion;

import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import no.fair.dih.model.Inventory;

@Path("/inventory")
public class InventoryResource {

  private static ConcurrentHashMap<String, Inventory> map = new ConcurrentHashMap<>();

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getInventory(@PathParam("id") String id) {
    var inv = map.get(id);
    if (inv == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(inv).build();
  }

  @POST
  public Response postInventory(Inventory inv) {
    map.put(inv.getSku(), inv);
    return Response.status(Status.CREATED).location(URI.create(String.format("inventory/%s", inv.getSku()))).build();
  }

}
