package com.example.intents_and_serialization.slice;

import com.example.intents_and_serialization.ResourceTable;
import com.example.intents_and_serialization.SecondAbility;
import com.example.intents_and_serialization.data.User;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;


public class MainAbilitySlice extends AbilitySlice {
    private static String GENDER_MALE = "M";

    private static String GENDER_FEMALE = "F";

    private TextField studentName;
    private TextField rollNo;
    private TextField departmentName;
    private TextField collegeName;
    private TextField universityName;
    private Button signup;

    //private Text studentNameError;
    //private Text rollNoError;
    //private Text departmentNameError;
    //private Text collegeNameError;
    //private Text universityNameError;


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initViews();
        initListeners();
    }

    private void initViews() {
        studentName = (TextField) findComponentById(ResourceTable.Id_Name);
        rollNo = (TextField) findComponentById(ResourceTable.Id_RollNo);
        departmentName = (TextField) findComponentById(ResourceTable.Id_DepartmentName);
        collegeName = (TextField) findComponentById(ResourceTable.Id_CollegeName);
        universityName = (TextField) findComponentById(ResourceTable.Id_UniversityName);
        signup = (Button) findComponentById(ResourceTable.Id_signup);
    }

    private void initListeners() { signup.setClickedListener(component -> handleClickSubmit(component)); }

    public void handleClickSubmit (Component component) {
        ToastDialog toastDialog = new ToastDialog(component.getContext());
        if (studentName.getText() == null
                || rollNo.getText() == null
                || departmentName.getText() == null
                || collegeName.getText() == null
                || universityName.getText() == null
                || studentName.getText().isEmpty()
                || rollNo.getText().isEmpty()
                || departmentName.getText().isEmpty()
                || collegeName.getText().isEmpty()
                || universityName.getText().isEmpty()
        )
        {
            //toastDialog.setText(component.getContext().getString(Resource_Table)).show();
        }

        else{
            User user = new User();
            user.setStudentName(studentName.getText());
            user.setRollNo(rollNo.getText());
            user.setDepartmentName(departmentName.getText());
            user.setCollegeName(collegeName.getText());
            user.setUniversityName(universityName.getText());
            Intent intent = new Intent();
            intent.setParam("user_studentName", user.getStudentName());
            intent.setParam("user_rollNo", user.getRollNo());
            intent.setParam("user_departmentName", user.getDepartmentName());
            intent.setParam("user_collegeName", user.getCollegeName());
            intent.setParam("user_universityName", user.getUniversityName());
            startAbility(intent);
            Intent.OperationBuilder operationBuilder = new Intent.OperationBuilder();
            operationBuilder.withDeviceId("")
                    .withBundleName(getBundleName())
                    .withAbilityName(SecondAbility.class.getName());
            intent.setOperation(operationBuilder.build());
            startAbility(intent);

        }
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
