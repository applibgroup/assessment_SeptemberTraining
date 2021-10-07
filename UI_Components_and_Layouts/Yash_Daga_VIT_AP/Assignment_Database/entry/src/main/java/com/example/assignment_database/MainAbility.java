package com.example.assignment_database;

import com.example.assignment_database.slice.MainAbilitySlice;
import com.example.assignment_database.slice.NextAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbility extends Ability {
    Button b;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
