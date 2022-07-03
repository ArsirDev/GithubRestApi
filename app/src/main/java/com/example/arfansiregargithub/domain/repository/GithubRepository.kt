package com.example.arfansiregargithub.domain.repository

import com.example.arfansiregargithub.data.remote.dto.FollowResponse
import com.example.arfansiregargithub.data.remote.dto.SearchResponse
import com.example.arfansiregargithub.data.remote.dto.UserDetailResponse
import com.example.arfansiregargithub.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface GithubRepository {

    fun searchUser(username: String): Flow<Result<SearchResponse>>

    fun userDetail(username: String): Flow<Result<UserDetailResponse>>

    fun userFollower(username: String): Flow<Result<List<FollowResponse>>>

    fun userFollowing(username: String): Flow<Result<List<FollowResponse>>>

}