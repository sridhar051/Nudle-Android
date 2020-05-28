package com.intern.nudleapp;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("code")
    private int code;

    @SerializedName("result")
    private Result result;

    @SerializedName("message")
    private Message message;

    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public Result getResult() {
        return result;
    }

    public Message getMessage() {
        return message;
    }

    public static class Message {

        @SerializedName("content")
        private String content;

        public String getContent() {
            return content;
        }

    }

}