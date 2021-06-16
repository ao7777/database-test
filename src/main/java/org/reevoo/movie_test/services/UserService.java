package org.reevoo.movie_test.services;

import java.util.List;

import org.reevoo.movie_test.Result;
import org.reevoo.movie_test.entity.Movie;
import org.reevoo.movie_test.entity.Review;
import org.reevoo.movie_test.repository.MovieRepositoryInterface;
import org.reevoo.movie_test.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONObject;

public class UserService {
    @Autowired
    private MovieRepositoryInterface movieRepository;

    @Autowired
    private UserRepositoryInterface userRepositoryInterface;

    @PostMapping(path = "/review")
    public @ResponseBody Result<Object> reviewMovie(@RequestBody String json) {
        // 加载参数
        JSONObject params = new JSONObject(json);
        String name = params.getString("movieName");
        String id = params.getString("userId");
        String content = params.getString("content");
        Float rating = params.getFloat("rating");

        // 组装
        Review review = new Review();
        review.setContent(content);
        review.setRating(rating);
        review.setReviewer(userRepositoryInterface.getUserById(id));

        List<Movie> movies = movieRepository.getMovieByName(name);
        for (Movie movie : movies) {
            var detail = movie.getMovieDetail();
            var reviews = detail.getReviews();
            reviews.add(review);
            detail.setReviews(reviews);
            movie.setMovieDetail(detail);
            movieRepository.updateMovie(movie);
        }
        return new Result<>(1, "成功");
    }

}
