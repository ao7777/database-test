package entity;

import java.util.Date;

public class Movie {
    private String name;// 电影名
    private Date releaseTime;// 上映时间
    private Float ratings;// 评分
    private MovieDetail movieDetail;// 电影详情

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
        updateRatings();
    }

    private void updateRatings() {
        for (Review review : this.movieDetail.getReviews())
            this.ratings += review.getRating();
        this.ratings/=this.movieDetail.getReviews().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Float getRatings() {
        return ratings;
    }

    public void setRatings(Float ratings) {
        this.ratings = ratings;
    }
}
