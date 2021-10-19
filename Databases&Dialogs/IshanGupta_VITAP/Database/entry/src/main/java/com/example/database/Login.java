package com.example.database;

import com.example.database.slice.LoginSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class Login extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(LoginSlice.class.getName());
    }
}
