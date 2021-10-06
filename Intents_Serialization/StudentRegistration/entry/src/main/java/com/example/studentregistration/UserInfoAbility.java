package com.example.studentregistration;

import com.example.studentregistration.slice.UserInfoAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class UserInfoAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(UserInfoAbilitySlice.class.getName());
    }
}
