package com.example.intent_assignment;


import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class SecondAbility extends Ability {

    Text userInfoName;
    Text userInfoRoll;
    Text userInfoUniversity;
    Text userInfoDepartment;


//    intent.setParam("user_info_name", user.getStudentName());
//            intent.setParam("user_info_roll", user.getRollNo());
//            intent.setParam("user_info_Department", user.getDepartmentName());
//            intent.setParam("user_info_college", user.getCollegeName());
//            intent.setParam("user_info_university", user.getUniversityName());

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent (ResourceTable.Layout_ability_next);
        initViews (intent);

    }

    private void initViews (Intent intent) {
        userInfoName = (Text) findComponentById(ResourceTable.Id_user_info_name);
        userInfoRoll = (Text) findComponentById(ResourceTable.Id_user_info_roll);
        userInfoUniversity = (Text) findComponentById(ResourceTable.Id_user_info_university);
        userInfoDepartment = (Text) findComponentById(ResourceTable.Id_user_info_Department);

        if (intent != null) {
            userInfoName.setText(intent.getStringParam("user_info_name"));
            userInfoRoll.setText(intent.getStringParam("user_info_roll"));
            userInfoUniversity.setText(intent.getStringParam("user_info_university"));
            userInfoDepartment.setText(intent.getStringParam("user_info_Department"));
        }

    }
}
