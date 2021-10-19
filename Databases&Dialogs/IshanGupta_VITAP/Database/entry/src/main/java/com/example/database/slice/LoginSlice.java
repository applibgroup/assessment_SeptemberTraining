package com.example.database.slice;

import com.example.database.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;
import ohos.data.rdb.RdbPredicates;
import ohos.data.rdb.RdbStore;
import ohos.data.rdb.ValuesBucket;

public class LoginSlice extends AbilitySlice {
    Button b1,b2;
    TextField e,p;
    String TABLENAME="user";
    RdbStore db;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_login);
        b1=(Button) findComponentById(ResourceTable.Id_lgnbtn);
        b2=(Button) findComponentById(ResourceTable.Id_stwbtn);
        e=(TextField) findComponentById(ResourceTable.Id_lemail);
        p=(TextField) findComponentById(ResourceTable.Id_lpass);
        b1.setClickedListener(component -> checkit(component));
        b2.setClickedListener(component -> swtsgn(component));

    }

    private void checkit(Component component) {
        RdbPredicates rp=new RdbPredicates(TABLENAME).equalTo("email", e.getText());
        rp.equalTo("password", String.valueOf(p));
        RdbPredicates rdbPredicates = new RdbPredicates(TABLENAME).equalTo("email", e.getText());
        ValuesBucket valuesBucket = new ValuesBucket();
        valuesBucket.putString("password",p.getText());

        db.update(valuesBucket, rdbPredicates);
    }

    private void swtsgn(Component component) {
        Intent intent = new Intent();
        present(new MainAbilitySlice(),intent);
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
