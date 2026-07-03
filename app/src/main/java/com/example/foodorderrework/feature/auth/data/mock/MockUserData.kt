package com.example.foodorderrework.feature.auth.data.mock

import com.example.foodorderrework.feature.auth.domain.model.Role
import com.example.foodorderrework.feature.auth.domain.model.User

object MockUsers {
    val users: List<User> = listOf(
        User(
            id = "user_1",
            name = "Nguyễn Văn An",
            email = "an@example.com",
            phone = "0901111111",
            avatarUrl = "https://example.com/avatar-an.png",
            role = Role.CUSTOMER,
            password = "123456",
        ),
        User(
            id = "user_2",
            name = "Trần Thị Bình",
            email = "binh@example.com",
            phone = "0902222222",
            avatarUrl = "https://example.com/avatar-binh.png",
            role = Role.CUSTOMER,
            password = "123456",
        ),
        User(
            id = "user_3",
            name = "Lê Hoàng Cường",
            email = "cuong@example.com",
            phone = "0903333333",
            avatarUrl = "https://example.com/avatar-cuong.png",
            role = Role.CUSTOMER,
            password = "123456",
        ),
        User(
            id = "user_4",
            name = "Phạm Thị Dung",
            email = "dung.store@example.com",
            phone = "0904444444",
            avatarUrl = "https://example.com/avatar-dung.png",
            role = Role.STORE_OWNER,
            password = "123456",
        ),
        User(
            id = "user_5",
            name = "Admin Hệ Thống",
            email = "admin@example.com",
            phone = "0905555555",
            avatarUrl = "https://example.com/avatar-admin.png",
            role = Role.ADMIN,
            password = "123456",
        ),
    )
}