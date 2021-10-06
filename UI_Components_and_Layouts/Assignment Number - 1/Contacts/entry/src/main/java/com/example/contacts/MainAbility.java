package com.example.contacts;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import com.example.contacts.slice.MainAbilitySlice;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
