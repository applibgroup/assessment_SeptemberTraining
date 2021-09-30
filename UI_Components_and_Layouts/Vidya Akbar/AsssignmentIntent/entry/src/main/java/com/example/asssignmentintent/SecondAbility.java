package com.example.asssignmentintent;


import ohos.aafwk.ability.Ability;

import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class SecondAbility extends Ability {
    Text userInfoName;
    Text userInfoRoll;
    Text userInfoDept;

    Text userInfoUni;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_studentcard);
        initViews(intent);

    }

    private void initViews(Intent intent) {

        userInfoName = (Text) findComponentById(ResourceTable.Id_user_info_name);
        userInfoRoll = (Text) findComponentById(ResourceTable.Id_user_info_roll);
        userInfoDept = (Text) findComponentById(ResourceTable.Id_user_info_Department);
        userInfoUni = (Text) findComponentById(ResourceTable.Id_user_info_university);

        if (intent != null) {
            userInfoName.setText(intent.getStringParam("user_info_name"));
            userInfoRoll.setText(intent.getStringParam("user_info_roll"));
            userInfoDept.setText(intent.getStringParam("user_info_Department"));
            userInfoUni.setText(intent.getStringParam("user_info_university"));
        }
    }
}

