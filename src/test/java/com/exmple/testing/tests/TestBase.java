package com.exmple.testing.tests;

import com.exmple.testing.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = new ApplicationManager();
    }

    @After
    public void tearDown() {
        app.stop();
    }

}
