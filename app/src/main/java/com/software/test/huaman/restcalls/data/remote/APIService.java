package com.software.test.huaman.restcalls.data.remote;

import com.software.test.huaman.restcalls.data.model.BodyObj;
import com.software.test.huaman.restcalls.data.model.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kiwic on 2/22/2018.
 */

public interface APIService {
    @Headers({
            "Content-Type: application/json",
            "x-pay-token=xv2: ",
            "x-request-id: "
    })
    @POST("/vts/panEnrollments")
    Call<Post> savePost(@Query("apikey") String api,
                        @Body BodyObj body);
/*

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);
*/
    // RxJava
   /* @POST("/posts")
    @FormUrlEncoded
    Observable<Post> savePost(@Field("title") String title,
                              @Field("body") String body,
                              @Field("userId") long userId);*/

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") long id);

}
