package com.example.auctions_web.oauth;

public interface UserDetailDao {
    UserDetail selectUSerDetailByEmail(String email);
}
