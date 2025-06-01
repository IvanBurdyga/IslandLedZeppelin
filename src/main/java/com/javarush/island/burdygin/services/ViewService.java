package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.api.view.View;

public class ViewService extends AbstractService {
    private final View view;

    public ViewService(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        view.show();
    }
}
