
package com.example.intentsa.slice;

import com.example.intentsa.ResourceTable;
import com.example.intentsa.NextAbility;
import com.example.intentsa.Student;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;

public class MainAbilitySlice extends AbilitySlice {

    private TextField name;
    private TextField rollno;
    private TextField dept;
    private TextField collegename;
    private TextField universityname;
    private Button submit;


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_file);
        initViews();

        initListeners();
    }

    private void initViews() {

        name= (TextField) findComponentById(ResourceTable.Id_name);
        rollno = (TextField) findComponentById(ResourceTable. Id_rollno);
        dept= (TextField) findComponentById(ResourceTable. Id_dept);
        collegename = (TextField) findComponentById(ResourceTable. Id_collegename);
        universityname = (TextField) findComponentById(ResourceTable.Id_universityname);
        submit= (Button) findComponentById(ResourceTable. Id_button);


    }
    private void initListeners() {
        submit.setClickedListener(component ->handleSubmitClick(component));

    }

    public void handleSubmitClick(Component component) {

           Student student = new Student();

            student.setname(name.getText());

            student.setRollno(rollno.getText());

            student.setDept(dept.getText());

            student.setCollegename(collegename.getText());

            student.setUniversityname(universityname.getText());

            Intent intent = new Intent();

            intent.setParam("student_info_name", student.getName());

            intent.setParam("student_info_rollno", student.getRollno());

            intent.setParam("student_info_department", student.getDept());

            intent.setParam("student_info_college", student.getCollegename());

            intent.setParam("student_info_university", student.getUniversityname());

            Intent.OperationBuilder operationBuilder = new Intent.OperationBuilder();
            operationBuilder.withDeviceId("")
                    .withAbilityName(NextAbility.class.getName())
                    .withBundleName(getBundleName());
            intent.setOperation(operationBuilder.build());
            startAbility(intent);

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