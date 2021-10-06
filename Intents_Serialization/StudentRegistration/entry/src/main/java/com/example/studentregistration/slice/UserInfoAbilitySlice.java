package com.example.studentregistration.slice;

import com.example.studentregistration.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class UserInfoAbilitySlice extends AbilitySlice {

    Text userId;
    Text userName;
    Text userDepartment;
    Text userUniversity;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_user_info);
        initViews(intent);
    }

    private void initViews(Intent intent) {
        userId = (Text) findComponentById(ResourceTable.Id_userid);
        userName = (Text) findComponentById(ResourceTable.Id_username);
        userDepartment = (Text) findComponentById(ResourceTable.Id_userdepartment);
        userUniversity = (Text) findComponentById(ResourceTable.Id_useruniversity);

        userId.setText(intent.getStringParam("user_id"));
        userName.setText(intent.getStringParam("user_name"));
        userDepartment.setText(intent.getStringParam("user_department"));
        userUniversity.setText(intent.getStringParam("user_university"));
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
