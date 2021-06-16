package services;

import org.reevoo.movie_test.entity.Movie;
import org.reevoo.movie_test.entity.Review;
import org.reevoo.movie_test.repository.UserRepositoryInterface;

import repository.MovieRepositoryInterface;

public class UserService {
    @AutoWired
    private org.reevoo.movie_test.repository.MovieRepositoryInterface movieRepository;
    @AutoWired
    private UserRepositoryInterface userRepositoryInterface;
    @PostMapping(path = "/review")
	public @ResponseBody Result<Object> reviewMovie(@RequestBody String json) {
        //加载参数
        JSONObject params = new JSONObject(json);
        String name=params.getString("movieName");
        String id=params.getString("userId");
        String content=params.getString("content");
        Float rating=params.getFloat("rating");

        //组装
        Review review=new Review();
        review.setContent(content);
        review.setRating(rating);
        review.setReviewer(userRepositoryInterface.getUserById(id));

        Movie movie=movieRepository.getMovieByName(name);
        movie.getMovieDetail().getReviews().add(review);

        movieRepository.updateMovie(movie);
        return new Result<Object>(1,"成功");
	}

}
