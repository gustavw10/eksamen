package facades;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import utils.HttpUtils;

/**
 *
 * @author David
 */
public class FetchFacade {

    class FetchDefault implements Callable<String> {

        String url;

        FetchDefault(String url) {
            this.url = url;
        }

        @Override
        public String call() throws Exception {
            return HttpUtils.fetchData(url);
        }
    }

    public List<String> fetchParallel() throws InterruptedException, ExecutionException {
        String capitalName = "copenhagen";
        String apiKey = "4cb8ceb8adc96ee3e4f0518d11cfa985";
        String[] hostList = {"http://api.openweathermap.org/data/2.5/weather?q=" + capitalName + "&appid=" + apiKey,
            "https://restcountries.eu/rest/v2/capital/" + capitalName,
            "https://covid-api.mmediagroup.fr/v1/cases?country=Denmark"};
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList();
        List<String> result = new ArrayList();

        for (String url : hostList) {
            Callable<String> newUrl = new FetchDefault(url);
            Future future = executor.submit(newUrl);
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            result.add(future.get());
        }
        return result;
    }
}
