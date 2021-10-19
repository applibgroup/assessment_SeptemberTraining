package com.example.database.slice;

import com.example.database.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.CommonDialog;
import ohos.agp.window.dialog.IDialog;
import ohos.data.rdb.RdbStore;
import ohos.data.rdb.ValuesBucket;

import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;

public class MainAbilitySlice extends AbilitySlice {
    Button b1,b2,b3;
    TextField n,e,p,cp;
    private RdbStore db;
    String TABLENAME="user";
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        b1=(Button) findComponentById(ResourceTable.Id_rstbtn);
        b2=(Button) findComponentById(ResourceTable.Id_signbtn);
        b3=(Button) findComponentById(ResourceTable.Id_stwbtn);
        n=(TextField) findComponentById(ResourceTable.Id_usrname);
        e=(TextField) findComponentById(ResourceTable.Id_usremail);
        p=(TextField) findComponentById(ResourceTable.Id_usrpass);
        cp=(TextField) findComponentById(ResourceTable.Id_usrcpass);
        b1.setClickedListener(component -> clearit(component));
        b2.setClickedListener(component -> adddata(component));
        b3.setClickedListener(component -> switchlogin(component));
    }

    private void adddata(Component component) {
        insertData();
    }

    private void insertData() {
        ValuesBucket valuesBucket =  new ValuesBucket();
        valuesBucket.putString("name", n.getText());
        valuesBucket.putString("email", e.getText());
        valuesBucket.putString("password", p.getText());
        db.insert(TABLENAME, valuesBucket);

    }

    private void switchlogin(Component component) {
        Intent intent = new Intent();
        present(new LoginSlice(),intent);
    }

    private void clearit(Component component) {
        showCommonDialog();
    }

    private void showCommonDialog() {
        CommonDialog cd= new CommonDialog(this);
        cd.setTitleText("Reset?");
        cd.setContentText("Do you want to Reset all fields?");
        cd.setAutoClosable(true);
        cd.setSize(MATCH_CONTENT,MATCH_CONTENT);
        cd.setButton(IDialog.BUTTON1,"Yes",(iDialog,i)->{
            n.setText("");
            e.setText("");
            p.setText("");
            cp.setText("");
            iDialog.destroy();
        });
        cd.setButton(IDialog.BUTTON2,"No",(iDialog,i)->{
            iDialog.destroy();
        });
        cd.show();
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
