/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Weather;
import facades.FetchFacade;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
@Path("weather")
public class WeatherResource {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FetchFacade FACADE = new FetchFacade();
    
    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEndpoints() throws IOException, InterruptedException, ExecutionException {
        List<String> list = FACADE.fetchParallel();
        return GSON.toJson(list);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{city}")
    public String getWeather(@PathParam("city") String city ) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=4cb8ceb8adc96ee3e4f0518d11cfa985";
        String weatherData = HttpUtils.fetchData(url);
        
        //ChuckDTO joke = GSON.fromJson(chuck, ChuckDTO.class);
        return GSON.toJson(weatherData);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("weatherDTO/{city}")
    public String getWeatherDTO(@PathParam("city") String city ) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=4cb8ceb8adc96ee3e4f0518d11cfa985";
        String weatherData = HttpUtils.fetchData(url);
        
        Weather weather = GSON.fromJson(weatherData, Weather.class);
        
        return GSON.toJson(weather);
    }
    
    public static void main(String[] args) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + "London" + "&appid=4cb8ceb8adc96ee3e4f0518d11cfa985";
        String weatherData = HttpUtils.fetchData(url);
        
        System.out.println(weatherData);
        System.out.println("------------");
//        Weather weather = GSON.fromJson(weatherData, Weather.class);
//        System.out.println(weather.getCoord());
        
        String test = "{'coord' : ["
            + "{'name': 'Alex','id': 1}, "
            + "{'name': 'Brian','id':2}, "
            + "{'name': 'Charles','id': 3}],"
            + "'weather' : ["
            + "{'name': 'test','id': 1}, "
            + "{'name': 'test2','id':2}, "
            + "{'name': 'test3','id': 3}]"    
            + "}";
        
        Weather wet = GSON.fromJson(test, Weather.class);
        System.out.println(wet);
    }
}
