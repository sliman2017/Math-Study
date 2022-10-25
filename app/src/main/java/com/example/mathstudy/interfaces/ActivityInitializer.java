package com.example.mathstudy.interfaces;

public interface ActivityInitializer {

    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    void initViews();
    /**
     * this function will contain all the listeners in this activity
     */
    void initListeners();

    void initVars();
    void initFunctionality();
}
