package com.example.intent_assignment.slice;

import com.example.intent_assignment.ResourceTable;
import com.example.intent_assignment.SecondAbility;
import com.example.intent_assignment.data.User;
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

    private static int ROLLNO_LENGTH= 5;


    private TextField studentName;
    private TextField departmentName;
    private TextField collegeName;
    private TextField universityName;
    private TextField rollNo;


    private Text studentNameError;
    private Text departmentNameError;
    private Text collegeNameError;
    private Text universityNameError;
    private Text rollNoError;
    private Button login;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        studentName = (TextField) findComponentById(ResourceTable.Id_Name);
        rollNo = (TextField) findComponentById(ResourceTable.Id_Rollno);
        departmentName= (TextField) findComponentById(ResourceTable.Id_Department);
        collegeName= (TextField) findComponentById(ResourceTable.Id_College);
        universityName= (TextField) findComponentById(ResourceTable.Id_University);
        login = (Button) findComponentById(ResourceTable.Id_button);
    }

    private void initListeners() {
        login.setClickedListener(component -> handleSubmitClick(component));
    }


    public void handleSubmitClick(Component component) {

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
                || universityName.getText().isEmpty()) {

            // toastDialog.setText(component.getContext().getString(Resource_Table)).show();

        } else {
            User user = new User();
            user.setStudentName(studentName.getText());
            user.setRollNo(rollNo.getText());
            user.setDepartmentName(departmentName.getText());
            user.setCollegeName(collegeName.getText());
            user.setUniversityName(universityName.getText());

            Intent intent = new Intent();
            intent.setParam("user_info_name", user.getStudentName());
            intent.setParam("user_info_roll", user.getRollNo());
            intent.setParam("user_info_Department", user.getDepartmentName());
            intent.setParam("user_info_college", user.getCollegeName());
            intent.setParam("user_info_university", user.getUniversityName());
            startAbility(intent);
            Intent.OperationBuilder operationBuilder = new Intent.OperationBuilder();
            operationBuilder.withDeviceId("")
                    .withAbilityName (SecondAbility.class.getName())
                    .withBundleName (getBundleName());
            intent.setOperation (operationBuilder.build());
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
