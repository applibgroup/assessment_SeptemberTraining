package com.example.studentregistration.slice;

import com.example.studentregistration.ResourceTable;
import com.example.studentregistration.data.User;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;

public class MainAbilitySlice extends AbilitySlice {

    private TextField name;
    private TextField id;
    private TextField department;
    private TextField university;
    private Button submit;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initViews();
        initListeners();
    }

    private void initViews() {
        name = (TextField) findComponentById(ResourceTable.Id_name);
        id = (TextField) findComponentById(ResourceTable.Id_id);
        department = (TextField) findComponentById(ResourceTable.Id_department);
        university = (TextField) findComponentById(ResourceTable.Id_university);
        submit = (Button) findComponentById(ResourceTable.Id_signup);
    }

    private void initListeners() {
        submit.setClickedListener(component -> handleClickSubmit(component));
    }

    public void handleClickSubmit(Component component) {
        User user = new User();
        user.setName(name.getText());
        user.setId(id.getText());
        user.setDepartment(department.getText());
        user.setUniversity(university.getText());

        Intent intent = new Intent();
        intent.setParam("user_name", user.getName());
        intent.setParam("user_id", user.getId());
        intent.setParam("user_department", user.getDepartment());
        intent.setParam("user_university", user.getUniversity());

        present(new UserInfoAbilitySlice(), intent);
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
