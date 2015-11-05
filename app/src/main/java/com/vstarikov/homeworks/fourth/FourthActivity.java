package com.vstarikov.homeworks.fourth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.vstarikov.homeworks.R;

/**
 * Created by Starikov on 26.10.15.
 * У нас є актівіті яка наслідує BaseActivity і всередині неї в на крутяться фрагменти,
 * які можуть викликати методи інтерфейсу SelectorInterface next() і previous(),
 * кнопками які знаходяться на цих фрагментах переходячи на інші фпвнменти
 */
public class FourthActivity extends BaseActivity implements SelectorInterface {

    @Override
    boolean isAddFragment() {
        return true;
    }

    @Override
    void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fragmentContainer, new FirstFragment()).commit();
    }

    @Override
    public void next() {
        Fragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", "Next Fragment");
        fragment.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void previous() {
        Fragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", "Previous Fragment");
        fragment.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}
