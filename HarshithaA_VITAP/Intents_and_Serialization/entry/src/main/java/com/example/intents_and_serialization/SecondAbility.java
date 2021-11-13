package com.example.intents_and_serialization;


import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;


import static com.example.intents_and_serialization.ResourceTable.*;

public class SecondAbility extends Ability {

    Text userInfoName;
    Text userInfoDepartment;
    Text userInfoUniversity;

    @Override
    public void onStart (Intent intent)
    {
        super.onStart(intent);
        super.setUIContent(Layout_ability_next);
        initViews(intent);
    }
    private void initViews (Intent intent)
    {
        userInfoName = (Text) findComponentById(Id_user_info_name);
        userInfoDepartment = (Text) findComponentById(ResourceTable.Id_user_info_department);
        userInfoUniversity = (Text) findComponentById(ResourceTable.Id_user_info_university);


        if (intent != null) {
            userInfoName.setText(intent.getStringParam("user_info_student_name"));
            userInfoUniversity.setText(intent.getStringParam("user_info_university_name"));
            userInfoDepartment.setText(intent.getStringParam("user_info_Department_name"));
        }

    }
}
