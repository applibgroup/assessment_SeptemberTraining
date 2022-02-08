package com.example.assignment_1;

import com.example.assignment_1.slice.Layout2Slice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class Layout2 extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(Layout2Slice.class.getName());
    }
}
