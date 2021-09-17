package com.example.myfirstapplication.slice;


import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import com.example.myfirstapplication.ResourceTable;

/**
 * MainAbilitySlice.
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button bt = (Button) findComponentById(ResourceTable.Id_button_next);


        bt.setClickedListener(list -> present(new NextAbilitySlice(), new Intent()));
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
