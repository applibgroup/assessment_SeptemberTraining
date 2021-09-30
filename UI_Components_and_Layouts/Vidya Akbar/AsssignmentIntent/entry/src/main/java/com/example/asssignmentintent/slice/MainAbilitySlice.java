package com.example.asssignmentintent.slice;

import com.example.asssignmentintent.ResourceTable;
import com.example.asssignmentintent.SecondAbility;
import com.example.asssignmentintent.data.User;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

public class MainAbilitySlice extends AbilitySlice {





    private TextField firstName;

    private TextField roll;

    private TextField dept;

    private TextField collegename;

    private TextField universityname;


    private Button submit;


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_register);
        initViews();

        initListeners();
    }

    private void initViews() {

        firstName= (TextField) findComponentById(ResourceTable.Id_studname);
        roll = (TextField) findComponentById(ResourceTable. Id_rollno);
        dept= (TextField) findComponentById(ResourceTable. Id_Deptname);
        collegename = (TextField) findComponentById(ResourceTable. Id_clgname);
        universityname = (TextField) findComponentById(ResourceTable.Id_universe);
        submit= (Button) findComponentById(ResourceTable. Id_button);


}
    private void initListeners() {
        submit.setClickedListener(component ->handleSubmitClick(component));

    }

    public void handleSubmitClick(Component component) {

        ToastDialog toastDialog = new ToastDialog(component.getContext());

        if (firstName.getText() == null

                || roll.getText() == null

                || dept.getText() == null

                || collegename.getText() == null

                || universityname.getText() == null

                || firstName.getText().isEmpty()

                || dept.getText().isEmpty()

                || collegename.getText().isEmpty()

                || universityname.getText().isEmpty()) {

           // toastDialog.setText(component.getContext().getString(ResourceTable.String_submit_error)).show();
            new ToastDialog(getContext()).setText("Please provide all field information").show();

        } else {


            User user = new User();

            user.setFirstName(firstName.getText());

            user.setRoll(roll.getText());

            user.setDept(dept.getText());

            user.setcollegename(collegename.getText());

            user.setuniversityname(universityname.getText());

            Intent intent = new Intent();

            intent.setParam("user_info_name", user.getFirstName());

            intent.setParam("user_info_roll", user.getRoll());

            intent.setParam("user_info_Department", user.getDept());

            intent.setParam("user_info_college", user.getcollegename());

            intent.setParam("user_info_university", user.getuniversityname());

            Intent.OperationBuilder operationBuilder = new Intent.OperationBuilder();
            operationBuilder.withDeviceId("")
                    .withAbilityName(SecondAbility.class.getName())
                    .withBundleName(getBundleName());
            intent.setOperation(operationBuilder.build());
            startAbility(intent);

            //present (new UserInfoAbilitySlice (), intent);

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
