package com.example.intents.slice;

import com.example.intents.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;

public class IdCardSlice extends AbilitySlice {
    Text n1,d1,r1,u1;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_id_card);
        initViews(intent);

        }

    private void initViews(Intent intent) {
        n1=(Text) findComponentById(ResourceTable.Id_name);
        d1=(Text) findComponentById(ResourceTable.Id_department);
        r1=(Text) findComponentById(ResourceTable.Id_rollno);
        u1=(Text) findComponentById(ResourceTable.Id_university);
        n1.setText(intent.getStringParam("A"));
        d1.setText(intent.getStringParam("B"));
        r1.setText(intent.getStringParam("C"));
        u1.setText(intent.getStringParam("D"));
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
