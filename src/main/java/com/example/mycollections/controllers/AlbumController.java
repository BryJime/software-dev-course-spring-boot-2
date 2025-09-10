package com.example.mycollections.controllers;


import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("MidNight", "Taylor Swift", 2005, 13));
        add(new Album("Constellations", "August Burns Red", 2008, 10));
        add(new Album("DAMN", "Kendrick Lamar", 2017, 10));
    }};

    @GetMapping("/JSON")
    public List<Album> getAlbumJson(){
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumHtml() {
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }
}
