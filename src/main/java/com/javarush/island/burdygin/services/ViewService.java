package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.api.service.Service;
import com.javarush.island.burdygin.api.view.View;

public class ViewService implements Service {
    View view;

    public ViewService(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        view.show();
    }
}
