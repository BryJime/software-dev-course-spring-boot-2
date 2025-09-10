package com.example.mycollections.controllers;


import com.example.mycollections.models.Album;
import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("Step Brothers", "Adam McKay", 2008, 98));
        add(new Movie("Interstellar", "Christopher Nolan", 2014, 169));
        add(new Movie("The Conjuring", "Micheal Chaves", 2025, 135));
    }};

    @GetMapping("/JSON")
    public List<Movie> getAlbumJson(){
        return movies;
    }

    @GetMapping("/html")
    public String getAlbumHtml() {
        String moviesList = "<ul>";
        for (Movie movies : movies) {
            moviesList += "<li>" + movies + "</li>";
        }
        moviesList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                """ +
                moviesList +
                """
                        </ul>
                    </body>
                """;
    }
}
