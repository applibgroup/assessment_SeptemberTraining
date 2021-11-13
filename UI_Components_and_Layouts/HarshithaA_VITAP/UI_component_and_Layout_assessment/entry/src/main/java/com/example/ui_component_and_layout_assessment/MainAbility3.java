package com.example.ui_component_and_layout_assessment;

import com.example.ui_component_and_layout_assessment.slice.MainAbility3Slice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility3 extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbility3Slice.class.getName());
    }
}
