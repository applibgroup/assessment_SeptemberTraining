package com.example.intents;

import com.example.intents.slice.IdCardSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class IdCard extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(IdCardSlice.class.getName());
    }
}
