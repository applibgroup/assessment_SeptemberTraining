package com.example.assignment_database.slice;

import com.example.assignment_database.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
            Button bt = (Button) findComponentById(ResourceTable.Id_SignUp);
            bt.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    present(new NextAbilitySlice(),new Intent());
                }
            });
        Button bc = (Button) findComponentById(ResourceTable.Id_Reset);
        bc.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                present(new Next2AbilitySlice(),new Intent());
            }
        });
    }

    @Override
    public void onActive() {super.onActive();}

    @Override
    public void onForeground(Intent intent){super.onForeground(intent);}

}

