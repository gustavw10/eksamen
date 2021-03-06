/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.FetchFacade;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("covid")
public class CovidResource {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FetchFacade FACADE = new FetchFacade();

    @Context
    private UriInfo context;

@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{city}")
    public String getWeather(@PathParam("city") String city ) throws IOException {
        String url = "https://covid-api.mmediagroup.fr/v1/cases?country=" + city;
        String covidData = HttpUtils.fetchData(url);
        
        return GSON.toJson(covidData);
    }
}