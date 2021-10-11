package com.example.assignment1;

import com.example.assignment1.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.TextField;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        //TextField textField = (TextField)findComponentById(ResourceTable.Id_Name);
    }
}
