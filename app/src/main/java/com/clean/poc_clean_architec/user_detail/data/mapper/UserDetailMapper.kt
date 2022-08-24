package com.clean.poc_clean_architec.user_detail.data.mapper

import com.clean.poc_clean_architec.user_detail.data.model.UserServerData
import com.clean.poc_clean_architec.user_detail.domain.model.UserUIData
import javax.inject.Inject

class UserDetailMapper @Inject constructor() {

    fun toUserUIData(userServerData: UserServerData?): UserUIData {
        return UserUIData(
            id = userServerData!!.id,
            userEmail = userServerData.userEmail,
            userFirstName = userServerData.userFirstName,
            userLastName = userServerData.userLastName,
            userAvatar = userServerData.userAvatar
        )
    }

}