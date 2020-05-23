package com.intern.nudleapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.intern.nudleapp.Constants.AUTH_URL;
import static com.intern.nudleapp.Constants.REGISTER_URL;

public interface NudleServices {

    @GET(AUTH_URL)
    Call<UserResponse> getUserDetails(@Query("email") String email);

    @FormUrlEncoded
    @POST(REGISTER_URL)
    Call<UserResponse> postUserDetails(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("mobile") String mobile,
                                       @Field("password") String password,
                                       @Field("session") int session
    );

}
