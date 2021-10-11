package com.example.intentsa;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class NextAbility extends Ability {
    Text studentInfoName;
    Text studentInfoRollNo;
    Text studentInfoDept;
    Text studentInfoUniversity;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_student_card);
        initViews(intent);

    }

    private void initViews(Intent intent) {

        studentInfoName = (Text) findComponentById(ResourceTable.Id_student_info_name);
        studentInfoRollNo = (Text) findComponentById(ResourceTable.Id_student_info_rollno);
        studentInfoDept = (Text) findComponentById(ResourceTable.Id_student_info_dept);
        studentInfoUniversity = (Text) findComponentById(ResourceTable.Id_student_info_university);

        if (intent != null) {
            studentInfoName.setText(intent.getStringParam("student_info_name"));
            studentInfoRollNo.setText(intent.getStringParam("student_info_rollno"));
            studentInfoDept.setText(intent.getStringParam("student_info_dept"));
            studentInfoUniversity.setText(intent.getStringParam("student_info_university"));
        }
    }
}

