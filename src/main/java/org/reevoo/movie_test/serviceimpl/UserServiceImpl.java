package org.reevoo.movie_test.serviceimpl;

import org.reevoo.movie_test.entity.User;
import org.reevoo.movie_test.repository.UserRepository;
import org.reevoo.movie_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

//    @PostMapping(path = "/review")
//    public @ResponseBody
//    Result<Object> reviewMovie(@RequestBody String json) {
//        // 加载参数
//        JSONObject params = new JSONObject(json);
//        String name = params.getString("movieName");
//        String id = params.getString("userId");
//        String content = params.getString("content");
//        Float rating = params.getFloat("rating");
//
//        // 组装
//        Review review = new Review();
//        review.setContent(content);
//        review.setRating(rating);
//        review.setReviewer(userRepository.findById(id));
//
//        List<Movie> movies = movieRepository.getMovieByName(name);
//        for (Movie movie : movies) {
//            MovieDetail detail = movie.getMovieDetail();
//            List<Review> reviews = detail.getReviews();
//            reviews.add(review);
//            detail.setReviews(reviews);
//            movie.setMovieDetail(detail);
//            movieRepository.updateMovie(movie);
//        }
//        return new Result<>(1, "成功");
//    }
}
