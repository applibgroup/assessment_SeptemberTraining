package com.example.first_project.slice;

import com.example.first_project.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button bt =(Button) findComponentById(ResourceTable.Id_next_button);

        bt.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
               present(new NextAbilitySlice(), new Intent());
            }
        });
        Button bt1 =(Button) findComponentById(ResourceTable.Id_last_button);
        bt1.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                present(new LastAbilitySlice(), new Intent());
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
