package com.example.intents.slice;

import com.example.intents.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.RadioButton;
import ohos.agp.components.TextField;

public class MainAbilitySlice extends AbilitySlice {
    TextField n,r,d,c,u;
    Button bt;
    RadioButton r1,r2;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        n=(TextField) findComponentById(ResourceTable.Id_stuname);
        d=(TextField) findComponentById(ResourceTable.Id_studeptname);
        r=(TextField) findComponentById(ResourceTable.Id_sturollno);
        c=(TextField) findComponentById(ResourceTable.Id_stucollegename);
        u=(TextField) findComponentById(ResourceTable.Id_stuunivname);
        bt=(Button) findComponentById(ResourceTable.Id_signbtn);
        r1=(RadioButton) findComponentById(ResourceTable.Id_rb1);
        r2=(RadioButton) findComponentById(ResourceTable.Id_rb2);
        bt.setClickedListener(component -> handleSubmit(component));
    }

    private void handleSubmit(Component component) {
        Intent intent = new Intent();
        intent.setParam("A",n.getText().toString());
        intent.setParam("B",d.getText().toString());
        intent.setParam("C",r.getText().toString());
        intent.setParam("D",u.getText().toString());
        present(new IdCardSlice(),intent);
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
