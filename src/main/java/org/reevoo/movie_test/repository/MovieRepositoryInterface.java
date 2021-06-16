package org.reevoo.movie_test.repository;
import java.util.List;

import org.reevoo.movie_test.entity.Movie;


public interface MovieRepositoryInterface {
    /**
     * 上传电影
     * @param movie 电影实体
     * @return 上传是否成功，如果上传电影的格式合法则成功。
     */
    public Boolean uploadMovie(Movie movie);
    /**
     * 根据电影名查找电影
     * @param name 电影名称
     * @return 所有名字与参数精确匹配的电影
     */
    public List<Movie> getMovieByName(String name);
    /**
     * 删除电影
     * @param movie 根据电影实体来删除电影
     * @return 删除是否成功，有可能该电影已不存在
     */
    public Boolean removeMovie(Movie movie);
    /**
     * 更新电影的信息
     * @param movie 新的电影实体
     * @return 如果该电影不存在，则失败返回假
     */
    public Boolean updateMovie(Movie movie);
}