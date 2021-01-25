package com.example151.moviecatalogservice.resources;

import com.example151.moviecatalogservice.models.CatalogItem;
import com.example151.moviecatalogservice.models.Movie;
import com.example151.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId){

        

        List<Rating> ratings = Arrays.asList(
                new Rating ("1234", 4 ),
                new Rating ("5678", 3)
        );

        return ratings.stream().map(rating ->{
                Movie movie = restTemplate.getForObject("http:host:8081/movie/" + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), "description",rating.getRating());})
                .collect(Collectors.toList());

   }
}
