package org.jessicakrueger.capstone.controller;


import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.GenresDAO;
import org.jessicakrueger.capstone.database.entity.Genres;
import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenresDAO genresDAO;

    @GetMapping("/info/{genreId}")
    public ModelAndView genresPathVar(@PathVariable Integer genreId) {

        ModelAndView response = new ModelAndView("genres/genreInfo");

        Genres genres = genresDAO.findById(genreId);
        response.addObject("genres", genres);

        return response;

    }


}
