package com.example.assignment_database.slice;


import com.example.assignment_database.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public class NextAbilitySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent){
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_firstlayout);
    }
}
